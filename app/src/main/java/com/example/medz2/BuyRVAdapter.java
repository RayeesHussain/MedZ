package com.example.medz2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BuyRVAdapter extends ListAdapter<BuyModal, BuyRVAdapter.ViewHolder> {


    private OnItemClickListener listener;


    BuyRVAdapter() {
        super(DIFF_CALLBACK);
    }


    private static final DiffUtil.ItemCallback<BuyModal> DIFF_CALLBACK = new DiffUtil.ItemCallback<BuyModal>() {
        @Override
        public boolean areItemsTheSame(BuyModal oldItem, BuyModal newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(BuyModal oldItem, BuyModal newItem) {
            return oldItem.getPillName().equals(newItem.getPillName()) &&
                    oldItem.getPillQuantity().equals(newItem.getPillQuantity());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buy_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // below line of code is use to set data to
        // each item of our recycler view.
        BuyModal model = getCourseAt(position);
        holder.pillNameTV.setText(model.getPillName());
        holder.pillQuantityTV.setText(model.getPillQuantity());

    }

    // creating a method to get course modal for a specific position.
    public BuyModal getCourseAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // view holder class to create a variable for each view.
        TextView pillNameTV, pillQuantityTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing each view of our recycler view.
            pillNameTV = itemView.findViewById(R.id.idTVCourseName);
            pillQuantityTV = itemView.findViewById(R.id.idTVCourseDuration);

            // adding on click listener for each item of recycler view.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // inside on click listener we are passing
                    // position to our item of recycler view.
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(BuyModal model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

