package ru.mhit.mhit;

public class TestMyClass {
/*    private Class<MyClass> clazz = MyClass.class ;
    private String name = clazz.getSimpleName();
    private MyClass myClass = new MyClass(name);
 */
    private Class<MyClass> clazz ;
    private String name;
    private MyClass myClass;
    private String nameNull = "";

    public TestMyClass() {
        this.clazz = MyClass.class ;
        this.name = clazz.getSimpleName();
        this.myClass = new MyClass(name);
    }

    @Before
    public void printBefore() {
         System.out.println( "printBefore: MyClass{" +
                "name='" + name + '\'' +
                '}');
    }

    @Test
    public void printTest() {
       System.out.println( "printTest: MyClass{" +
                "name='" + name + '\'' +
                '}');
    }

    @Test
    public void setNameNullTest() {
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