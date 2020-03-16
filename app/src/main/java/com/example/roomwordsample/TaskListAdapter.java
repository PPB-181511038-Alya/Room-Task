package com.example.roomwordsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskName;
        private final TextView taskDeadline;

        private TaskViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.to_do_task);
            taskDeadline = itemView.findViewById(R.id.to_do_schedule);
        }
    }

    private final LayoutInflater mInflater;
    private List<Task> task_item; // Cached copy of words

    TaskListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        if (task_item != null) {
            Task current = task_item.get(position);
            holder.taskName.setText(current.getTaskName());
            holder.taskDeadline.setText(current.getTaskDeadline());
        } else {
            // Covers the case of data not being ready yet.
            holder.taskName.setText("No Word");
            holder.taskDeadline.setText("No Word");
        }
    }

    void setTasks(List<Task> tasks){
        task_item = tasks;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (task_item != null)
            return task_item.size();
        else return 0;
    }
}
