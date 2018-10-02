package ru.rinastachel.mappy.database.repo;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import ru.rinastachel.mappy.database.SimpleRoomDatabase;
import ru.rinastachel.mappy.database.dao.TaskDao;
import ru.rinastachel.mappy.database.entity.Task;
import ru.rinastachel.mappy.database.entity.table.TaskTable;

public class TaskRepository {

    private TaskDao mTaskDao;

    public TaskRepository(Application application) {
        SimpleRoomDatabase db = SimpleRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
    }

    public LiveData<List<Task>> getTasks() {
        return  mTaskDao.getTasks();
    }

    public void insert (TaskTable task) {
        new insertAsyncTask(mTaskDao).execute(task);
    }

    private static class insertAsyncTask extends AsyncTask<TaskTable, Void, Void> {

        private TaskDao mAsyncTaskDao;

        insertAsyncTask(TaskDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final TaskTable... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}