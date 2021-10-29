package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookEntityManager
{
    public static void insert(BookEntity book) throws SQLException
    {
        //получаем соединение, что в скобках блока try будет по выходу из него автоматически закрыто (вместо c.close)
        try(Connection c = App.getConnection())
        {
            //строковый запрос, вместо всех данных ?
            String sql = "INSERT INTO books(title, author, pages) VALUE(?,?,?)";

            //получаем объект PreparedStatement, передаем туда строковый запрос
            //RETURN_GENERATED_KEYS нужен чтобы потом получить все сгенерированные базой ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //заменяем ? на данные
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());

            //выполняем запрос
            ps.executeUpdate();

            //получаем сгенерированные базой ключи
            ResultSet keys = ps.getGeneratedKeys();
            //проверяем что есть хотя бы 1 запись с ключами
            if(keys.next()) {
                //достаем из нее первый ключ и устанавливаем в сущность
                book.setId(keys.getInt(1));
                return;
            }

            //если ни 1 ключа не было, дропаем ошибку
            throw new SQLException("entity not added");
        }
    }

    public static BookEntity selectById(int id) throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "SELECT * FROM books WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return new BookEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getInt("pages")
                );
            }

            return null;
        }
    }

    public static List<BookEntity> selectAll() throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "SELECT * FROM books";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<BookEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new BookEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getInt("pages")
                ));
            }

            return list;
        }
    }

    public static void update(BookEntity book) throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "UPDATE books SET title=?, author=?, pages=? WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setInt(4, book.getId());

            ps.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static void delete(BookEntity book) throws SQLException
    {
        delete(book.getId());
    }
}
