package ru.pa4ok.table.util;

import lombok.Getter;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

/**
 * ЭТА МОДЕЛЬ ТАБЛИЦЫ ПОДОЙДЕТ ТЕБЕ !!!ТОЛЬКО!!!
 * ЕСЛИ ТЫ ПОНИМАЕШЬ ЧТО ПИШЕШЬ
 * И ПОНИМАЕШЬ ЧТО ТУТ ПРОИСХОДИТ
 *
 * ЧЕРЕЗ НЕЕ ЛЕГКО РЕАЛИЗУЮТСЯ КАСТОМНЫЕ ФИЛЬТРАЦИИ, ПОИСК И ВСЕ ОСТАЛЬНОЕ
 */
@Getter
public class ExtendedTableModelWithDocs<T> extends AbstractTableModel
{
    /**
     * класс для работы с рефлексией
     * и массив строк для названий колонок
     */
    private Class<T> cls;
    private String[] columnNames;

    /**
     * теперь 2 колекции
     * в 1 все строки, во 2 отфильтрованные и отсортированные
     */
    private List<T> allRows = new ArrayList<>();
    private List<T> filteredRows;

    /**
     * массив предикатов (просто интерфейс с генериком и boolean в return'е)
     * в нем хранятся все фильтры, как для поиска, так и для обычных фильтраций
     */
    private Predicate<T>[] filters = new Predicate[10];

    /**
     * Компаратор под активную сортировку
     */
    private Comparator<T> sorter;

    public ExtendedTableModelWithDocs(Class<T> cls, String[] columnNames)
    {
        this.cls = cls;
        this.columnNames = columnNames;
    }

    /**
     * метод для обновления колеции с отфильроваными записями
     * копирует записи и применяет все фильтры и сортировку
     */
    public void updateFilteredRows()
    {
        filteredRows = new ArrayList<>(allRows);

        for(Predicate<T> filter : filters) {
            if(filter != null) {
                filteredRows.removeIf(row -> !filter.test(row));
            }
        }
        if(sorter != null) {
            Collections.sort(filteredRows, sorter);
        }

        /**
         * вызов метода ивента с обновлением (см.ниже)
         * и обновление отрисовки самой таблицы
         */
        fireTableDataChanged();
        onUpdateRowsEvent();
    }

    /**
     * пустой метод ивент
     * переопределяется при создании самой модели
     * нужен для обновления лейбла с колвом записей
     */
    public void onUpdateRowsEvent() {
    }

    @Override
    public int getRowCount() {
        return filteredRows.size();
    }

    @Override
    public int getColumnCount() {
        return cls.getDeclaredFields().length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return cls.getDeclaredFields()[columnIndex].getType();
    }

    /**
     * если нет элемента в массиве с названиями
     * теперь берется имя поля из класса
     */
    @Override
    public String getColumnName(int column) {
        return columnNames.length <= column ? cls.getDeclaredFields()[column].getName() : columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Field field = cls.getDeclaredFields()[columnIndex];
            field.setAccessible(true);
            return field.get(this.filteredRows.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    /**
     * в сеттерах сразу вызывается обновление
     * чтобы не делать это из формы
     */
    public void setAllRows(List<T> allRows) {
        this.allRows = allRows;
        this.updateFilteredRows();
    }

    public void setSorter(Comparator<T> sorter) {
        this.sorter = sorter;
        this.updateFilteredRows();
    }
}