package org.wolroys.task2_3;

import org.wolroys.task1.CalculatorImpl;

import java.lang.reflect.Method;

public class Task2Execution {
    public static void main(String[] args) {
        System.out.println("Task 2:");
        findMethods(ChildClass.class);
        findMethods(CalculatorImpl.class);

        System.out.println("Task 3: ");
        findGetters(ChildClass.class);
    }


    //task 2
    public static void findMethods(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("------------");
        System.out.println(clazz.getSimpleName() + " methods:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        if (clazz.getSuperclass() != null)
            findMethods(clazz.getSuperclass());
    }

    //task 3
    public static void findGetters(Class<?> clazz){
        Method[] methods = clazz.getMethods(); //Беру только публичные, поскольку геттер изанчально не может быть private

        for (Method method : methods) {
            if (isGetter(method))
                System.out.println(method.getName());
        }
    }

    private static boolean isGetter(Method method){
        if (!method.getName().startsWith("get"))
            return false;

        if (void.class.equals(method.getReturnType()))
            return false;

        return method.getParameterCount() == 0;
    }


}
