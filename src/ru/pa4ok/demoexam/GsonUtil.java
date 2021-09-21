package ru.pa4ok.demoexam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil
{
    public static Gson gson;
    public static Gson gsonPretty;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();

        gson = builder.create();

        builder.setPrettyPrinting();
        gsonPretty = builder.create();
    }
}
