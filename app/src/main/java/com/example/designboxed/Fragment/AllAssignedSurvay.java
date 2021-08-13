package com.example.designboxed.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.designboxed.Adaptor.AdapterAllAssignedSurvay;
import com.example.designboxed.Model.ModelCompletedSurvay;
import com.example.designboxed.databinding.FragmentAllAssignedServiceBinding;

import java.util.ArrayList;
import java.util.List;

public class AllAssignedSurvay extends Fragment {
    FragmentAllAssignedServiceBinding binding;
    List<ModelCompletedSurvay> modelCompletedSurvays;
    AdapterAllAssignedSurvay adapterAllAssignedSurvay;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllAssignedServiceBinding.inflate(getLayoutInflater());
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
        adapterAllAssignedSurvay = new AdapterAllAssignedSurvay(getContext(),modelCompletedSurvays);
        binding.recAllAssigned.setAdapter(adapterAllAssignedSurvay);
    }
}