package ru.rinastachel.mappy.database.repo;

import android.arch.lifecycle.LiveData;

import java.util.List;

import ru.rinastachel.mappy.database.entity.Type;

public interface ITypeRepository {
    LiveData<List<Type>> getAllTypes();
    void insert(Type type);
}
