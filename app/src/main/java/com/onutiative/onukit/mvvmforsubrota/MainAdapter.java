package com.onutiative.onukit.mvvmforsubrota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<GitFollower> followers = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GitFollower follower = followers.get(position);
        holder.checklist.setText(follower.getLogin());

    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    public void setGitFollower(List<GitFollower> followers) {
        this.followers = followers;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView checklist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checklist= itemView.findViewById(R.id.checklistTitle);
        }
    }
}
