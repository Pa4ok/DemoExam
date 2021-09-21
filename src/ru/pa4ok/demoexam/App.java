package ru.pa4ok.demoexam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Random;

public class App
{
    public static void main(String[] args)
    {
        /*Student s = new Student(null, 23);
        System.out.println(GsonUtil.gsonPretty.toJson(s));*/

        /*double[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));*/

        double[] arr = new double[20000];

        Random rand = new Random();
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextDouble();
        }

        long startMills = System.currentTimeMillis();

        /*String s = "";
        for(int i=0; i<arr.length; i++) {
            s += arr[i];
            s += ", ";
        }*/

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i])
                    .append(", ");
        }
        String s = sb.toString();

        long endMills = System.currentTimeMillis() - startMills;

        System.out.println(s.length() + " " + endMills + "ms");
    }
}

