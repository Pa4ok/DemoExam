package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

public class BookEntityManager
{
    public static void add(BookEntity book) throws SQLException
    {
        //try с круглыми скобками служит для корректного автозакрытия соединения (вместо c.close)
        try(Connection c = App.getConnection())
        {
            //строковые запрос, вопросы вместе всех заполняемых данных
            String sql = "INSERT INTO book(title, author, pages) VALUES (?,?,?)";

            //PreparedStatement.RETURN_GENERATED_KEYS для того чтобы вернуть все генерируемые базой ключи
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //замена вопросов на данные
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            //ps.setDouble(x, 3.4D);
            //для символа нужно кидать строку, длиной 1
            //ps.setString(4, "abc".substring(0, 1));
            //ps.setString(5, "f");

            //выполнение запроса
            ps.executeUpdate();

            //получение набора сгенерированных ключей
            ResultSet keys = ps.getGeneratedKeys();
            //проверка, на то что есть хотя бы 1 ключ
            if(keys.next()) {
                //получение ключа и установка его в сущность
                book.setId(keys.getInt(1));
                return;
            }

            //если не было ни 1 ключа - выбрасываем ошибку
            throw new SQLException("entity not added");
        }
    }
}
