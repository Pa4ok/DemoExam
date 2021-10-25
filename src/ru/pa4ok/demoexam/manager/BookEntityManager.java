package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

public class BookEntityManager
{
    public static void insert(BookEntity book) throws SQLException
    {
        //все что объявлено в try() по выходу из блока будет автоматически закрыто (вместо c.close())
        try(Connection c = App.getConnection())
        {
            //строковый запрос, вместо всех данных ?
            String sql = "INSERT INTO books(title, author, pages) VALUES(?,?,?)";

            //создаем PreparedStatement, заменяем все ? на данные
            //RETURN_GENERATED_KEYS нужен чтобы вернуть сгенерированные базой ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());

            //выполняем запрос
            ps.executeUpdate();

            //получаем сгенерированные базой ключи
            ResultSet keys = ps.getGeneratedKeys();
            //проверяем что есть хотя бы 1 ключ
            if(keys.next()) {
                //получаем и устанавливаем его в сущность
                book.setId(keys.getInt(1));
                return;
            }

            //если ключа не было, выкидываем ошибку
            throw new SQLException("entity not added");
        }
    }
}
