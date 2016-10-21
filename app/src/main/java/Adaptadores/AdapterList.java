package Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.oscar.pruebadescargafichero.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import POJO.Combination;

/**
 * Created by Oscar on 20/10/2016.
 */

public class AdapterList extends BaseAdapter {

    private Activity activity;
    private ArrayList<Combination> mCombinationArrayList;

    public AdapterList(Activity activity, ArrayList<Combination> combinationArrayList) {
        this.activity = activity;
        mCombinationArrayList = combinationArrayList;
    }

    @Override
    public int getCount() {
        return mCombinationArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCombinationArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCombinationArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView == null){
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.combination_row,null,true);
        }

        Combination comb = mCombinationArrayList.get(position);

        TextView textViewDate = (TextView) view.findViewById(R.id.textview_Date);
        TextView textViewN1 = (TextView) view.findViewById(R.id.textview_N1);
        TextView textViewN2 = (TextView) view.findViewById(R.id.textview_N2);
        TextView textViewN3 = (TextView) view.findViewById(R.id.textview_N3);
        TextView textViewN4 = (TextView) view.findViewById(R.id.textview_N4);
        TextView textViewN5 = (TextView) view.findViewById(R.id.textview_N5);
        TextView textViewEst1 = (TextView) view.findViewById(R.id.textview_Est1);
        TextView textViewEst2 = (TextView) view.findViewById(R.id.textview_Est2);



        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        textViewDate.setText(df.format(comb.getFecha()));
        textViewN1.setText(Integer.toString(comb.getN1()));
        textViewN2.setText(Integer.toString(comb.getN2()));
        textViewN3.setText(Integer.toString(comb.getN3()));
        textViewN4.setText(Integer.toString(comb.getN4()));
        textViewN5.setText(Integer.toString(comb.getN5()));
        textViewEst1.setText(Integer.toString(comb.getEst1()));
        textViewEst2.setText(Integer.toString(comb.getEst2()));


        return view;
    }
}
