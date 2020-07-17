package ru.mhit.mhit.tests;

import ru.mhit.mhit.app.MyClass;
import ru.mhit.mhit.app.MyClassProvider;
import ru.mhit.mhit.app.TemplateNotFoundException;
import ru.mhit.mhit.testFw.After;
import ru.mhit.mhit.testFw.Before;
import ru.mhit.mhit.testFw.Test;

public class MyClassTest {
    private MyClass myClass ;
    private MyClassProvider myClassProvider;
    private String nameNull;
    int getName;

    public MyClassTest() {
        myClassProvider = new MyClassProvider();
        this.getName = 0;
       //getMessageTemplateCalled=0;
    }
    public MyClassTest(MyClassProvider myClassProvider) {
        this.myClassProvider = myClassProvider;
    }

    @Before
    private void mBefore(){ System.out.println("!!!! Before start ");
    }

    @After
    private void mAfter()
    {
        System.out.println("After end!!!!! ");
    }

  /*  public String buildMessage(String templateName, String text, String signature) {
        String messageTemplate = myClassProvider.getMessageTemplate(templateName);
        if (messageTemplate == null || messageTemplate.isEmpty()) {
            throw new TemplateNotFoundException();
        }
        getName++;
        return String.format(messageTemplate, text, signature);
    }
   */

    @Test
    public void setNameTest() {
        try{
            if(this.getName==00)
            {throw new TemplateNotFoundException();}
            else
            {myClass.setName("Test setName");}
        }
        catch (Exception e){
            System.out.println("Exception setName:" + e);
        }
        finally {
            System.out.println("Test setName end:" + myClass.getName());
        }
    }

    @Test
    public void getName() {
        try{
            if(this.getName==00)
            {throw new TemplateNotFoundException();}
            else
            {System.out.println(myClass.getName());}
        }
        catch (Exception e) {
            System.out.println("Exception getName:" + e);
        }
        finally {
            System.out.println("   Test getName end");
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
