package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
 */
public class App
{
     /*
        Book
        - String title (>3 & <20 символов)
        - String author (>3 & <20 символов)
        - int pages (>0)

        Library
        - String address
        - Book[] books
        - public void readBook() throws BookReadException, LibrarySpaceException
            метод должен запрашивать у пользователя все поля книги и создавать из них ее объект после чего добавлять в библиотеку
            если пользователь вводит неверные значения выбрасывать BookReadException
            если после чтения полей в бибилиотеке нет места то выбрасывать LibrarySpaceException

        BookReadException extends Exception

        LibrarySpaceException extends Exception
        - Book book
     */

    public static void main(String[] args)
    {
        Library lib = new Library(
                "ewpofjepwofjwf",
                new Book[]{
                        null,
                        new Book("t1", "a1", 10),
                        null
                }
        );

        while (true) {
            try {
                lib.readBook();
            } catch (BookReadException e) {
                e.printStackTrace();
            } catch (LibrarySpaceException e) {
                System.out.println("место кончилось на книне: " + e.getBook());
                break;
            }
        }
    }
}
