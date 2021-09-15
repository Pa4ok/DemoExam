package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School
{
    private String address;
    private Teacher[] teachers;
    private Student[] students;

    public School(String address, Teacher[] teachers, Student[] students)
    {
        this.address = address;
        this.teachers = teachers;
        this.students = students;
    }

    public void nextYear()
    {
        for(int i=0; i<teachers.length; i++) {
            if(teachers[i] != null) {
                teachers[i].setAge(teachers[i].getAge() + 1);
                teachers[i].setExp(teachers[i].getExp() + 1);
                if(teachers[i].getAge() > 60) {
                    System.out.println("Ушел на пенсию: " + teachers[i]);
                    teachers[i] = null;
                }
            }
        }

        for(int i=0; i<students.length; i++) {
            if(students[i] != null) {
                students[i].setAge(students[i].getAge() + 1);
                students[i].setLevel(students[i].getLevel() + 1);
                if(students[i].getLevel() > 11) {
                    System.out.println("Выпустился: " + students[i]);
                    students[i] = null;
                }
            }
        }
    }

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
