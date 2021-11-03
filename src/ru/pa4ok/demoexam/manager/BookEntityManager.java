package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

public class BookEntityManager
{
    public static void insert(BookEntity book) throws SQLException
    {
        //получаем соединение
        //все что в круглых скобках try будет автоматически закрыто по выходу из блока (вместо c.close())
        try(Connection c = App.getConnection())
        {
            //строковы запрос, вместо всех подставляемых данных ?
            String sql = "INSERT INTO books(title, author, pages) VALUES(?,?,?)";

            //получаем объект PreparedStatement
            //RETURN_GENERATED_KEYS нужен чтобы потом получить сгенерированные базой ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //замена ? на данные
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());

            //выполнение запроса
            ps.executeUpdate();

            //получение набора сгенерированных клюей
            ResultSet keys = ps.getGeneratedKeys();
            //проверка и переключение на 1 запись с ключами
            if(keys.next()) {
                //получение 1 ключа
                book.setId(keys.getInt(1));
                return;
            }

            //если записей с ключами не вернулось, дропаем ошибку
            throw new SQLException("entity not added");
        }
    }
}
