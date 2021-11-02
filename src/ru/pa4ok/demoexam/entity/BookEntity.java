package ru.pa4ok.demoexam.entity;

import lombok.*;

import java.util.Date;

/**
 *  подключение библиотки через maven
 *  org.projectlombok:lombok:1.18.22
 *  ОБЯЗАТЕЛЬНО НАЛИЧИЕ ПЛАГИНА lombok в среде
 *
 *  @Data - включает в себя функционал всех 4 анотаций ниже
 *
 *  @Getter @Setter @ToString @EqualsAndHashCode
 *  поставленные к классу на этапе компиляции
 *  они генерирует соответствующие методы для вашего класса
 *
 *  @NoArgsConstructor и @AllArgsConstructor
 *  также добавляют в класс конструкторы без аргументов и на все аргументы
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;

    public BookEntity(String title, String author, int pages, Date writeDateTime) {
        this(-1, title, author, pages, writeDateTime);
    }
}
