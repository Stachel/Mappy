package ru.rinastachel.mappy.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import ru.rinastachel.mappy.BuildConfig;
import ru.rinastachel.mappy.database.dao.TypeDao;
import ru.rinastachel.mappy.database.entity.Type;


@Database(entities = {Type.class}, version = BuildConfig.VERSION_CODE)
public abstract class SimpleRoomDatabase extends RoomDatabase {

    //Daos
    public abstract TypeDao typeDao();

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
                                    new DatabaseOpenerAsync(instance).execute();
                                }
                            })
                            .build();
                }
            }
        }
        return instance;
    }

    private static class DatabaseOpenerAsync extends AsyncTask<Void, Void, Void> {

        private final TypeDao mDao;

        DatabaseOpenerAsync(SimpleRoomDatabase db) {
            mDao = db.typeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();

            for (int i = 0; i < 10; i++) {
                Type type = new Type();
                type.setName("Name " + i);
                mDao.insert(type);
            }

            return null;
        }
    }


}