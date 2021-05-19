package com.example.todolistsimple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterToUser extends RecyclerView.Adapter<AdapterToUser.ExampleViewHolder> {
    private ArrayList<ItemsList> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public TextView mTextView2;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView1= itemView.findViewById(R.id.line1);
            mTextView2= itemView.findViewById(R.id.line2);

        }
    }
// if any needed changes to be happens , here is the place
        public AdapterToUser(ArrayList<ItemsList> exampleList) {
            mExampleList = exampleList;
        }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ItemsList currentItem = mExampleList.get(position);

        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText(String.valueOf(currentItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
