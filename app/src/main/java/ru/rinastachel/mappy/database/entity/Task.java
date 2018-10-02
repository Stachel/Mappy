package ru.rinastachel.mappy.database.entity;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.TypeConverters;
import ru.rinastachel.mappy.database.TypesConverter;
import ru.rinastachel.mappy.database.entity.table.TaskTable;

public class Task {

    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @TypeConverters(TypesConverter.class)
    public Date date;

    @ColumnInfo(name = "Desc")
    public String desc;

    @TypeConverters(TypesConverter.class)
    public TaskTable.Priority priority;

    @ColumnInfo(name = "categoryId")
    public int categoryId;

    @ColumnInfo(name = "categoryName")
    public String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TaskTable.Priority getPriority() {
        return priority;
    }

    public void setPriority(TaskTable.Priority priority) {
        this.priority = priority;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }
}
