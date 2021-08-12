package com.example.designboxed.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designboxed.Models.ModelNotifications;
import com.example.designboxed.R;

import java.util.ArrayList;

public class AdaptorNotification extends RecyclerView.Adapter<AdaptorNotification.MyHolder> {

    Context context;
    ArrayList<ModelNotifications> data;

    public AdaptorNotification(Context context, ArrayList<ModelNotifications> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_notification,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.txtData.setText(data.get(position).getTextview());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView txtData;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            txtData=itemView.findViewById(R.id.txtData);
        }
    }
}
