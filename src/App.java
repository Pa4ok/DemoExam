import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*int i = 2_000_000_000;
        float f = 444.32432F;
        double d = 32423.4324D;
        boolean b = true;
        char c = 'щ';
        long l = 1_000_000_000_000_000_000L;

        Integer integer; //null
        Float float1 = 2434.343F;
        Double double1;
        Boolean boolean1;
        Character character;
        Long long1;*/

        /*String s = "wqefhqweoifhWFFwei";
        System.out.println(s.substring(1, 4));
        System.out.println(s.endsWith("wei"));
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.length());
        System.out.println(s.charAt(8));

        s += 324234;
        System.out.println(s);*/

        //String s1; //null
        //int[] arr; //null

        /*int[] arr1 = new int[10];
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};*/

        /*for(int i=0; i<arr1.length; i++) {
            System.out.printf(arr1[i] + " ");
        }
        System.out.println();*/

        //System.out.println(Arrays.toString(arr2));

        /*String str = Arrays.toString(arr2);
        System.out.println(str);*/

       /* for(int i : arr2) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }*/

        /*
            создать int массив, заполнить его элементами
            чтобы каждый последующий был на 2 больше предыдущего
            после этого каждый третий элемент массив умножить на 4
            +вывести массив после заполнения и его изменений
         */

        int[] arr = new int[20];
        for(int i=0; i<arr.length; i++) {
            arr[i] = 2 * i;
        }

        /*System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length; i++) {
            if(i % 3 == 0) {
                arr[i] *= 4;
            }
        }
        System.out.println(Arrays.toString(arr));*/

        System.out.println(Arrays.toString(arr));
        incrementArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        создать int массив заполнить его значению (вручную)
        передать в функцию sortArray и отсортировать в ней
        +вывод в консоль до и после сортировки
     */
    public static void sortArray(int[] arr)
    {
        //...
    }

    public static void incrementArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            arr[i]++;
        }
    }
}
