package ru.mhit.mhit;

public class MyClass {
    private String name;

    public MyClass() {
        this.name = "default";
    }

    public MyClass(String name) {
        if (name.equals("")){
            throw new  NullPointerException();
        }
        this.name = name;
    }

    public String getName()  {        return name;    }

    public void setName(String name) {
        if (name.equals("")){
            throw new  NullPointerException();
        }
        this.name = name;
    }

}

