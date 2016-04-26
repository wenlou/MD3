package com.example.md3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.md3.activity.AppBarDetailActivity;
import com.example.md3.R;

/**
 * Created by sxj52 on 2016/4/19.
 */
public class CardFragment extends Fragment {
    private CardView cardView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cardview, null);
        cardView= (CardView) view.findViewById(R.id.card);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AppBarDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
    public void goDetail(View view){
        Intent intent = new Intent(getActivity(),AppBarDetailActivity.class);
        startActivity(intent);
    }


//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(getActivity(),AppBarDetailActivity.class);
//        //startActivity(intent);
//        ActivityCompat.startActivity(getActivity(),intent,null);
//
//    }
}
