package ru.mhit.mrsk;

import java.util.Enumeration;
import java.util.Vector;

class My implements MyMBean {
    private final int myValue;
    private volatile int size = 0;
    private int int1 = 3;
    private int int2 = 5;
    private int int3 = 1000;
    private int int4 = 1000;

    public My(int myValue) {
        this.myValue = myValue;
    }

    void run() throws InterruptedException {
        for (int idx = 0; idx < myValue; idx++) {
            int local = size;
            Object[] array = new Object[local];
            for (int i = 0; i < local; i++) {
                array[i] = new String(new char[0]);
            }
            Thread.sleep(10); //Label_1
        }
    }

    void myRun(int int1, int int2, int int3, int int4) throws InterruptedException {

        if (int1 <= 0) {int1 = this.int1;}
        if (int2 <= 0) {int2 = this.int2;}
        if (int3 <= 0) {int3 = this.int3;}

        Vector v = new Vector(int1, int2);

        //System.out.println("Start size: " + v.size());
        //System.out.println("Start capacity: " + v.capacity());
        for (int i = v.size(); i<=int3; i++){
            v.addElement(new Integer(i));
            Thread.sleep(int4);
            //System.out.println("Plus: " + v.capacity());
        }
        Enumeration vEnum = v.elements();
        //System.out.println("\nElements:");

        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        System.out.println("new size:" + size);
        this.size = size;
    }

}
