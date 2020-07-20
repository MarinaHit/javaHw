package ru.mhit.mhit.app;


import ru.mhit.mhit.testFw.After;
import ru.mhit.mhit.testFw.Before;
import ru.mhit.mhit.testFw.Test;

public class MyClass {
    //private String name;
    //private MyClass myClass;
    //private MyClassProvider myClassProvider;
    private Class<MyClass> clazz = MyClass.class;
    private String name = clazz.getSimpleName();
    private MyClass myClass = new MyClass(name);
    private String nameNull = "";

    public MyClass() {
        //this.name = "default";
        //this.myClassProvider = new MyClassProvider();
    }

    public MyClass(String name) {
        if (name.equals("")){
            throw new  NullPointerException();
        }
        this.name = name;
    }

    /*public MyClass(MyClassProvider myClassProvider){
        this.myClassProvider = myClassProvider;
    }
    */

    public String getName()  {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")){
            throw new  NullPointerException();
        }
        this.name = name;
    }

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
