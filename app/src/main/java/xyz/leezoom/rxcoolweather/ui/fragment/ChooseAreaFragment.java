package xyz.leezoom.rxcoolweather.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.leezoom.rxcoolweather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseAreaFragment extends Fragment {


    public ChooseAreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_area, container, false);
    }

}
