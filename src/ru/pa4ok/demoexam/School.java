package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School extends Building
{
    protected String title;
    protected Human[] entities;

    public School(String address, int floorCount, String title, Human[] entities) {
        super(address, floorCount);
        this.title = title;
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
                "address='" + title + '\'' +
                ", floorCount=" + floorCount +
                ", address='" + title + '\'' +
                ", entities=" + Arrays.toString(entities) +
                '}';
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Human[] getEntities() {
        return entities;
    }

    public void setEntities(Human[] entities) {
        this.entities = entities;
    }
}
