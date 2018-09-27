package ru.rinastachel.mappy.database.repo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import ru.rinastachel.mappy.database.SimpleRoomDatabase;
import ru.rinastachel.mappy.database.dao.TypeDao;
import ru.rinastachel.mappy.database.entity.Type;

public class TypeRepository implements ITypeRepository {

    private TypeDao mTypeDao;

    public TypeRepository(Application application) {
        SimpleRoomDatabase db = SimpleRoomDatabase.getDatabase(application);
        mTypeDao = db.typeDao();
    }

    @Override
    public LiveData<List<Type>> getAllTypes() {
        return  mTypeDao.getLiveDataAllTypes();
    }

    @Override
    public void insert (Type type) {
        new insertAsyncTask(mTypeDao).execute(type);
    }

    private static class insertAsyncTask extends AsyncTask<Type, Void, Void> {

        private TypeDao mAsyncTaskDao;

        insertAsyncTask(TypeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Type... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}