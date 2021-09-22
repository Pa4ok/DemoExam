package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School extends Building
{
    private Human[] entities;

    public School(String address, int floorCount, Human[] entities) {
        super(address, floorCount);
        this.entities = entities;
    }

    public int nextYearAll()
    {
        int counter = 0;

        for(int i=0; i<entities.length; i++) {
            if(entities[i] != null && entities[i].nextYear()) {
                entities[i] = null;
                counter++;
            }
        }

        return counter;
    }

    @Override
    public String toString() {
        return "School{" +
                "address='" + address + '\'' +
                ", floorCount=" + floorCount +
                ", entities=" + Arrays.toString(entities) +
                '}';
    }

    public Human[] getEntities() {
        return entities;
    }

    public School setEntities(Human[] entities) {
        this.entities = entities;
        return this;
    }
}
