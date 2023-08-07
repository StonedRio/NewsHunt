package com.example.newshunt.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.newshunt.MainActivity;
import com.example.newshunt.R;
import com.example.newshunt.adapters.HowToPagerAdapter;
import com.example.newshunt.model.HowTo;

import java.util.ArrayList;

public class HowToFragment extends Fragment {
    ImageView arrowLeft;
    HomeFragment homeFragment=new HomeFragment();
    TextView skip,next;
    Button doneButton;
    ViewPager viewPager;
    HowToPagerAdapter adapter;
    int currentPage = 0;
    int lastPage = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_how_to, container, false);




        arrowLeft=view.findViewById(R.id.arrow_left_icon);
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.ReplaceFragment(homeFragment);
            }
        });

        skip=view.findViewById(R.id.skip_text_view);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.ReplaceFragment(homeFragment);
            }
        });


        doneButton=view.findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity mainActivity = (MainActivity) requireActivity();
                    mainActivity.ReplaceFragment(homeFragment);
                }
        });





        next=view.findViewById(R.id.next_text_view);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    viewPager.setCurrentItem(currentPage+1,true);
            }
        });




        ArrayList<HowTo> list=new ArrayList<>();

        HowTo howTo1=new HowTo("Best place to find\n" +
                "the news you need . . .",R.drawable.how_to_image1,"");
        list.add(howTo1);

        HowTo howTo2=new HowTo("You can check news analysis by\n" +
                "pressing icons bellow each news",R.drawable.how_to_image2,"And also check its original source\n" +
                "by clicking View Source on every\n" +
                "news page . . .");
        list.add(howTo2);

        HowTo howTo3=new HowTo("Language Selection as easy as\n" +
                "clicking on language button on\n" +
                "home screen and selecting your\n" +
                "desired language ",R.drawable.how_to_image3,"");
        list.add(howTo3);

        HowTo howTo4=new HowTo("Customizing News Sources\n" +
                "Click menu and click on News\n" +
                "for current sources and for new\n" +
                "source go to follow tab . . .",R.drawable.how_to_image4,"");
        list.add(howTo4);

        HowTo howTo5=new HowTo("Customizing News Categories\n" +
                "Click menu and click on Category\n" +
                "for current categories and for new\n" +
                "categories go to follow tab . . .",R.drawable.how_to_image5,"");
        list.add(howTo5);





        viewPager=view.findViewById(R.id.view_pager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

                lastPage = viewPager.getAdapter() != null ? viewPager.getAdapter().getCount() - 1 : 0;


                if (currentPage == lastPage) {
                    doneButton.setVisibility(View.VISIBLE);
                    skip.setVisibility(View.GONE);
                    next.setVisibility(View.GONE);
                } else {
                    doneButton.setVisibility(View.GONE);
                    skip.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        adapter=new HowToPagerAdapter(getContext(),list);
        viewPager.setAdapter(adapter);





        return view;
    }
}