import java.util.Arrays;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            создать int массив заполнить его значению
            передать в функцию sortArray и отсортировать в ней
            +вывод в консоль до и после сортировки
        */

        Random rand = new Random();
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt(1000));
        //String s = Arrays.toString(arr);
    }

    public static void sortArray(int[] arr)
    {
        //...
    }
}
