import java.util.Arrays;
import java.util.Random;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            создать int массив
            создать функцию randArray которая принимает массив и заполняет его рандомными значениями
            создать функцию sortArray которая принимает массив и сортирует его любым алгоритмом
         */

        int[] arr = new int[10];
        System.out.println(Arrays.toString(arr));
        randArray(arr);
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void randArray(int[] arr)
    {
        Random rand = new Random();
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    public static void sortArray(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
