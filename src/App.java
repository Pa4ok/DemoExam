import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * cntl + space - контекстное меню с полями и методами объекта
 */

public class App
{
    /*
        реализовать и протестировать функцию сортировки int массива
        +вывод до и после сортировки в консоль
     */

    public static void main(String[] args)
    {
        /*int i = 2_000_000_000;
        float f = 44.343F;
        double d = 342.3525D;
        boolean b = true;
        char c = 'п';
        long l = 1_000_000_000_000_000_000L;
*/
        //int i1; //0
        //String s1; //null

        /*Integer integer; //null
        Float float1;
        Double double1;
        Boolean boolean1;
        Character character;
        Long long1;*/

        /*String s; //null
        String s1 = "owefowefweof3424";
        System.out.println(s1.substring(0, 5));
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.charAt(2));
        System.out.println(s1.length());
        System.out.println(s1.replaceAll("we", "AA"));*/

        /*for(int i=0; i<10; i++) {
            if(i % 2 == 0) {
                System.out.printf(i + " ");
            }

        }*/

        /*int i = 10;
        System.out.println(i % 2 == 0 ? "a" : "b");*/

        //int[] arr; //null
        int[] arr1 = new int[10];
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};

        //printArray(arr2);
        /*System.out.println(Arrays.toString(arr2));
        incrementArray(arr2);
        System.out.println(Arrays.toString(arr2));

        int test = 5;
        test(test);
        System.out.println(test);*/

        for(int i : arr2) {
            System.out.println(i);
        }
    }

    public static void printArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    public static void incrementArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            arr[i]++;
        }
    }

    public static void test(int i)
    {
        i++;
    }
}
