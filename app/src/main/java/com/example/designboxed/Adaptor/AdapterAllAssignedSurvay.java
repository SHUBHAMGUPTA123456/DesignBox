package com.example.designboxed.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designboxed.Model.ModelCompletedSurvay;
import com.example.designboxed.databinding.CardRecAllAssignedSurvayBinding;

import java.util.List;

public class AdapterAllAssignedSurvay extends RecyclerView.Adapter<AdapterAllAssignedSurvay.holderVi> {
    Context context;
    List<ModelCompletedSurvay> modelCompletedSurvays;
    public AdapterAllAssignedSurvay(Context context, List<ModelCompletedSurvay> modelCompletedSurvays) {
        this.context = context;
        this.modelCompletedSurvays = modelCompletedSurvays;
    }
    @NonNull
    @Override
    public holderVi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterAllAssignedSurvay.holderVi(CardRecAllAssignedSurvayBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull holderVi holder, int position) {

    }
    @Override
    public int getItemCount() {
        return modelCompletedSurvays.size();
    }

    public class holderVi extends RecyclerView.ViewHolder {
        CardRecAllAssignedSurvayBinding cBinding;
        public holderVi(@NonNull  CardRecAllAssignedSurvayBinding cBinding) {
            super(cBinding.getRoot());
            this.cBinding = cBinding;
        }
    }
}
