package com.example.roomwordsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Task {

    @PrimaryKey
    @NonNull
    private String taskName;
    private String taskDeadline;

    public Task(@NonNull String taskName, String taskDeadline) {
        this.taskName = taskName;
        this.taskDeadline = taskDeadline;
    }
    @NonNull
    public String getTaskName() {
        return taskName;
    }
    public String getTaskDeadline() {
        return taskDeadline;
    }
}
