package ru.mhit.mhit;

import ru.mhit.mhit.testFw.TestFw;
import ru.mhit.mhit.testFw.MyCount;

public class MyClassTests {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Start tests");
            String NameClassTest = "ru.mhit.app.MyClass";
            var myCount = (MyCount) new TestFw(NameClassTest).startFw();
            myCount.printCount();
        }catch (Exception e){
            System.out.println("Exception " + e);
            System.out.println("Tests no!!!!!!");
        }
        finally {
            System.out.println("End Tests");
        }

    }
}
