package com.example.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository task_repo;

    private LiveData<List<Task>> all_task;

    public TaskViewModel(Application application) {
        super(application);
        task_repo = new TaskRepository(application);
        all_task = task_repo.getAllTask();
    }

    LiveData<List<Task>> getAllTask() { return all_task; }

    public void insert(Task task) { task_repo.insert(task); }
}
