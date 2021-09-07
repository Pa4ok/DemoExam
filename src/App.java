import java.util.Arrays;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
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

        House h = new House("efewffewfwe", 5, 20);
        System.out.println(h);
        h.addHuman();
        System.out.println(h);
        for(int i=0; i<30; i++) {
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
        this.humanCount++;
    }

    public void removeHuman() {
        if(this.humanCount > 0) {
            this.humanCount--;
        }
    }

    public String toString()
    {
        return "MyHouse: " + this.address + " " + this.floorCount + " " + this.humanCount;
    }
}


