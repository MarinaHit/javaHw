package ru.mhit.mrsk;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    private ArrayList<String>[] myArrayList;
    private List<String>[] myList;
    private int sizeArray;
    private int countList;

    public MyClass() {
        this.sizeArray = 10;
        this.countList =0;
        myArrayList = new ArrayList[sizeArray];
        myList = new List[sizeArray];
    }

    public MyClass(int size) {
        myArrayList = new ArrayList[size];
        myList = new List[size];
        this.sizeArray = size;
        this.countList=0;
    }


}
