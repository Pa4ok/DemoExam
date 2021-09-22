package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School extends Building
{
    private Human[] entities;

    public School(String address, int floorCount, Human[] entities) {
        super(address, floorCount);
        this.entities = entities;
    }

    public void nextYear()
    {
        for(int i=0; i<entities.length; i++) {
            if(entities[i] != null) {
                entities[i].age++;
                if(entities[i] instanceof Teacher) {
                    Teacher t = (Teacher) entities[i];
                    t.exp++;
                    if(t.age > 60) {
                        entities[i] = null;
                    }
                } else if(entities[i] instanceof Student) {
                    Student s = (Student) entities[i];
                    s.level++;
                    if(s.level > 11) {
                        entities[i] = null;
                    }
                }
            }
        }
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

    public void setEntities(Human[] entities) {
        this.entities = entities;
    }
}
