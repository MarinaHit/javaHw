package ru.mhit.mhit;

public class MyMain {

    public static void main(String[] args) throws Exception {
        MyClassInterface myObject = new MyClass();
        MyClassInterface loggable = MyIoc.creatObjectClass(myObject);
        loggable.calculation(6);
        loggable.calculation( myObject.getClass().getName());
        loggable.calculationWithoutLog(10);

        ClassTestInterface myObjectTest = new ClassTest();
        ClassTestInterface loggableTest = MyIoc.creatObjectClass(myObjectTest);
        loggableTest .methodClassTest(6);
        loggableTest.methodClassTest1(8, myObjectTest.getClass().getName());
        loggableTest.methodClassTest2(10, myObject.getClass().getName(), myObject);
        loggableTest.methodClassTest2(15, myObjectTest.getClass().getName(), myObjectTest);
    }
}
