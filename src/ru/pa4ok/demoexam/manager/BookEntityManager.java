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
        //получаем соединение, все что в try() в любом случае по окончанию блока будет закрыто
        try(Connection c = App.getConnection())
        {
            //строковый запрос, вместо всех подставляемых данных ?
            String sql = "INSERT INTO books(title, author, pages) VALUES(?,?,?)";

            //получаем PreparedStatement, отправляем в него строковый запрос
            //RETURN_GENERATED_KEYS нужен чтобы потом получить генерируемые базовый ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //заменяем ? на данные
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());

            //выполняем запрос
            ps.executeUpdate();

            //получаем набор записей с ключами
            ResultSet resultSet = ps.getGeneratedKeys();
            //проверяем, что есть хотя бы 1 запись и сразу переключаемся на нее
            if(resultSet.next()) {
                //получаем из записи ключ и устанавливаем его в сущность
                book.setId(resultSet.getInt(1));
                return;
            }

            //если нет ни 1 ключа, дропаем ошибку
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
                        resultSet.getString("author"),
                        resultSet.getString("title"),
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
                        resultSet.getString("author"),
                        resultSet.getString("title"),
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
