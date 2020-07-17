package ru.mhit.mhit;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class MyIoc {
    private static ArrayList<String> logMethodsName;

    private MyIoc() {    }

    private static List<String> getLoggedMethods(Method[] methods, Class classOfAnnotation){
        ArrayList<String> varlogMethodsName = new ArrayList(10);
        for (Method method : methods) {
            if (method.isAnnotationPresent(classOfAnnotation)){
                varlogMethodsName.add(method.getName());
            }
        }
        return (List<String>) varlogMethodsName;
    }
    public static <T> T creatObjectClass(T object) throws Exception{
        InvocationHandler handler = new MyInvocationHandler(object);
        logMethodsName = (ArrayList<String>) getLoggedMethods(object.getClass().getDeclaredMethods(),Log.class);
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                            object.getClass().getInterfaces(),
                            handler);
    }

    static class MyInvocationHandler<T> implements InvocationHandler {
        private final T myClass;

        public MyInvocationHandler(T object) {   this.myClass = object;  }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (logMethodsName.contains(method.getName())){
                    for (Object o: args) System.out.println("+++++ method: " + method.getName() + " with args: " + o );
                }
            return method.invoke(myClass, args);
        }
    }
}
