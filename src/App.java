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
        /*int i = 2_000_000_000;
        float f = 43242.4543F;
        double d = 324.34234D;
        boolean b = true;
        char c = 'Ы';
        long l = 1_000_000_000_000_000_000L;
*/
        //int[] arr; //null
        //int[] arr1 = new int[10];
        //int[] arr2 = {1,2,3,4,5,6,7};
        //int i = 5;


        /*for(int i1=0; i1<arr1.length; i1++) {
            System.out.printf(arr1[i1] + " ");
        }
        System.out.println();*/
        /*System.out.println(i);
        System.out.println(Arrays.toString(arr1));

        increment(i);
        incrementArray(arr1);

        System.out.println(i);
        System.out.println(Arrays.toString(arr1));*/

        /*int[] arr = {1,2,3,4,5,6,7};
        for(int i : arr) {
            System.out.println(i);
        }*/

        //-- ++ && || !

        /*String s = "wepfojewfjwefaG$G4iewf";
        System.out.println(s.length());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(3, 8));
        System.out.println(s.startsWith("123"));
        System.out.println(s.endsWith("wf"));

        s += "242342";
        System.out.println(s);

        //java 15+
        String ss = """
                <html>
                    ...
                </html>
                """;

        String s1; //null
        String s2 = "";
        */

        /*int[] arr1 = new int[10];
        String[] arr2 = new String[10];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int i = arr2[4].length();*/

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);
        System.out.println(i1 + " " + i2);

        /*
            создать int массив
            создать функцию randArray которая принимает массив и заполняет его рандомными значениями
            создать функцию sortArray которая принимает массив и сортирует его любым алгоритмом
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

    public static int[][][] createArray(int i) {
        return new int[i][i][i];
    }
}
