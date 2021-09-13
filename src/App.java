import java.util.Arrays;
import java.util.Random;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            class House
            - String address
            - int floorCount
            - int humanCount
            - public void addHuman() ++
            - public void removeHuman() --

            написать класс, с конструктором, переопределенным выводом (toString)
            на метод removeHuman необходимо повесить проверку, чтобы число humanCount не стало < 0
         */

        House h = new House("wefojjwfiuf", 5, 15);
        System.out.println(h);
        h.addHuman();
        System.out.println(h);
        for(int i=0; i<100; i++) {
            h.removeHuman();
        }
        System.out.println(h);
    }
}

class House
{
    String address;
    int floorCount;
    int humanCount;

    public House(String address, int floorCount, int humanCount)
    {
        this.address = address;
        this.floorCount = floorCount;
        this.humanCount = humanCount;
    }

    public void addHuman() {
        humanCount++;
    }

    public void removeHuman() {
        if(humanCount > 0) {
            humanCount--;
        }
    }

    public String toString() {
        return "MyHouse: " + this.address + " " + this.floorCount + " " + this.humanCount;
    }
}
