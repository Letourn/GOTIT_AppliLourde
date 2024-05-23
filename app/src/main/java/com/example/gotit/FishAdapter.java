package com.example.gotit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.UserViewHolder> {
        private List<Poisson> poissons;

        public FishAdapter(List<Poisson> poissons) {
            this.poissons = poissons;
        }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search_fish, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Poisson poisson = poissons.get(position);
        holder.textViewName.setText(poisson.nom);
        holder.textViewLatinName.setText(poisson.nomlatin);
        holder.textViewDesc.setText(poisson.description);
    }

    @Override
    public int getItemCount() {
        return poissons.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewLatinName;
        TextView textViewDesc;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.Name);
            textViewLatinName = itemView.findViewById(R.id.LatinName);
            textViewDesc = itemView.findViewById(R.id.Desc);
        }
    }
}
