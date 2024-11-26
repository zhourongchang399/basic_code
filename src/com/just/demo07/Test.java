package com.just.demo07;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.work();

        Teacher teacher = new Teacher();
        teacher.work();

        Lecturer lecturer = new Lecturer(1, "张三");
        lecturer.work();

        Tutor tutor = new Tutor(2, "李四");
        tutor.work();

        AdminStaff adminStaff = new AdminStaff();
        adminStaff.work();

        Maintainer maintainer = new Maintainer(3,"王五");
        maintainer.work();

        Buyer buyer = new Buyer(4, "刘六");
        buyer.work();
    }
}
