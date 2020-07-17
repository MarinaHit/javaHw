package ru.mhit;


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
        System.out.println("Method calculation int: " + param);
    }
    @Override
    public void calculation( String name){
        System.out.println("Method calculation String: " + name);
    }

    @Override
    @Log
    public void calculation( String name, int param){
        this.param = param;
        System.out.println("Method calculation name String: " + name + " param int: " + param);
    }

    @Override
    public void calculationWithoutLog(int param) {
        System.out.println("Proverka: " + param);
    }


}
