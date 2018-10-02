package ru.rinastachel.mappy.model;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import ru.rinastachel.mappy.database.entity.Task;
import ru.rinastachel.mappy.database.entity.table.TaskTable;
import ru.rinastachel.mappy.database.repo.TaskRepository;


public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;

    private LiveData<List<Task>> mTasks;

    public TaskViewModel(Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mTasks = mRepository.getTasks();
    }

    public LiveData<List<Task>> getTasks() { return mTasks; }

    public void insert(TaskTable word) { mRepository.insert(word); }
}