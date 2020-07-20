package ru.mhit.mhit.testFw;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFw {
    private Class clazz;
    private MyCount myCount;

    public TestFw(String nameClassTest) throws Exception {
        clazz = Class.forName(nameClassTest);
        myCount = new MyCount();
    }

    public MyCount startFw() throws Exception {
        Method[] metAll = clazz.getDeclaredMethods();
            var metBefore = new ArrayList<Method>(20);
            var metAfter = new ArrayList<Method>(20);
            var metTest = new ArrayList<Method>(20);
            for (Method method : metAll) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().equals(Before.class)) metBefore.add(method);
                    if (annotation.annotationType().equals(After.class)) metAfter.add(method);
                    if (annotation.annotationType().equals(Test.class)) metTest.add(method);
                }
            }
            System.out.println("Before methods:");
            metBefore.forEach(c -> System.out.println(c.getName() ));
            System.out.println("Test methods:");
            metTest.forEach(c -> System.out.println(c.getName() ));
            System.out.println("After methods:");
            metAfter.forEach(c -> System.out.println(c.getName() ));
            return runFw(metBefore,metTest,metAfter);
    }

    private MyCount runFw(List<Method> metBefore, List<Method> metTest,List<Method> metAfter) throws Exception {
        myCount.setCount_all(metTest.size());
        for (int i = 0; i < metTest.size(); i++) {
            Method methodTest = metTest.get(i);
            try {
                for (int y = 0; y < metBefore.size(); y++) {
                    Method methodBefore = metBefore.get(y);
                    myInvoke(methodBefore,0);
                }
                try {
                    myInvoke(methodTest,1);
                    //myCount.addCount_plus();
                }
                catch (Exception e){
                    System.out.println("Exception 'minus' " + methodTest.getName() + " " + e);
                    //myCount.addCount_minus();
                }
            } catch (Exception e) {
                System.out.println("Exception 'for' " + methodTest.getName() + " " + e);
                //myCount.addCount_minus();
            }
            finally {
                for (int x = 0; x < metAfter.size(); x++) {
                    Method methodAfter = metAfter.get(x);
                    myInvoke(methodAfter,0);
                }
            }
        }
        return myCount;
    }

    private void myInvoke (Method method, int i) throws Exception{
        try{
            var object = clazz.getConstructor().newInstance();
            method.setAccessible(true);
            method.invoke(object);
            if(i == 1) { myCount.addCount_plus();}
        }
        catch (Exception e){
            System.out.println("Exeption 'method minus' " + e);
            if(i == 1) { myCount.addCount_minus();}
        }
    }
}
