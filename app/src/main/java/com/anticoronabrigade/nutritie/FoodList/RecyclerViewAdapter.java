package com.anticoronabrigade.nutritie.FoodList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.anticoronabrigade.nutritie.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FoodHolder> {

    private OnNoteListener mOnNoteListener;

    public class FoodHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView foodName;
        TextView proteine, calorii, amino1, amino2, amino3, amino4, amino5, amino6, amino7, amino8, amino9;
        OnNoteListener onNoteListener;

        FoodHolder(View itemView, OnNoteListener onNoteListener){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            foodName = itemView.findViewById(R.id.cv_food);
            proteine = itemView.findViewById(R.id.cv_proteine);
            calorii = itemView.findViewById(R.id.cv_calorii);
            amino1 = itemView.findViewById(R.id.cv_amino1);
            amino2 = itemView.findViewById(R.id.cv_amino2);
            amino3 = itemView.findViewById(R.id.cv_amino3);
            amino4 = itemView.findViewById(R.id.cv_amino4);
            amino5 = itemView.findViewById(R.id.cv_amino5);
            amino6 = itemView.findViewById(R.id.cv_amino6);
            amino7 = itemView.findViewById(R.id.cv_amino7);
            amino8 = itemView.findViewById(R.id.cv_amino8);
            amino9 = itemView.findViewById(R.id.cv_amino9);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    List<FoodItem> Notifications;
    Context context;

    public RecyclerViewAdapter(List<FoodItem> Notifications, OnNoteListener onNoteListener, Context context){
        this.Notifications=Notifications;
        this.mOnNoteListener=onNoteListener;
        this.context = context;
    }
    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        FoodHolder nh = new FoodHolder(v, mOnNoteListener);
        return nh;
    }

    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {
        holder.foodName.setText(Notifications.get(position).getName());
        holder.proteine.setText(String.format("Proteine: %s", Notifications.get(position).getProteine()));
        holder.calorii.setText(String.format("Calorii: %s", Notifications.get(position).getCalorii()));
        holder.amino1.setText(String.format(context.getResources().getString(R.string.amino1) + ": %s", Notifications.get(position).getAmino1()));
        holder.amino2.setText(String.format(context.getResources().getString(R.string.amino2) + ": %s", Notifications.get(position).getAmino2()));
        holder.amino3.setText(String.format(context.getResources().getString(R.string.amino3) + ": %s", Notifications.get(position).getAmino3()));
        holder.amino4.setText(String.format(context.getResources().getString(R.string.amino4) + ": %s", Notifications.get(position).getAmino4()));
        holder.amino5.setText(String.format(context.getResources().getString(R.string.amino5) + ": %s", Notifications.get(position).getAmino5()));
        holder.amino6.setText(String.format(context.getResources().getString(R.string.amino6) + ": %s", Notifications.get(position).getAmino6()));
        holder.amino7.setText(String.format(context.getResources().getString(R.string.amino7) + ": %s", Notifications.get(position).getAmino7()));
        holder.amino8.setText(String.format(context.getResources().getString(R.string.amino8) + ": %s", Notifications.get(position).getAmino8()));
        holder.amino9.setText(String.format(context.getResources().getString(R.string.amino9) + ": %s", Notifications.get(position).getAmino9()));
    }

    @Override
    public int getItemCount() {
        return Notifications.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}