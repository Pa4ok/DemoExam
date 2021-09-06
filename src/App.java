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
        int[] arr = new int[10];
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }

        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortArray(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
