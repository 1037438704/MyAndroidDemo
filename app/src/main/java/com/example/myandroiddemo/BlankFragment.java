package com.example.myandroiddemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class BlankFragment extends Fragment {


    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int count = bundle.getInt("count");
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        text = view.findViewById(R.id.text_id);
        text.setText(count + "");
        return view;
    }

    public static BlankFragment newInstance(int count) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt("count", count);
        fragment.setArguments(args);
        return fragment;
    }
}