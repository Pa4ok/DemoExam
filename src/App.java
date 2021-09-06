/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
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
            - public void print()

            class App/Main/...
            - главная функция main
            - public static void addHuman(House house)
            - public static void removeHuman(House house)
            //на фукнцию removeHuman необходимо повесить проверку
            //на то чтобы количество людей в доме не стало отрицательным

            создать объект House
            и потестить функции
         */

        House h = new House("dwqpdjqid", 12, 10);
        h.print();
        addHuman(h);
        h.print();
        for(int i=0; i<20; i++) {
            removeHuman(h);
        }
        h.print();
    }

    public static void addHuman(House house)
    {
        house.humanCount++;
    }

    public static void removeHuman(House house)
    {
        if(house.humanCount > 0) {
            house.humanCount--;
        }
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

    public void print()
    {
        System.out.println("MyHouse: " + address + " " + floorCount + " " + humanCount);
    }
}

