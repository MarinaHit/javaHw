package ru.mhit.mhit;


public class MyClass implements MyClassInterface {
   private int param;

    public MyClass() {
    }

    public MyClass(int param) {
        this.param = param;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public String toString() {
        return "MyClass{" + " param = " + param + "}";
    }

    @Override
    @Log
    public void calculation(int param){
        this.param = param;
        System.out.println("Method calculation: " + param);
    }
    @Override
    public void calculation( String name){
        this.param = param;
        System.out.println("Method calculation+: " + name);
    }

    @Override
    public void calculationWithoutLog(int param) {
        System.out.println("Proverka: " + param);
    }


}
