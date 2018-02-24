package com.meetings.fun.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by manoj on 24-Feb-18.
 */

public class Tab2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2, container, false);

        final LinearLayout lm = (LinearLayout)rootView.findViewById(R.id.tab2linear);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout ll = new LinearLayout(lm.getContext());
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView heading=new TextView(lm.getContext());
        heading.setTypeface(Typeface.DEFAULT_BOLD);
        heading.setTextSize(20);
        heading.setText("Schedule on Date");

        ll.addView(heading);
        TextView content=new TextView(lm.getContext());
        content.setText("Holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ll.addView(content);
        lm.addView(ll);

        return  rootView;
    }
}
