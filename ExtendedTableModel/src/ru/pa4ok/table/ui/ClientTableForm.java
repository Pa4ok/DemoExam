package ru.pa4ok.table.ui;

import ru.pa4ok.table.entity.ClientEntity;
import ru.pa4ok.table.manager.ClientEntityManager;
import ru.pa4ok.table.util.BaseForm;
import ru.pa4ok.table.util.ExtendedTableModelWithDocs;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.function.Predicate;

public class ClientTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JTextField searchField;
    private JComboBox<String> genderFilterBox;
    private JButton birthdaySortButton;
    private JButton regDateSortButton;
    private JButton clearButton;
    private JLabel rowCountLabel;

    private ExtendedTableModelWithDocs<ClientEntity> model;

    public ClientTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        this.initTable();
        this.initFilterElements();
        this.initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30);

        try {
            model = new ExtendedTableModelWithDocs<>(ClientEntity.class, new String[] { "ID", "Имя", "Фамилия", "Отчество", "Дата рождения", "Дата регистрации", "Email", "Телефон", "Гендер", "Путь до картинки", "Картинка" } ) {
                @Override
                public void onUpdateRowsEvent() {
                    rowCountLabel.setText("Записей: " + model.getFilteredRows().size() + "/" + model.getAllRows().size());
                }
            };
            model.setAllRows(ClientEntityManager.selectAll());
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        TableColumn column = table.getColumn("Путь до картинки");
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);

        model.getFilters()[0] = new Predicate<ClientEntity>()
        {
            @Override
            public boolean test(ClientEntity clientEntity)
            {
                String searchText = searchField.getText();

                if(searchText == null || searchText.isEmpty()) {
                    return true;
                }

                String names = (clientEntity.getLastName() + " " + clientEntity.getFirstName() + " " + clientEntity.getPatronymic()).toLowerCase();
                return names.startsWith(searchText.toLowerCase());
            }
        };

        model.getFilters()[1] = new Predicate<ClientEntity>() {
            @Override
            public boolean test(ClientEntity clientEntity) {
                int selected = genderFilterBox.getSelectedIndex();
                if(selected == 1) {
                    return clientEntity.getGender().equals("мужской");
                } else if (selected == 2) {
                    return clientEntity.getGender().equals("женский");
                } else {
                    return true;
                }
            }
        };
    }

    private void initFilterElements()
    {
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model.updateFilteredRows();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model.updateFilteredRows();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                model.updateFilteredRows();
            }
        });

        genderFilterBox.addItem("Все элементы");
        genderFilterBox.addItem("мужской");
        genderFilterBox.addItem("женский");

        genderFilterBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    model.updateFilteredRows();
                }
            }
        });
    }

    private void initButtons()
    {
        birthdaySortButton.addActionListener(e -> model.setSorter(new Comparator<ClientEntity>() {
            @Override
            public int compare(ClientEntity o1, ClientEntity o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        }));

        regDateSortButton.addActionListener(e -> model.setSorter(new Comparator<ClientEntity>() {
            @Override
            public int compare(ClientEntity o1, ClientEntity o2) {
                return o1.getRegisterDate().compareTo(o2.getRegisterDate());
            }
        }));

        clearButton.addActionListener(e -> {
            searchField.setText("");
            genderFilterBox.setSelectedIndex(0);
            model.setSorter(null);
        });
    }
}
