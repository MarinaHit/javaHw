package ru.mhit.mrsk;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        MyCount myCountMain = new MyCount();
        try{
            methodStart();
            methodTest(myCountMain);
            method(myCountMain);
            methodSetException(myCountMain);
        }
        catch (NullPointerException e) {
            System.out.println("Exception NullPointerException:" + e);
            myCountMain.addCount_minus();
            myCountMain.addCount_all();
        }
        catch (Exception e){
            System.out.println("Exception:" + e);
            myCountMain.addCount_minus();
            myCountMain.addCount_all();
        }
        finally {
            System.out.println("End");
            myCountMain.printCount();
        }
    }
    private static void methodStart() throws NoSuchMethodException {
        Class<MyClass> cl = MyClass.class;
        System.out.println("Class Name:" + cl.getName());
        Method method = cl.getMethod("toString1");
    }

    private static void method(MyCount myCount){
        String name1;
        MyClass myClass = new MyClass();
        name1 = "My class1";
        myClass.setName(name1);
        myClass.toString1();
        System.out.println(MyClass.getName());
        myCount.addCount_plus();
        myCount.addCount_all();
    }

    private static void methodSetException(MyCount myCount){
        String name;
        MyClass myClass = new MyClass();
        name = "";
        System.out.println("Name PUSTO: " + "");
        MyClass.setName(name);
        myClass.toString1();
        System.out.println(MyClass.getName());
        myCount.addCount_plus();
        myCount.addCount_all();
    }
    private static void methodTest(MyCount myCount){
        Class<MyClass> clazz = MyClass.class;
        System.out.println("Class Name:" + clazz.getSimpleName());
        Method[] metAll = clazz.getDeclaredMethods();
        ArrayList<Method> metBefore = new ArrayList<Method>(5);
        ArrayList<Method> metAfter = new ArrayList<Method>(5);
        ArrayList<Method> metTest = new ArrayList<Method>(5);
        for (Method method : metAll) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Before.class)) metBefore.add(method);
                if (annotation.annotationType().equals(After.class)) metAfter.add(method);
                if (annotation.annotationType().equals(Test.class)) metTest.add(method);
            }
        }
        System.out.print("Before methods:");
        metBefore.forEach(c ->   System.out.println(c.getName() + ";"));
        System.out.print("Test methods:");
        metTest.forEach(c ->   System.out.println(c.getName()+";"));
        System.out.print("After methods:");
        metAfter.forEach(c ->   System.out.println(c.getName()+";"));
        myCount.addCount_plus();
        myCount.addCount_all();
    }

    private static void methodGetName() {
        String name;
        name = "My class";
        MyClass myClass1 = new MyClass(name);
        System.out.println(MyClass.getName());
    }

    void methodSetName(){
        String name1;
        MyClass myClass = new MyClass();
        name1 = "My class1";
        myClass.setName(name1);
        myClass.toString1();
        System.out.println(MyClass.getName());
    }
}


