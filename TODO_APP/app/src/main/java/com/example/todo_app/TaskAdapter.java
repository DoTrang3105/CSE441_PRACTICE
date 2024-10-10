package com.example.todo_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, List<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.edit_text_task);
        CheckBox checkBoxCompleted = convertView.findViewById(R.id.switch_show_completed);

        textViewName.setText(task.name);
        checkBoxCompleted.setChecked(task.completed);

        return convertView;
    }
}


