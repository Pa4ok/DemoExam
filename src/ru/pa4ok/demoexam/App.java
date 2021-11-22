package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.ui.MainForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

/**
 * библиотека-драйвер для субд mysql: mysql:mysql-connector-java:8.0.27
 * библиотека lombok: org.projectlombok:lombok:1.18.22
 *
 * готовая удаленная база mysql (если лень подымать свою):
 * адрес: 116.202.236.174:3306
 * название/пользователь/пароль: DemoExam
 * веб интерфейс: https://phpmy.pa4ok.ru/
 * !!!создавайте таблицы со своими названиями, чтобы не было путаницы!!!
 */

public class App
{
     /*
        берем первую базу, которую чинили (database-1)
        создаем сущность и менеджер под таблицу Client
        таблица уже в починенном виде есть на моем серверве

        делаем следующие формы

        MainForm
        содержит 4 кнопки, которые открывают дополнительные / полностью меняют форму
            список всех клиентов
            добавить нового клиента
            редактировать клиента (запросить id)
            удалить клиента (запросить id)

        ClientCreateForm
        форма создания нового клиента
        содержит все поля кроме id

        ClientEditForm
        форма редактирования клиента
        содержит все поля, поле id заблокировано для вводаЯ

        форму удаления можно не делать
        на момент ввода пользователем id проверить
        что такая запись существует и сразу удалить
     */

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //new BookCreateForm();
        new MainForm();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}

