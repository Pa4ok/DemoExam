package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;

import java.sql.*;

public class BookEntityManager
{
    public static void insert(BookEntity book) throws SQLException
    {
        //все что объявляется в скобках try будет автоматически закрыто по выходу из блока
        //даже если была ошибка, делается вместо c.close()
        try(Connection c = App.getConnection())
        {
            //строковый запрос, вместо всех данных ?
            String sql = "INSERT INTO books(title, author, pages) VALUES(?,?,?)";

            //создаем PreparedStatement из строкового запроса
            //RETURN_GENERATED_KEYS нужен чтобы вернуть сгенерированные базой ключи (id...)
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //заменяем ? на данные (индексация с 1)
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());

            //выполняем запрос
            ps.executeUpdate();

            //получаем набор ключей, сгенерированных базой
            ResultSet keys = ps.getGeneratedKeys();
            //если есть хотя бы 1 запись, то переключаемся на нее
            if(keys.next()) {
                //получаем 1 ключ из записи и устанавливаем в сущность
                book.setId(keys.getInt(1));
                return;
            }

            //если ключей не было, сущность по какой-то причине в базу не добавлена, дропаем ошибку
            throw new SQLException("entity not added");
        }
    }
}
