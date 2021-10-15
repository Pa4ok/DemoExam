package ru.pa4ok.demoexam;

public class App {
    /*
        GameServer
        - World world //мир c сущностями
        - int updateCounter //колчество обновлений сервера
        - public void updateServer()

        class World
        - List<Entity> entities
        - public void updateWorld()
        - public List<Entity> getEntitiesInRegion(int x, int y, double range)
        - public List<Entity> getEntitiesNearEntity(Entity entity, double range)
        - public List<EntityPlayer> getAllPlayers()

        abstract Entity
        - String title
        - int xPos
        - int zPos
        - int age //количество пережитых обновлений
        - double maxHealth //максимальное колво хп
        - double health //текущее количество хп
        - public void update() //age++
        - public boolean attackEntityFrom(Entity entity, double damage)

        EntityPlayer extends Entity
        - double exp
        - public void update()
        - public boolean attackEntityFrom(Entity entity, double damage)
        - public double calculateDamage()

        EntityGuard extends Entity
        - public void update()

        EntityMonster extends Entity
        - double damage
        - public void update()

        GameServer
        updateServer фунция сначала увеличивает updateCounter на 1
        потом вызывает у world функцию updateWorld

        World
        функция updateWorld перебирает всех сущностей и вызывает у них функцию update
        после этого в конце обновления (мира) из списка должны удаляться все сущности у которых health <= 0

        Entity описывает вообще всех сущностей
        метод update в нем должен только увеличивать поле age на 1
        метод attackEntityFrom принимает атакующую сущность и урон
        должен вычитать урон из жизней сущности, возвращает true, если сущность умерла (health <= 0)

        EntityGuard наследует Entity
        метод update сначала должен вызывать родительскую реализацию
        после чего искать ближайшего сущность EntityPlayer и двигаться к ней

        EntityPlayer наследует Entity
        метод update сначала должен вызывать родительскую реализацию
        также раз в 2 обновления если health < maxHealth && health > 0, health нужно увеличить на 1
        метод attackEntityFrom переопределяет родительский метод: если в радиусе 2есть EntityGuard
        то они должны принимать урон вместо игрока (вызывать метод attackEntityFrom для них)
        если рядом нет EntityGuard и после удара игрок выживает он вызывает attackEntityFrom для атакующей сущности
        функция calculateDamage расчитывает урон игрока по формуле 3 + exp / 2
        если игрок убивает сущность, то exp увеличивается на 1

        EntityMonster наследует Entity
        метод update сначала должен вызывать родительскую реализацию
        после чего искать ближайшего сущность EntityPlayer и двигаться к ней
        если в радиусе 2 есть сущность(ти) EntityPlayer
        для них необходимо вызывать метод attackEntityFrom(this)

        *движение сущностей
        сущность за 1 обновление может смещаться на 1 по xPos и на 1 по zPos
     */

    public static void main(String[] args) {
    }
}
