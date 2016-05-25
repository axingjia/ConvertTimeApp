package com.example.amazon.communicationbetweenfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by amazon on 2016-02-04.
 */
public class From_Search_Fragment extends Fragment {

    MainActivity activity;
    private ListView lv;
    EditText inputSearch;
    ArrayAdapter<String> adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        callback= (Callback) activity;
        this.activity = (MainActivity) activity;


    }

    //    String[] listitems=activity.listitems;
    public String[] listitems = {"America/Edmonton", "America/Los_Angeles", "America/Mexico_City", "America/New_York", "America/Toronto", "America/Winnipeg", "Asia/Bangkok", "Asia/Harbin", "Asia/Hong_Kong",
            "Asia/Macao", "Asia/Shanghai", "Asia/Singapore", "Asia/Taipei", "Asia/Tokyo", "Australia/Sydney", "Canada/Eastern", "Canada/Pacific", "Europe/Berlin", "Europe/Moscow", "Europe/Paris", "Europe/Rome",
            "US/Pacific"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_template, container, false);
        lv = (ListView) view.findViewById(R.id.list_view);
        inputSearch = (EditText) view.findViewById(R.id.inputSearch);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listitems);
        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }
}
