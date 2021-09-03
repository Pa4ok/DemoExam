import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*int i = 2_000_000_000;
        float f = 23234.4F;
        double d = 34234.3424D;
        boolean b = true;
        char c = 'Ы';
        long l = 1_000_000_000_000_000_000L;*/

        //int[] arr1; //null
        /*int intValue = 10;
        int[] arr1 = new int[10];
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};

        //System.out.println(arr1);
        System.out.println(intValue);
        for(int i=0; i<arr1.length; i++) {
            System.out.printf(arr1[i] + " ");
        }
        System.out.println();

        test(arr1);
        test1(intValue);
        System.out.println();

        System.out.println(intValue);
        for(int i=0; i<arr1.length; i++) {
            System.out.printf(arr1[i] + " ");
        }
        System.out.println();*/

        /*
            создать массив int
            сделать функцию которая будет заполнять его какими-то значениями
            сделать функцию которая будет сортировать этот массив
            сделать функцию которая будет выводить массив в консоль 1 строчкой
         */

        int[] arr = new int[10];
        /*printArray(arr);
        fillArray(arr);
        printArray(arr);
        sortArray(arr);
        printArray(arr);
        */

        /*fillArray(arr);
        for(int i : arr) {
            System.out.println(i);
        }*/

        /*String s = "32432o4h2hEFEWF32f";
        System.out.println(s.substring(3, 8));
        System.out.println(s.length());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.endsWith("32f"));
        System.out.println(s.charAt(8));

        s += "eflmewfew";
        s += '%';

        System.out.println(s);*/

        //java 15+
        String textBlock = """
                <html>
                    ...
                </html>
                """;
    }

    public static void fillArray(int[] arr)
    {
        Random rand = new Random();
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    public static void printArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
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

    public static void test(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            arr[i]++;
        }
    }

    public static void test1(int i)
    {
        i++;
    }
}
