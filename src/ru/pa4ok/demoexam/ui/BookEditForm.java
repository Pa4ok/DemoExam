package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class BookEditForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JButton saveButton;
    private JSpinner pageSpinner;
    private JButton backButton;
    private JTextField idField;
    private JTextField dateField;
    private JButton deleteButton;

    private BookEntity book;

    public BookEditForm(BookEntity book)
    {
        super(420, 250);
        this.book = book;
        setContentPane(mainPanel);

        this.initFields();
        this.initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setText(String.valueOf(book.getId()));
        idField.setEditable(false);
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        pageSpinner.setValue(book.getPages());
        dateField.setText(App.DATE_FORMAT.format(book.getWriteDateTime()));
    }

    private void initButtons()
    {
        saveButton.addActionListener(e ->
        {
            String title = titleField.getText();
            String author = authorField.getText();

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество страниц введено неверно");
                return;
            }

            Date date = null;
            try {
                date = App.DATE_FORMAT.parse(dateField.getText());
            } catch (ParseException ex) {
                DialogUtil.showError(this, "Дата введена неверно");
                return;
            }

            book.setTitle(title);
            book.setAuthor(author);
            book.setPages(pages);
            book.setWriteDateTime(date);

            try {
                BookEntityManager.update(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            DialogUtil.showInfo(this, "Книжка успешно отредактирована");
            dispose();
            new BookTableForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new BookTableForm();
        });

        deleteButton.addActionListener(e ->
        {
            if(JOptionPane.showConfirmDialog(this, "Вы точно хотите удалить эту книгу?", "Подтверждение", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
                try {
                    BookEntityManager.delete(book);
                    DialogUtil.showInfo(this, "Книжка удалена успешно");
                    dispose();
                    new BookTableForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Ошибка удаления данных: " + ex.getMessage());
                }
            }
        });
    }
}
