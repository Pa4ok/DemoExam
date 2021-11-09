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
        //получаем соединение с базой
        //все что в скобках try будет автоматически закрыто по выходу из блока (вместо c.close)
        try(Connection c = App.getConnection())
        {
            //строковый запрос, вместе всех подставляемых данных ?
            String sql = "INSERT INTO books(title, author, pages, writeDateTime) VALUES(?,?,?,?)";

            //получаем объект PreparedStatement, передаем в него строковый запрос
            //RETURN_GENERATED_KEYS нужен чтобы потом получить сгенерированные базой ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //заменяем ? на данные
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setTimestamp(4, new Timestamp(book.getWriteDateTime().getTime()));

            //выполняем запрос
            ps.executeUpdate();

            //получаем набор записей с сгенерированными базой ключами
            ResultSet keys = ps.getGeneratedKeys();
            //проверяем, что есть хотя бы 1 запись и переключаемся на нее
            if(keys.next()) {
                //получаем из записи 1 ключ и устанавливаем его в сущность
                book.setId(keys.getInt(1));
                return;
            }

            //если из базы не вернулось ни 1 ключа, дропаем ошибку
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
                        resultSet.getInt("pages"),
                        resultSet.getTimestamp("writeDateTime")
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
                        resultSet.getInt("pages"),
                        resultSet.getTimestamp("writeDateTime")
                ));
            }

            return list;
        }
    }

    public static void update(BookEntity book) throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "UPDATE books SET title=?, author=?, pages=?, writeDateTime=? WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setTimestamp(4, new Timestamp(book.getWriteDateTime().getTime()));
            ps.setInt(5, book.getId());

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
