package ru.pa4ok.demoexam.util;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class CustomTableModel<T> extends AbstractTableModel
{
    private Class<T> cls;
    private String[] columnNames;
    private List<T> rows;

    public CustomTableModel(Class<T> cls, String[] columnNames, List<T> rows) {
        this.cls = cls;
        this.columnNames = columnNames;
        this.rows = rows;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cls.getDeclaredFields().length;
    }

    @Override
    public String getColumnName(int column) {
        return column < columnNames.length ? columnNames[column] : "Column title";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return cls.getDeclaredFields()[columnIndex].getType();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            T t = rows.get(rowIndex);
            Field field = cls.getDeclaredFields()[columnIndex];
            field.setAccessible(true);
            return field.get(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
