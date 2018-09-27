package ru.rinastachel.mappy.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import ru.rinastachel.mappy.database.entity.Type;
import ru.rinastachel.mappy.database.repo.ITypeRepository;
import ru.rinastachel.mappy.database.repo.TypeRepository;


public class TypeViewModel extends AndroidViewModel {

    private ITypeRepository mRepository;

    private LiveData<List<Type>> mAllTypes;

    public TypeViewModel (Application application) {
        super(application);
        mRepository = new TypeRepository(application);
        mAllTypes = mRepository.getAllTypes();
    }

    public LiveData<List<Type>> getAllTypes() { return mAllTypes; }

    public void insert(Type word) { mRepository.insert(word); }
}