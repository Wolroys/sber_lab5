package org.wolroys.task2_3;

public class ChildClass extends ParentClass{

    private String fullName = "ALEKSEY PASLENOV";
    private int age = 20;

    public void increaseAge(){
        age++;
    }

    public void sayGoodbye(){
        System.out.print("Say hello");
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
