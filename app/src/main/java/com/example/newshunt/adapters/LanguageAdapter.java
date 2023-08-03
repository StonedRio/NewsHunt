package com.example.newshunt.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshunt.R;
import com.example.newshunt.model.LanguageModel;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {
    private ArrayList<LanguageModel> languageList;

    public LanguageAdapter(ArrayList<LanguageModel> languageList) {
        this.languageList = languageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LanguageModel languageItem = languageList.get(position);
        holder.languageNameTextView.setText(languageItem.getName());
        holder.radioButton.setChecked(languageItem.isSelected());

        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (LanguageModel item : languageList) {
                    item.setSelected(false);
                }
                languageItem.setSelected(true);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView languageNameTextView;
        private RadioButton radioButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            languageNameTextView = itemView.findViewById(R.id.language_name);
            radioButton = itemView.findViewById(R.id.radio_button);
        }
    }
}
