package ru.rinastachel.mappy.database.entity;

import android.arch.persistence.room.ColumnInfo;

public class TypeBoo {

    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return "Boo: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
