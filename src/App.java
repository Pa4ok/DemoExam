import java.util.Arrays;
import java.util.Random;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*int i = 2_000_000_000;
        float f = 34343.5F;
        double d = 43434.444D;
        boolean b = true;
        char c = 'Ы';
        long l = 1_000_000_000_000_000_000L;*/

        //int[] arr; //null
        //int[] arr1 = new int[10];
        //int[] arr = {1,2,3,4,5,6,7};
        //int i = 5;

        /*for(int i=0; i<arr1.length; i++) {
            System.out.printf(arr1[i] + " ");
        }
        System.out.println();*/

        /*System.out.println(Arrays.toString(arr1));
        System.out.println(i);

        increment(i);
        incrementArray(arr1);

        System.out.println(Arrays.toString(arr1));
        System.out.println(i);
        */

        /*for(int i : arr) {
            System.out.println(i);
        }*/

        /*String s = "342423423rtegergerjIOEH";
        System.out.println(s.length());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(3, 8));
        System.out.println(s.startsWith("123"));
        System.out.println(s.endsWith("OEH"));\
        */

        /*int[] arr1 = new int[10];
        String[] arr2 = new String[10];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));*/

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);
        System.out.println(i1 + " " + i2);

        /*
            создать int массив
            сделать функцию которая принимает массив и заполняет его рандомными числами
            сделать функцию которая принимает массив и сортирует его любым алгоритмом
            протестить все это дело
         */
    }

    public static void increment(int i)
    {
        i++;
    }

    public static void incrementArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            arr[i]++;
        }
    }

    public static void test1(int[][][][] arr) {
    }

    public static int[][][][] test2() {
        return null;
    }
}
