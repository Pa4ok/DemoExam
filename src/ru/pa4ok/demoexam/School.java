package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School extends Building
{    protected Human[] entities;

    public School(String address, int floorCount, Human[] entities) {
        super(address, floorCount);
        this.entities = entities;
    }

    public int nextYearAll()
    {
        int count = 0;

        for(int i=0; i<entities.length; i++) {
            if(entities[i] != null && entities[i].nextYear()) {
                entities[i] = null;
                count++;
            }
        }

        return count;
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
