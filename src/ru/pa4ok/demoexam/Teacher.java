package ru.pa4ok.demoexam;

//наследуем класс Human
public class Teacher extends Human
{
    protected String subject;
    protected int exp;

    public Teacher(String fio, char gender, int age, String subject, int exp) {
        //вызов родительского конструктора в Human
        //обязательно должен быть на 1 месте в вашем конструкторе
        super(fio, gender, age);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public void nextYear() {
        //вызов родительской реализации метода
        //можно вызвать в любом месте метода
        super.nextYear();
        exp++;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fio='" + fio + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                '}';
    }
}
