package ru.mhit.mhit;

public class My implements MyMBean{
    private final int loopCounter;
    private volatile int size = 0;

    public My(int loopCounter) {
        this.loopCounter = loopCounter;
    }

    public void addSize(){
        this.size++;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void setSize(int size) {
        System.out.println("new size:" + size);
        this.size = size;
    }

}
