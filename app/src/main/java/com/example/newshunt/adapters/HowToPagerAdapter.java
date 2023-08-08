package com.example.newshunt.adapters;

import android.content.Context;
import android.media.Image;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.newshunt.R;
import com.example.newshunt.model.HowTo;

import java.util.ArrayList;

public class HowToPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<HowTo> howToList;

    public HowToPagerAdapter(Context context, ArrayList<HowTo> howToList) {
        this.context = context;
        this.howToList = howToList;
    }

    @Override
    public int getCount() {
        return howToList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.how_to_cardview, container, false);
        HowTo howTo = howToList.get(position);

        TextView titleTextView = view.findViewById(R.id.title_textview);
        ImageView imageView = view.findViewById(R.id.image_view);
        TextView descriptionTextView = view.findViewById(R.id.description_textview);

        Spanned hmtTitle = HtmlCompat.fromHtml(howTo.getTitle(),HtmlCompat.FROM_HTML_MODE_COMPACT);
        titleTextView.setText(hmtTitle);

        imageView.setImageResource(howTo.getImageResourceId());

        Spanned htmDescription=HtmlCompat.fromHtml(howTo.getDescription(),HtmlCompat.FROM_HTML_MODE_COMPACT);
        descriptionTextView.setText(htmDescription);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

