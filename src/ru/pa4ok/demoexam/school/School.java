package ru.pa4ok.demoexam.school;

import java.util.Arrays;

public class School
{
    private String address;
    private Teacher[] teachers;
    private Student[] students;

    public School(String address, Teacher[] teachers, Student[] students) {
        this.address = address;
        this.teachers = teachers;
        this.students = students;
    }

    public int nextYearAll()
    {
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

    public School setAddress(String address) {
        this.address = address;
        return this;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public School setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
        return this;
    }

    public Student[] getStudents() {
        return students;
    }

    public School setStudents(Student[] students) {
        this.students = students;
        return this;
    }
}
