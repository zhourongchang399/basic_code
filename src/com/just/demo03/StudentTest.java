package com.just.demo03;

class StudentTest {

    public static Student[] insert(Student[] students, Student student){
        if (unique(students, student.id)){
            if (getCount(students) < students.length) {
                students[getNullPos(students)] = student;
            } else {
                students = createNewArr(students);
                students[students.length - 1] = student;
            }
        } else {
            System.out.println("该学生已存在!");
        }
        return students;
    }

    public static Student[] createNewArr(Student[] students) {
        Student[] newArr = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newArr[i] = students[i];
        }
        return newArr;
    }

    public static int getCount(Student[] students) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                count++;
        }
        return count;
    }

    public static int getIndex(Student[] students, int id) {
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].id == id) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static int getNullPos(Student[] students) {
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null)
                index = i;
            return index;
        }
        return index;
    }

    public static boolean unique(Student[] students, int id){
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].id == id)
                return false;
        }
        return true;
    }

    public static void delete(Student[] students, int id){
        if (!unique(students, id)) {
            students[getIndex(students, id)] = null;
        } else {
            System.out.println("不存在该学生！");
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(1, "伍六七", 24);
        students[1] = new Student(2, "梅小姐", 18);
        students[2] = new Student(3, "赤牙", 28);

        Student std = new Student(4, "斯特国王子", 20);

        students = insert(students, std);
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                System.out.println(students[i].toString());
        }

        delete(students, 3);
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                System.out.println(students[i].toString());
        }

        if(!unique(students, 1)){
            students[getIndex(students, 1)].age++;
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                System.out.println(students[i].toString());
        }

    }
}