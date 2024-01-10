package org.wolroys.task4;

import java.lang.reflect.Field;

public class Task4Execution {

    public static void main(String[] args) {
        fieldsHandler(FieldsKeeper.class);
    }

    public static void fieldsHandler(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();


        for (Field field : fields){
            field.setAccessible(true);
            try {
                if (field.getName().equals(field.get(null)))
                    System.out.println(field.getName() + " == " + field.get(null));
                else
                    System.out.println(field.getName() + " != " + field.get(null));
            } catch (IllegalAccessException e) {
                System.out.println("Something went wrong");
            }
        }
    }
}

class FieldsKeeper{
    private static final String MONDAY = "MONDAY";

    private static final String ALEX = "ALEX";

    private static final String TUESDAY = "tuesday";

    private static final String NAME = "Hello";
}

