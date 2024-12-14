package com.example.javalearning;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public static void main(String[] args) {

        String[] stringArray = new String[3];
        stringArray[0] = "Faruk";
        stringArray[1] = "Sena";
        stringArray[2] = "Cesur";

        System.out.println(stringArray[0]);
        System.out.println(stringArray[1]);
        System.out.println(stringArray[2]);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("EVET");
        arrayList.add("HAYIR");
        arrayList.add(0,"YOK");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        arrayList.clear();
        System.out.println(arrayList.isEmpty());
    }
}
