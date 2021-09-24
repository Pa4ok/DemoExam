package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School extends Building
{    protected Human[] entities;

    public School(String address, int floorCount, Human[] entities) {
        super(address, floorCount);
        this.entities = entities;
    }

    public int nextYear()
    {
        int count = 0;

        for(int i=0; i<entities.length; i++) {
            if(entities[i] != null) {
                entities[i].age++;
                if(entities[i] instanceof Teacher) {
                    Teacher t = (Teacher) entities[i];
                    t.exp++;
                    if(t.age > 60) {
                        entities[i] = null;
                        count++;
                    }
                } else if(entities[i] instanceof Student) {
                    Student s = (Student) entities[i];
                    s.level++;
                    if(s.level > 11) {
                        entities[i] = null;
                        count++;
                    }
                }
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
