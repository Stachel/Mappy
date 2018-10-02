package ru.rinastachel.mappy.database.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
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