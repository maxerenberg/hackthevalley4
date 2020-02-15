package com.hackthevalley4.hackthevalleyiv.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackthevalley4.hackthevalleyiv.R;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private EventData eventData = new EventData();
    public AdapterView.OnItemClickListener itemClickListener;

    @NonNull
    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eventRow = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.event_row,parent,false);
        return new ViewHolder(eventRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Context context = holder.eventTitle.getContext();


    }

    @Override
    public int getItemCount() {

        return eventData.eventList().size;
    }

    public void setOnClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public TextView eventTitle;
        public TextView eventDate;
        public TextView eventDescription;
        public TextView eventLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            eventTitle = itemView.findViewById(R.id.eventTitle);
            eventDate = itemView.findViewById((R.id.eventDate));
            eventDescription = itemView.findViewById(R.id.eventDescription);
            eventLocation = itemView.findViewById(R.id.eventLocation);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
