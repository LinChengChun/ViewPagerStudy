package com.example.trim.viewpagerstudy;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
public class FragmentTwo extends Fragment {

    private Context mContext = null;//上下文

    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyLog.i("[FragmentTwo] onCreate...");

        list = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            list.add("FragmentTwo与志玲的聊天记录" + i);
        }
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyLog.i("[FragmentTwo] onCreateView...");

        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        return view;
    }
}
