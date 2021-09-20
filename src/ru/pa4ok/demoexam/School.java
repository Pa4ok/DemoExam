package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School
{
    public static long testStatic;

    //статичный блок, выполняется 1 раз при загрузке класса в систему (при 1 обращении к нему)
    static {
        testStatic = System.currentTimeMillis();
        System.out.println(testStatic + "ms");
    }

    private String address;
    private Teacher[] teachers;
    private Student[] students;

    public School(String address, Teacher[] teachers, Student[] students) {
        this.address = address;
        this.teachers = teachers;
        this.students = students;
    }

    /*public int nextYear()
    {
        System.out.println(testStatic);

        int counter = 0;

        for(int i=0; i<teachers.length; i++) {
            if(teachers[i] != null && teachers[i].nextYear()) {
                teachers[i] = null;
                counter++;
            }
        }

        for(int i=0; i<students.length; i++) {
            if(students[i] != null && students[i].nextYear()) {
                students[i] = null;
                counter++;
            }
        }

        return counter;
    }*/

    @Override
    public String toString() {
        return "School{" +
                "address='" + address + '\'' +
                ", teachers=" + Arrays.toString(teachers) +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
