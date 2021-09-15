package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.lib.Book;
import ru.pa4ok.demoexam.lib.Library;

import java.nio.file.Path;

public class Test
{
    //public static Library lib = createLib();
    public static Library lib;

    static {
        lib = new Library("owifvowifef");
        lib.setBooks(new Book[] {
                //...
        });
        //...
    }

    private static Library createLib() {
        return new Library("dqwqdqdqwd");
    }
}
