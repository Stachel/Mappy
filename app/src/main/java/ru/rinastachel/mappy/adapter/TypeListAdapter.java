package ru.rinastachel.mappy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.rinastachel.mappy.R;
import ru.rinastachel.mappy.database.entity.Type;


public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.TypeViewHolder> {

    private final LayoutInflater mInflater;
    private List<Type> mTypes; // Cached copy of types

    public TypeListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_main_recycler, parent, false);
        return new TypeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TypeViewHolder holder, int position) {
        if (mTypes != null) {
            Type current = mTypes.get(position);
            holder.title.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.title.setText("No Word");
        }
    }

    public void setData(List<Type> words){
        mTypes = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTypes != null)
            return mTypes.size();
        else return 0;
    }

    class TypeViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        private TypeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
        }
    }
}