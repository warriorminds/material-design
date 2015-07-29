package com.warriorminds.materialdesign;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    /* ViewHolder class that holds each element in your RecyclerView. */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewName;
        public TextView mTextViewDetails;
        public View mView;

        /* In this example, you have two textViews. You will add here all your
        * layout items from your item layout. */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = (TextView) view.findViewById(R.id.nameTextView);
            mTextViewDetails = (TextView) view.findViewById(R.id.infoTextView);
        }
    }

    private ArrayList<Info> infoList;

    /* Get your data set */
    public InfoAdapter(ArrayList<Info> info){
        infoList = info;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        /* inflate the layout for each RecyclerView item*/
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        /* Create the view holder */
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    /* Use this method to set the values for each element of your item. */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        /* Get the element from the list and assign values to the view. */
        /* This implementation will be unique for each recyclerview that you use. */
        Info infoItem = infoList.get(position);
        viewHolder.mTextViewDetails.setText(infoItem.getDetails());
        viewHolder.mTextViewName.setText(infoItem.getName());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }
}
