package org.wolroys.task7;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Aleksey");
        person.setAge(20);

        Employee employee = new Employee();

        BeanUtils.assign(employee, person);

        System.out.println(employee.getName());
    }
}