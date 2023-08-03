package com.example.newshunt.fragments;

import android.animation.StateListAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.newshunt.MainActivity;
import com.example.newshunt.R;
import com.google.android.material.button.MaterialButton;

public class NewsSelectionFragment extends Fragment {
    ImageView arrowLeft;
    MaterialButton following,browse;
    ViewPager2 viewPager;
    HomeFragment homeFragment=new HomeFragment();

    FollowingNewsFragment followingNewsFragment=new FollowingNewsFragment();
    BrowseNewsFragment browseNewsFragment=new BrowseNewsFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_news_selection, container, false);



        arrowLeft=view.findViewById(R.id.arrow_left_icon);
        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.ReplaceFragment(homeFragment);
            }
        });



        following=view.findViewById(R.id.following_button);
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browse.setBackgroundColor(getResources().getColor(R.color.white));
                browse.setTextColor(getResources().getColor(R.color.primary));
                following.setBackgroundColor(getResources().getColor(R.color.primary));
                following.setTextColor(getResources().getColor(R.color.white));
                viewPager.setCurrentItem(0);
            }
        });



        browse=view.findViewById(R.id.browse_button);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browse.setBackgroundColor(getResources().getColor(R.color.primary));
                browse.setTextColor(getResources().getColor(R.color.white));
                following.setBackgroundColor(getResources().getColor(R.color.white));
                following.setTextColor(getResources().getColor(R.color.primary));
                viewPager.setCurrentItem(1);
            }
        });


        viewPager=view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new NewsPagerAdapter(this));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if (position==0)
                {
                    browse.setBackgroundColor(getResources().getColor(R.color.white));
                    browse.setTextColor(getResources().getColor(R.color.primary));
                    following.setBackgroundColor(getResources().getColor(R.color.primary));
                    following.setTextColor(getResources().getColor(R.color.white));
                } else {

                    browse.setBackgroundColor(getResources().getColor(R.color.primary));
                    browse.setTextColor(getResources().getColor(R.color.white));
                    following.setBackgroundColor(getResources().getColor(R.color.white));
                    following.setTextColor(getResources().getColor(R.color.primary));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);


            }
        });



        return view;
    }



    private class NewsPagerAdapter extends FragmentStateAdapter {
        private static final int NUM_PAGES = 2;

        public NewsPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return followingNewsFragment;
            } else {
                return browseNewsFragment;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }


}