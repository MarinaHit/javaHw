package ru.mhit.mhit.tests;

import ru.mhit.mhit.app.MyClass;
import ru.mhit.mhit.testFw.After;
import ru.mhit.mhit.testFw.Before;
import ru.mhit.mhit.testFw.Test;

public class TestMyClass {

    private Class<MyClass> clazz = MyClass.class;
    private String name = clazz.getSimpleName();
    private MyClass myClass = new MyClass(name);
    private String nameNull = "";

    @Before
    public void printBefore() {
        System.out.println( "printBefore: MyClass{" +
                "name='" + name + '\'' +
                '}');

    }

    @Test
    public void printTest() {
        //MyClass myClass = this.myClass;
        System.out.println( "printTest: MyClass{" +
                "name='" + name + '\'' +
                '}');
    }

    @Test
    public void SetNameNullTest() {
        //MyClass myClass = this.myClass;
        myClass.setName(nameNull);
        System.out.println( "printTest: MyClass{" +
                "name='" + name + '\'' +
                '}');
    }


    @After
    public void printAfter() {
        System.out.println("printAfter: MyClass{" +
                "name='" + name + '\'' +
                '}');
        this.myClass = null;
    }
}
