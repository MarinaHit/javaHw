package ru.mhit.mhit;

public class ClassTest<T> implements ClassTestInterface<T> {
    private int param;

    public ClassTest() { }

    public ClassTest(int param) {
        this.param = param;
    }
    public int getParam() {
        return param;
    }
    public void setParam(int param) {
        this.param = param;
    }
    public String toString() {
        return "ClassTest{" + " param = " + param + "}";
    }

    @Override
    @Log
    public void methodClassTest(int param){
        this.param = param;
        System.out.println("Method methodClassTest: " + param);
    }
    @Override
    @Log
    public void methodClassTest1(int param, String name){
        this.param = param;
        System.out.println("Method methodClassTest1 int: " + param + " Strng: " + name);
    }

    @Override
    @Log
    public  void methodClassTest2(int param, String name, T obj){
        this.param = param;
        System.out.println("Method methodClassTest2 int: " + param + " Strng: " + name +
                "  obj: " + obj);
    }

}
