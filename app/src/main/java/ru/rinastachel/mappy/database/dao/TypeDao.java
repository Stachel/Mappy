package ru.rinastachel.mappy.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.rinastachel.mappy.database.entity.Type;


@Dao
public interface TypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Type type);

    @Query("DELETE FROM Type")
    void deleteAll();

    @Query("SELECT * from Type ORDER BY id DESC")
    LiveData<List<Type>> getLiveDataAllTypes();

    @Query("SELECT COUNT(*) from Type")
    LiveData<Integer> getCount();
}