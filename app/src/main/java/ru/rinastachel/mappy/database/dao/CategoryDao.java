package ru.rinastachel.mappy.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

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
