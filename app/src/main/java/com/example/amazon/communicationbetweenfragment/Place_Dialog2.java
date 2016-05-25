package com.example.amazon.communicationbetweenfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by amazon on 2016-01-26.
 */
public class Place_Dialog2 extends DialogFragment implements AdapterView.OnItemClickListener{
//    String[] listitems = {"America/Edmonton", "America/Los_Angeles", "America/Mexico_City", "America/New_York", "America/Toronto", "America/Winnipeg", "Asia/Bangkok", "Asia/Harbin", "Asia/Hong_Kong",
//            "Asia/Macao", "Asia/Shanghai", "Asia/Singapore", "Asia/Taipei", "Asia/Tokyo", "Australia/Sydney", "Canada/Eastern", "Canada/Pacific", "Europe/Berlin", "Europe/Moscow", "Europe/Paris", "Europe/Rome",
//            "US/Pacific"};
    ListView mylist;
    Callback callback;
    MainActivity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback= (Callback) activity;
        this.activity = (MainActivity) activity;


    }
    String[] listitems=activity.listitems;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_template, null, false);
        mylist = (ListView) view.findViewById(R.id.list);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listitems);

        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(this);


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        activity.toTimezone2 = listitems[position];
        callback.setToTimezone2(listitems[position]);
        dismiss();


    }


    public interface Callback{
        void setToTimezone2(String timezone);
    }
}
