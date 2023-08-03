package com.example.newshunt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newshunt.MainActivity;
import com.example.newshunt.R;

public class AboutUsFragment extends Fragment {

    ImageView arrowLeft;
    HomeFragment homeFragment=new HomeFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_about_us, container, false);

        arrowLeft=view.findViewById(R.id.arrow_left_icon);
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.ReplaceFragment(homeFragment);
            }
        });

        return view;
    }
}