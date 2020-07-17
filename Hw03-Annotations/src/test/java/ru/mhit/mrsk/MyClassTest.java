package ru.mhit.mrsk;

import org.junit.*;
import org.junit.Test;

public class MyClassTest {
    private static int count_plus = 0;
    private static int count_minus = 0;
    private static int count_all = 0;
    private static final String nameTest = "";

    @BeforeClass
    @Before
    public static void testMethodStart(){
        try {
            System.out.print("Test plus: " + Integer.toString(count_plus));
            System.out.print(" Test minus: " + Integer.toString(count_minus));
            System.out.print(" Test all: " + Integer.toString(count_all));
        }
        catch (Exception e){
            System.out.println("Exception Start:" + e);
        }
        finally {
            System.out.println("    Start");
        }
    }

    @AfterClass
    @After
    public static void testMethodEnd(){
        try {
            System.out.print("Test plus: " + Integer.toString(count_plus));
            System.out.print(" Test minus: " + Integer.toString(count_minus));
            System.out.print(" Test all: " + Integer.toString(count_all));
        }
        catch (Exception e){
            System.out.print("Exception End:" + e);
        }
        finally {
            System.out.println("  End");
        }
    }

    @Test
    public void setNameTest() {
        try{
            MyClass myClass = new MyClass();
            MyClass.setName("Test setName");
            System.out.print(myClass.getName());
            count_plus++;
        }
        catch (Exception e){
            System.out.print("Exception setName:" + e);
            count_minus++;
        }
        finally {
            System.out.println("   Test setName end");
            count_all++;
        }
    }

    @Test
    public void toString1Test() {
        try{
            MyClass myClass = new MyClass("Test toString1");
            System.out.print(myClass.toString1());
            count_plus++;
        }
        catch (Exception e){
            System.out.print("Exception toString1:" + e);
            count_minus++;
        }
        finally {
            System.out.println("   Test toString1 end");
            count_all++;
        }

    }
    @Test
    public void getNameTest() {
        try{
            MyClass myClass = new MyClass("Test getName");
            System.out.print(myClass.getName());
            count_plus++;
        }
        catch (Exception e) {
            System.out.print("Exception getName:" + e);
            count_minus++;
        }
        finally {
            System.out.println("   Test getName end");
            count_all++;
        }
    }

    @Test
    public void setNameNullTest() {
        try{
            MyClass myClass = new MyClass();
            myClass.setName(nameTest);
            System.out.print(myClass.getName());
            count_plus++;
        }
        catch ( NullPointerException e){
            System.out.print("Exception NullPointerException setNameNull:" + e);
            count_minus++;
        }
        catch (Exception e) {
            System.out.print("Exception setName:" + e);
            count_minus++;
        }
        finally {
            System.out.println("   Test getName end");
            count_all++;
        }
    }
}