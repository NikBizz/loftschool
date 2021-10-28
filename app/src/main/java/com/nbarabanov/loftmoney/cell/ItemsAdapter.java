package com.nbarabanov.loftmoney.cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nbarabanov.loftmoney.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> itemList = new ArrayList<>();
    private int currentPosition;

    public void setData(List<Item> items, int position) {
        itemList.clear();
        itemList = items;
        currentPosition = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInFlater = LayoutInflater.from(parent.getContext());
        return new ItemViewHolder(layoutInFlater.inflate(R.layout.cell_money, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ItemViewHolder holder, int position) {
        holder.bind(itemList.get(position), currentPosition);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView priceTextView;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.moneyCellTitleView);
            priceTextView = itemView.findViewById(R.id.moneyCellPriceView);
        }

        public void bind(Item item, int position) {
            titleTextView.setText(item.getTitle());
            priceTextView.setText(item.getPrice());
            if (position == 0) {
                priceTextView.setTextColor(priceTextView.getResources().getColor(R.color.blue));
            } else {
                priceTextView.setTextColor(priceTextView.getResources().getColor(R.color.green));
            }
        }
    }
}