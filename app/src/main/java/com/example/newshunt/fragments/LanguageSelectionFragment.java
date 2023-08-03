package com.example.newshunt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshunt.MainActivity;
import com.example.newshunt.R;
import com.example.newshunt.adapters.LanguageAdapter;
import com.example.newshunt.model.LanguageModel;
import com.google.android.material.button.MaterialButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LanguageSelectionFragment extends Fragment {
    ImageView arrowLeft;
    HomeFragment homeFragment=new HomeFragment();
    RecyclerView recyclerView;

    private ArrayList<LanguageModel> languageList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_language_selection, container, false);

        arrowLeft=view.findViewById(R.id.arrow_left_icon);
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.ReplaceFragment(homeFragment);
            }
        });


        languageList.add(new LanguageModel("English"));
        languageList.add(new LanguageModel("Arabic"));
        languageList.add(new LanguageModel("Urdu"));
        languageList.add(new LanguageModel("French"));
        languageList.add(new LanguageModel("Chinese"));
        languageList.add(new LanguageModel("Hindi"));
        languageList.add(new LanguageModel("Spanish"));
        languageList.add(new LanguageModel("Farsi"));

        recyclerView=view.findViewById(R.id.recycler_view);
        LanguageAdapter adapter=new LanguageAdapter(languageList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);





        return view;
    }

}