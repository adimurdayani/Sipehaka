package com.fauzia.sipehaka.ui.lihatdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.fauzia.sipehaka.LihatData1Activity;
import com.fauzia.sipehaka.R;

public class SlideshowFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lihatdata, container, false);
        final TextView textView = root.findViewById(R.id.textlihatData);

        return root;
    }
}