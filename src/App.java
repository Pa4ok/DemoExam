import java.util.Arrays;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            создать int массив
            создать функцию, которая принимает массив и заполняет его рандомными значениями
            создать функцию, которая принимает массив и сортирует его любым алгоримтмом
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

