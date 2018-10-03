package ru.rinastachel.mappy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import ru.rinastachel.mappy.R;
import ru.rinastachel.mappy.database.entity.Task;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TypeViewHolder> {

    private final LayoutInflater mInflater;
    private List<Task> mTasks; // Cached copy of types

    public TaskListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_main_recycler, parent, false);
        return new TypeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TypeViewHolder holder, int position) {
        if (mTasks != null) {
            Task current = mTasks.get(position);
            switch (current.getPriority()) {
                case HIGH:
                    holder.priority.setBackgroundColor(Color.RED);
                    break;
                case NORMAL:
                    holder.priority.setBackgroundColor(Color.GREEN);
                    break;
                default:
                    holder.priority.setBackgroundColor(Color.GRAY);
                    break;
            }

            holder.title.setText(current.getTitle());
            holder.category.setText(current.getCategoryName());
        } else {
            // Covers the case of data not being ready yet.
            holder.title.setText("No Word");
        }
    }

    public void setData(List<Task> words){
        mTasks = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }

    class TypeViewHolder extends RecyclerView.ViewHolder {
        private final View priority;
        private final TextView category;
        private final TextView title;

        private TypeViewHolder(View itemView) {
            super(itemView);
            priority = itemView.findViewById(R.id.priority);
            category = itemView.findViewById(R.id.category);
            title = itemView.findViewById(R.id.title);
        }
    }
}