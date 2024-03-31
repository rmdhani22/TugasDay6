package com.example.day6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {


    private ArrayList<ModelItem> modelItem;

    public AdapterItem(ArrayList<ModelItem> modelItem) {
        this.modelItem = modelItem;
    }

    @NonNull
    @Override
    public AdapterItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vholder = new ViewHolder(view);
        return vholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem.ViewHolder holder, int position) {
        holder.namaItem.setText(modelItem.get(position).getNamaItem());
        holder.gambarItem.setImageResource(modelItem.get(position).getGambarItem());
    }

    @Override
    public int getItemCount() {
        return modelItem.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ModelItem model);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView namaItem;
        ImageView gambarItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaItem = itemView.findViewById(R.id.nama_Item);
            gambarItem = itemView.findViewById(R.id.gambar_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(modelItem.get(position));
                }
            }
        }
    }
}