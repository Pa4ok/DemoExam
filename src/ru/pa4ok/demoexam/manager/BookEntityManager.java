package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

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
}
