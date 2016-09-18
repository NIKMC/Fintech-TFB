package com.inspirussia.nikmc.fintech_tfb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.inspirussia.nikmc.fintech_tfb.R;
import java.util.List;

/**
 * Created by NIKMC on 17-Sep-16.
 */
public class SpinnerCardAdapter extends BaseAdapter {
    Context context;
    List<modelSpinnerElement> creditCards;
    LayoutInflater inflater;

    public SpinnerCardAdapter(Context context, List<modelSpinnerElement> creditCard) {
        this.context = context;
        this.creditCards = creditCard;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return creditCards.size();
    }

    @Override
    public modelSpinnerElement getItem(int position) {
        return creditCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_list_spinner,null);
        }

        TextView mTitle = (TextView)view.findViewById(R.id.card_title);
        TextView mNumber = (TextView)view.findViewById(R.id.card_number);
        TextView mInfo = (TextView)view.findViewById(R.id.card_info);
        mTitle.setText(creditCards.get(position).getBalance().toString());
        mNumber.setText(creditCards.get(position).getNumber().toString());
        mInfo.setText(creditCards.get(position).getInfo().toString());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_list_spinner,null);
        }

        TextView mTitle = (TextView)view.findViewById(R.id.card_title);
        TextView mNumber = (TextView)view.findViewById(R.id.card_number);
        TextView mInfo = (TextView)view.findViewById(R.id.card_info);
        mTitle.setText(creditCards.get(position).getBalance().toString());
        mNumber.setText(creditCards.get(position).getNumber().toString());
        mInfo.setText(creditCards.get(position).getInfo().toString());
        return view;
    }
}
