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
        try(Connection c = App.getConnection())
        {
            String sql = "INSERT INTO books(title, author, pages, writeDateTime) VALUES(?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setTimestamp(4, new Timestamp(book.getWriteDateTime().getTime()));

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                book.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("entity not added");
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

    public static void delete(BookEntity book) throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, book.getId());
            ps.executeUpdate();
        }
    }
}
