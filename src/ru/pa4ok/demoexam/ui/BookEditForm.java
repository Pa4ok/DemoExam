package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.ui.MainForm;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookEditForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField dateField;
    private JButton saveButton;
    private JSpinner pageSpinner;
    private JComboBox typeBox;
    private JButton backButton;
    private JTextField idField;
    private JButton deleteButton;

    private BookEntity book;

    public BookEditForm(BookEntity book)
    {
        super(450, 275);
        this.book = book;
        setContentPane(mainPanel);

        initFields();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setEditable(false);
        idField.setText(String.valueOf(book.getId()));
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        pageSpinner.setValue(book.getPages());
        dateField.setText(App.DATE_FORMAT.format(book.getWriteDateTime()));
    }

    private void initBoxes()
    {
        typeBox.addItem("FIRST");
        typeBox.addItem("SECOND");
        typeBox.addItem("THIRD");

        typeBox.setSelectedItem(book.getType());
    }

    private void initButtons()
    {
        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            if(title.isEmpty() || title.length() > 50) {
                DialogUtil.showError(this, "Название не введено или оно слишком длинное");
                return;
            }

            String author = authorField.getText();
            if(author.isEmpty() || author.length() > 50) {
                DialogUtil.showError(this, "Автор не введен или он слишком длинный");
                return;
            }

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество стриниц ввдено неверно");
                return;
            }

            Date date = null;
            try {
                date = App.DATE_FORMAT.parse(dateField.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Дата введена в неправильно, корректный формат: dd.MM.yyyy hh:mm");
                return;
            }

            book.setTitle(title);
            book.setAuthor(author);
            book.setPages(pages);
            book.setWriteDateTime(date);
            book.setType((String) typeBox.getSelectedItem());

            try {
                BookEntityManager.update(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных");
                ex.printStackTrace();
                return;
            }

            DialogUtil.showInfo(this, "Книжка успешно отредактирована");
            dispose();
            new MainForm();
        });

        deleteButton.addActionListener(e -> {
            if(JOptionPane.showConfirmDialog(
                    this,
                    "Вы точно хотите удалить данную книжку?",
                    "Подтверждение",
                    JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                try {
                    BookEntityManager.delete(book);
                    DialogUtil.showInfo(this, "Книжка успешно удалена");
                    dispose();
                    new MainForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Ошибка удаления данных: " + ex.getMessage());
                }
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
