package ru.mhit.mrsk;

public class MyClass {
    private static String name;
    public MyClass() {
    }

    public MyClass(String name) {
        this.name = name;
    }

    @Before
    public static String getName() {
        return name;
    }

    @After
    public static void setName(String name) {
        if (name.equals("")){
            throw new  NullPointerException();
        }
        MyClass.name = name;
    }
    @Test
    public String toString1() {
        return "MyClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
