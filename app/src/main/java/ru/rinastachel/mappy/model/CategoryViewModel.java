package ru.rinastachel.mappy.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import ru.rinastachel.mappy.database.entity.table.CategoryTable;
import ru.rinastachel.mappy.database.repo.CategoryRepository;

public class CategoryViewModel extends AndroidViewModel {

    private CategoryRepository mRepository;

    private LiveData<List<CategoryTable>> mCategories;

    public CategoryViewModel(Application application) {
        super(application);
        mRepository = new CategoryRepository(application);
        mCategories = mRepository.getCategories();
    }

    public LiveData<List<CategoryTable>> getAllTypes() { return mCategories; }

    public void insert(CategoryTable word) { mRepository.insert(word); }
}