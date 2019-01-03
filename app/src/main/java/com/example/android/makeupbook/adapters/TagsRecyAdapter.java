package com.example.android.makeupbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.makeupbook.R;
import com.example.android.makeupbook.objects.Colors;
import com.squareup.picasso.Picasso;

public class TagsRecyAdapter extends RecyclerView.Adapter<TagsRecyAdapter.TagsViewHolder> {
    private Context mContext;

    public TagsRecyAdapter(){

    }

    public TagsRecyAdapter(Context context){
        mContext = context;
    }
    @Override
    public TagsRecyAdapter.TagsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.grid_tag_list,viewGroup,false);
        return new TagsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TagsRecyAdapter.TagsViewHolder tagsViewHolder, int i) {
        tagsViewHolder.tagText.setText(mContext.getResources().getStringArray(R.array.tagsArray)[i]);
        String url = mContext.getResources().getStringArray(R.array.tagsImageArray)[i];
        Picasso.with(mContext)
                .load(url)
                .fit()
                .placeholder(R.color.white)
                .into(tagsViewHolder.tagImage);

    }

    @Override
    public int getItemCount() {
        return mContext.getResources().getStringArray(R.array.tagsArray).length;
    }

    public class TagsViewHolder extends RecyclerView.ViewHolder {
        public TextView tagText;
        public ImageView tagImage;
        public TagsViewHolder(@NonNull View itemView) {
            super(itemView);
            tagText = itemView.findViewById(R.id.tag_names);
            tagImage = itemView.findViewById(R.id.tag_images);
        }
    }
}