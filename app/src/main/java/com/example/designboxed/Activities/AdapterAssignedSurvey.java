package com.example.designboxed.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designboxed.Model.ModelAssignedSurvey;
import com.example.designboxed.databinding.CardRecServeyListBinding;

import java.util.List;

public class AdapterAssignedSurvey extends RecyclerView.Adapter<AdapterAssignedSurvey.holderVie> {
    Context context;
    List<ModelAssignedSurvey> modelAssignedSurveys;

    public AdapterAssignedSurvey(Context context, List<ModelAssignedSurvey> modelAssignedSurveys) {
        this.context = context;
        this.modelAssignedSurveys = modelAssignedSurveys;
    }

    @NonNull
    @Override
    public holderVie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterAssignedSurvey.holderVie(CardRecServeyListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull holderVie holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelAssignedSurveys.size();
    }

    public class holderVie extends RecyclerView.ViewHolder{
        CardRecServeyListBinding cBinding;
        public holderVie(@NonNull CardRecServeyListBinding cBinding) {
            super(cBinding.getRoot());
            this.cBinding = cBinding;
        }
    }
}
