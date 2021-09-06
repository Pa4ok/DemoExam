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
        /*int i = 2_000_000_000;
        float f = 32423.3432F;
        double d = 3424234.3434D;
        boolean b = true;
        char c = 'Ы';
        long l = 1_000_000_000_000_000_000L;*/

        //int[] arr; //null
        //int[] arr1 = new int[10];
        //int[] arr2 = {1,2,3,4,5,6,7,8};

        /*for(int i=0; i<arr1.length; i++) {
            System.out.printf(arr1[i] + " ");
        }
        System.out.println();*/
        //System.out.println(Arrays.toString(arr1));

        /*int[] arr = new int[10];
        int i = 5;

        System.out.println(Arrays.toString(arr));
        System.out.println(i);

        incrementArray(arr);
        increment(i);

        System.out.println(Arrays.toString(arr));
        System.out.println(i);*/

        /*for(int i : arr) {
            System.out.println(i);
        }*/

        /*String s = "owehfgh453nOUH$EIUH";
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(3, 8));
        System.out.println(s.startsWith("123123"));
        System.out.println(s.endsWith("UH"));*/

        /*int[] arr1 = new int[10];
        String[] arr2 = new String[10];

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println(arr2[4].length());

        //15+ java
        String ss = """
                <html>
                    ....
                </html>
                """;
        */

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);
        System.out.println(i1 + " " + i2);

        /*
            создать int массив
            создать функцию, которая принимает массив и заполняет его рандомными значениями
            создать функцию, которая принимает массив и сортирует его любым алгоримтмом
         */
    }

    public static void incrementArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            arr[i]++;
        }
    }

    public static void increment(int i)
    {
        i++;
    }

    public static int[][][] test() {
        return new int[3][3][3];
    }
}
