package ru.pa4ok.demoexam;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
 */
public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

        Car
        - String type
        - int mileage
        - public void addMileage() //mileage++

        на сеттер для mileage необходимо повесить проверку
        чтобы новое значение не могло быть меньше старого
     */

    public static void main(String[] args)
    {
        Car car = new Car("wefewdfew", 1000);
        System.out.println(car);
        car.addMileage();
        car.addMileage();
        car.addMileage();
        System.out.println(car);
        car.setMileage(10);
        System.out.println(car);
        car.setMileage(10000);
        System.out.println(car);
    }
}
