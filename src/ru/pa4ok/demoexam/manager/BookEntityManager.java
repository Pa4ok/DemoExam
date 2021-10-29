package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

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
}
