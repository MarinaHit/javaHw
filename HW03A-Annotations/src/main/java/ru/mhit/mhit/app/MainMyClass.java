package ru.mhit.mhit.app;

public class MainMyClass {
    public static void main(String[] args) throws Exception {
        try{
            MyClass myClass = new MyClass();
            System.out.println(myClass.toString());
            MyClass myClass2 = new MyClass("My class");
            System.out.println(myClass2.toString());
            MyClass myClass3 = new MyClass();
            myClass3.setName("");
            System.out.println(myClass2.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("End");
        }
    }
}
