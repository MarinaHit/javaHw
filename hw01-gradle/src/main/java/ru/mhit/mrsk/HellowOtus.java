package ru.mhit.mrsk;


import com.google.common.primitives.Ints;

public class HellowOtus {

    public static void main(String[] args) {
       String testGuava = "Hellow OTUS !!!";

       System.out.println(testGuava.split(" ").length);
        System.out.println(testGuava);

        int[] arr = { 5, 4, 3, 2, 1 };
        int target = 7;
        if (Ints.contains(arr, target))
            System.out.println("Target is present" + " in the array");
        else
            System.out.println("Target is not present" + " in the array");

    }


}
