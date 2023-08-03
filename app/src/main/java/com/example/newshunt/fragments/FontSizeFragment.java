package com.example.newshunt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newshunt.MainActivity;
import com.example.newshunt.R;

import java.util.ArrayList;

public class FontSizeFragment extends Fragment {

    ImageView arrowLeft,arrowDown;
    TextView fontSizeTextview;
    HomeFragment homeFragment=new HomeFragment();

    ArrayList<String> sizeArray=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_font_size, container, false);

        sizeArray.add("12");
        sizeArray.add("14");
        sizeArray.add("16");
        sizeArray.add("18");
        sizeArray.add("20");
        sizeArray.add("22");
        sizeArray.add("24");

        arrowLeft=view.findViewById(R.id.arrow_left_icon);
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.ReplaceFragment(homeFragment);
            }
        });

        fontSizeTextview=view.findViewById(R.id.font_size_textView);
        arrowDown=view.findViewById(R.id.arrow_down);

        final ListView sizeListView = view.findViewById(R.id.size_listView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_activated_1, sizeArray);
        sizeListView.setAdapter(adapter);
        sizeListView.setVisibility(View.GONE);

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sizeListView.getVisibility() == View.VISIBLE) {
                    sizeListView.setVisibility(View.GONE);
                } else {
                    sizeListView.setVisibility(View.VISIBLE);
                }
            }
        });

        sizeListView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedSize = sizeArray.get(position);
            fontSizeTextview.setText(selectedSize);
//            int size= Integer.parseInt(selectedSize);
//            fontSizeTextview.setTextSize(size);
            sizeListView.setVisibility(View.GONE);

        });

        return view;
    }
}