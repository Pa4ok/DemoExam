package ru.pa4ok.demoexam;

public class Book
{
    public static int testStaticField = 5;

    //статичный блок, выполняется единожды при загрзке класса в ситему (при 1 обращении к нему)
    static {
        System.out.println("class Book loaded");
    }

    public String title;

    public Book(String title) {
        this.title = title;
    }

    public static void testStaticMethod() {
        System.out.println("123");
        //System.out.println(title);
    }

    public void test()
    {
        System.out.println(testStaticField);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
