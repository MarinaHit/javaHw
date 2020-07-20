package ru.mhit.mhit;

import ru.mhit.mhit.app.MyClass;
import ru.mhit.mhit.app.MyClassProvider;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MyClassTest {
    private MyClassProvider myClassProvider;
    private MyClass myClass;
    private static String nameNull = "";


    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Start method");
        myClassProvider = mock(MyClassProvider.class);
        myClass = new MyClass(myClassProvider);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("End method");
    }

    @Test
    public void getName() {
        try{
            System.out.println(myClass.getName());
        }
        catch (Exception e) {
            System.out.println("Exception getName:" + e);
        }
        finally {
            System.out.println("   Test getName end");
        }
    }

    @Test
    public void setName() {
        try{
            myClass.setName("Test setName");
        }
        catch (Exception e){
            System.out.println("Exception setName:" + e);
        }
        finally {
            System.out.println("Test setName end:" + myClass.getName());
        }
    }

    @Test
    public void setNameNull() {
        try{
            myClass.setName(nameNull);
        }
        catch (Exception e){
            System.out.println("Exception setName:" + e);
        }
        finally {
            System.out.println("Test setName end:" + myClass.getName());
        }
    }

    @Test
    public void testToString() {
        try{
            System.out.println(myClass.toString());
        }
        catch (Exception e){
            System.out.println("Exception setName:" + e);
        }
        finally {
            System.out.println("Test setName end:" + myClass.getName());
        }
    }
}
