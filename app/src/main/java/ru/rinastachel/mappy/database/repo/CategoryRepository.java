package ru.rinastachel.mappy.database.repo;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import ru.rinastachel.mappy.database.SimpleRoomDatabase;
import ru.rinastachel.mappy.database.dao.CategoryDao;
import ru.rinastachel.mappy.database.entity.table.CategoryTable;

public class CategoryRepository {

    private CategoryDao mCategoryDao;

    public CategoryRepository(Application application) {
        SimpleRoomDatabase db = SimpleRoomDatabase.getDatabase(application);
        mCategoryDao = db.categoryDao();
    }

    public LiveData<List<CategoryTable>> getCategories() {
        return  mCategoryDao.getCategories();
    }

    public void insert (CategoryTable categoryTable) {
        new insertAsyncTask(mCategoryDao).execute(categoryTable);
    }

    private static class insertAsyncTask extends AsyncTask<CategoryTable, Void, Void> {

        private CategoryDao mAsyncCategoryDao;

        insertAsyncTask(CategoryDao dao) {
            mAsyncCategoryDao = dao;
        }

        @Override
        protected Void doInBackground(final CategoryTable... params) {
            mAsyncCategoryDao.insert(params[0]);
            return null;
        }
    }
}
