package ru.mhit.mhit;

public class MainMyClass {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Start tests");
            String NameClassTest = "ru.mhit.TestMyClass";
            MyCount myCount = (MyCount) new TestFw(NameClassTest).startFw();
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
