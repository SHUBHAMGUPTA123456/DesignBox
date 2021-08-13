package com.example.designboxed.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designboxed.Model.ModelCompletedSurvay;
import com.example.designboxed.databinding.CardRecCompletedSurvayBinding;

import java.util.List;

public class AdapterCompletedSurvay extends RecyclerView.Adapter<AdapterCompletedSurvay.holderVi> {
    Context context;
    List<ModelCompletedSurvay> modelCompletedSurvays;

    public AdapterCompletedSurvay(Context context, List<ModelCompletedSurvay> modelCompletedSurvays) {
        this.context = context;
        this.modelCompletedSurvays = modelCompletedSurvays;
    }

    @NonNull
    @Override
    public holderVi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterCompletedSurvay.holderVi(CardRecCompletedSurvayBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull holderVi holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelCompletedSurvays.size();
    }

    public class holderVi extends RecyclerView.ViewHolder {
        CardRecCompletedSurvayBinding cBinding;
        public holderVi(@NonNull   CardRecCompletedSurvayBinding cBinding) {
            super(cBinding.getRoot());
            this.cBinding = cBinding;
        }
    }
}
