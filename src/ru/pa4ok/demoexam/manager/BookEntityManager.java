package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

public class BookEntityManager
{
    public static void insert(BookEntity book) throws SQLException
    {
        //все что объявляется в try() будет автоматически закрыто (вместо c.close)
        try(Connection c = App.getConnection())
        {
            //строковый запрос, вместо подставляемых данных ?
            String sql = "INSERT INTO books(title, author, pages) VALUES(?,?,?)";

            //создаем PreparedStatement и заменяем ? на данные
            //RETURN_GENERATED_KEYS нужен для того чтобы вернуть сгенерированные базой ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());

            //выполнение запроса
            ps.executeUpdate();

            //получение сгенерированных ключей
            ResultSet keys = ps.getGeneratedKeys();
            //проверка что есть хотя бы 1 запись
            if(keys.next()) {
                //получение первого ключа из записи
                book.setId(keys.getInt(1));
                return;
            }

            //если нет никаких ключей, выбрасываем ошибку
            throw new SQLException("entity not added");
        }
    }
}
