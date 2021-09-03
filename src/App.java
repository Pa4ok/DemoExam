/**
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            class House +конструктор со всеми полями
            - String address
            - ing floorCount
            - int humanCount
            - public void print()

            Main/App/главный класс
            создать в main методе объект House

            создать в главном классе 2 функции: addHuman(House house) и removeHuman(House house)
            увеличивать или уменьшать количество людей в объекте house из аргументов на 1
         */

        House h = new House("dfjq2wf", 5, 15);
        h.print();
        for(int i=0; i<10; i++) {
            addHuman(h);
        }
        h.print();
    }

    public static void addHuman(House h)
    {
        h.humanCount++;
    }

    public static void removeHuman(House h)
    {
        if(h.humanCount > 0) {
            h.humanCount--;
        }
    }
}

class House
{
    String address;
    int floorCount;
    int humanCount;

    public House(String address, int floorCount, int humanCount) {
        this.address = address;
        this.floorCount = floorCount;
        this.humanCount = humanCount;
    }

    public void print()
    {
        System.out.println("MyHouse: " + this.address + " " + this.floorCount + " " + humanCount);
    }
}