package com.example.designboxed.Activities.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.designboxed.Adaptor.AdapterAllAssignedSurvay;
import com.example.designboxed.Adaptor.AdapterCompletedSurvay;
import com.example.designboxed.Model.ModelCompletedSurvay;
import com.example.designboxed.R;
import com.example.designboxed.databinding.FragmentAllAssignedServiceBinding;

import java.util.ArrayList;
import java.util.List;

public class CompletedSurvay extends Fragment {
FragmentAllAssignedServiceBinding binding;
List<ModelCompletedSurvay> modelCompletedSurvays;
AdapterCompletedSurvay adapterCompletedSurvay;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllAssignedServiceBinding.inflate(inflater, container,false);
        recyclerPerform();
        return binding.getRoot();
    }
    private void recyclerPerform() {
        modelCompletedSurvays = new ArrayList<>();
        binding.recAllAssigned.setHasFixedSize(true);
        binding.recAllAssigned.setNestedScrollingEnabled(false);
        binding.recAllAssigned.setLayoutManager(new LinearLayoutManager(getContext()));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        modelCompletedSurvays.add(new ModelCompletedSurvay("How to Know About Covid Dose"));
        adapterCompletedSurvay = new AdapterCompletedSurvay(getContext(),modelCompletedSurvays);
        binding.recAllAssigned.setAdapter(adapterCompletedSurvay);
    }
}