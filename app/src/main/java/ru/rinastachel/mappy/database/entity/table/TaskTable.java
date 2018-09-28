package ru.rinastachel.mappy.database.entity.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import ru.rinastachel.mappy.database.TypesConverter;

@Entity(tableName = "Task" ,foreignKeys =
@ForeignKey(entity = CategoryTable.class, parentColumns = "id", childColumns = "categoryId"), indices =
@Index("categoryId"))

public class TaskTable {

    public enum Priority {
        LOW, NORMAL, HIGH;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @TypeConverters(TypesConverter.class)
    private Date date;

    @ColumnInfo(name = "Desc")
    private String desc;

    @TypeConverters(TypesConverter.class)
    private Priority priority;

    @ColumnInfo(name = "categoryId")
    private int categoryId;

    public TaskTable() {

    }

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
