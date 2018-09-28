package ru.rinastachel.mappy.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.rinastachel.mappy.database.entity.Task;
import ru.rinastachel.mappy.database.entity.table.TaskTable;


@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TaskTable type);

    @Query("DELETE FROM Task")
    void deleteAll();

    @Query("SELECT Task.*, Category.title as categoryName from Task " +
            "LEFT JOIN Category on Task.categoryId = Category.Id " +
            "ORDER BY id DESC")
    LiveData<List<Task>> getTasks();

}