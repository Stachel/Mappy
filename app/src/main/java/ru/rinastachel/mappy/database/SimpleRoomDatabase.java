package ru.rinastachel.mappy.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import ru.rinastachel.mappy.BuildConfig;
import ru.rinastachel.mappy.database.dao.CategoryDao;
import ru.rinastachel.mappy.database.dao.TaskDao;
import ru.rinastachel.mappy.database.entity.table.CategoryTable;
import ru.rinastachel.mappy.database.entity.table.TaskTable;


@Database(entities = {TaskTable.class, CategoryTable.class},
        version = BuildConfig.VERSION_CODE, exportSchema = false)
public abstract class SimpleRoomDatabase extends RoomDatabase {

    //Daos
    public abstract TaskDao taskDao();
    public abstract CategoryDao categoryDao();

    private static SimpleRoomDatabase instance;

    public static SimpleRoomDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (SimpleRoomDatabase.class) {
                if (instance == null) {
                    // Create database
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            SimpleRoomDatabase.class, "simple_database")
                            .addCallback(new RoomDatabase.Callback(){
                                @Override
                                public void onOpen (@NonNull SupportSQLiteDatabase db){
                                    super.onOpen(db);
                                    //new DatabaseOpenerAsync(instance).execute();
                                }
                            })
                            .build();
                }
            }
        }
        return instance;
    }

    private static class DatabaseOpenerAsync extends AsyncTask<Void, Void, Void> {

        private final TaskDao mTaskDao;
        private final CategoryDao mCategoryDao;

        DatabaseOpenerAsync(SimpleRoomDatabase db) {
            mTaskDao = db.taskDao();
            mCategoryDao = db.categoryDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mTaskDao.deleteAll();
            mCategoryDao.deleteAll();

            for (int i = 0; i < 3; i++) {
                CategoryTable cat = new CategoryTable();
                cat.setTitle("CategoryTable " + i);
                mCategoryDao.insert(cat);
            }

            for (int i = 0; i < 5; i++) {
                TaskTable type = new TaskTable();
                type.setTitle("Name " + i);
                type.setCategoryId(2);
                mTaskDao.insert(type);
            }



            return null;
        }
    }


}