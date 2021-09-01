import java.util.Arrays;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * cntl + space - контекстное меню с полями и методами объекта
 */

public class App
{
    /*
        реализовать фунцию, создающую и возаращающую массив определенной длины (отправляет в аргументах функции)
        реализовать фунцию, заменяющую в массиве все отрицательные элементы на 0
        отсортирлвать массив функцией из предыдущего задания
        и вывести
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
        /*int[] arr1 = new int[10];
        int[] arr2 = {154, -3, 5, 4, 6, 84, -5};*/

        //printArray(arr2);
        /*System.out.println(Arrays.toString(arr2));
        incrementArray(arr2);
        System.out.println(Arrays.toString(arr2));

        int test = 5;
        test(test);
        System.out.println(test);*/

        /*for(int i : arr2) {
            System.out.println(i);
        }*/

        /*System.out.println(Arrays.toString(arr2));
        sortArray(arr2);
        System.out.println(Arrays.toString(arr2));*/

        //int[][] arr; //null
        //arr = new int[3][]; // [null,null,null]
        //for...

        int[] arr1 = getArray(10);
        int[][] arr = new int[3][3];

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);
        System.out.println(i1 + " " + i2);
    }

    public static int[] getArray(int size)
    {
        int[] arr = new int[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = i;
        }
        return arr;
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

    public static void sortArray(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++) {
            for (int j = i; j < arr.length ; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
