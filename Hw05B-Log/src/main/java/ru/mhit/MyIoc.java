package ru.mhit;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class MyIoc {
    private static ArrayList<Method> logMethods;
    private MyIoc() {    }

    private static List<Method> getLoggedMethods(Object object, Class classOfAnnotation){
        ArrayList<Method> varMethods = new ArrayList(10);
        for (Method method : object.getClass().getDeclaredMethods() ) {
            if (method.isAnnotationPresent(classOfAnnotation)){
                varMethods.add(method);
            }
        }
        return (List<Method>) varMethods;
    }

    public static <T> T creatObjectClass(T object) throws Exception{
        InvocationHandler handler = new MyInvocationHandler(object);
        logMethods = (ArrayList<Method>) getLoggedMethods(object, Log.class);
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                            object.getClass().getInterfaces(),
                            handler);
    }

    static class MyInvocationHandler<T> implements InvocationHandler {
        private final T myClass;

        public MyInvocationHandler(T object) {   this.myClass = object;  }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for(Method varMethod: logMethods)
            {
                int i = 0;
                int priz = 0;
                if(varMethod.getName().equals( method.getName()) &
                        varMethod.getParameterTypes().length == method.getParameterTypes().length)
                {
                    for(Class<?> cl: varMethod.getParameterTypes())
                    {
                        if(cl.getTypeName().equals( method.getParameterTypes()[i].getTypeName())){  priz++; }
                        i++;
                    }
                    if(i==priz& i!=0){
                        for (Object o: args) System.out.println("+++++ method: " + method.getName() + " with args: " + o );
                    }
                }
            }
            return method.invoke(myClass, args);
        }
    }
}
