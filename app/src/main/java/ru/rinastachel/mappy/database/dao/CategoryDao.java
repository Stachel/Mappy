package ru.rinastachel.mappy.database.dao;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import ru.rinastachel.mappy.database.entity.table.CategoryTable;

@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CategoryTable type);

    @Query("DELETE FROM Category")
    void deleteAll();

    @Query("SELECT * from Category ORDER BY id DESC")
    LiveData<List<CategoryTable>> getCategories();

    @Query("SELECT COUNT(*) from Category")
    LiveData<Integer> getCount();
}
