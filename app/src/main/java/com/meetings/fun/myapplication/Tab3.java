package com.meetings.fun.myapplication;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meetings.fun.entity.Greetings;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by manoj on 24-Feb-18.
 */

public class Tab3 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);
        new HttpRequestTask().execute();
        return  rootView;
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Greetings> {
        @Override
        protected Greetings doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Greetings greeting = restTemplate.getForObject(url, Greetings.class);
                greeting.setContent("http://i67.tinypic.com/9kcmfs.jpg");
                return greeting;
            } catch (Exception e) {
                Log.e("Tab3", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Greetings greeting) {

            final LinearLayout lm = (LinearLayout)getActivity().findViewById(R.id.tab3linear);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            LinearLayout ll = new LinearLayout(lm.getContext());
            ll.setOrientation(LinearLayout.VERTICAL);

            TextView heading=new TextView(lm.getContext());
            heading.setTypeface(Typeface.DEFAULT_BOLD);
            heading.setTextSize(20);
            heading.setText(greeting.getId());

            ll.addView(heading);

            ImageView imageView=new ImageView(lm.getContext());
            new ImageLoadTask(greeting.getContent(),imageView).execute();
            /*TextView content=new TextView(lm.getContext());
            content.setText(greeting.getContent());*/
            ll.addView(imageView);
            lm.addView(ll);

        }

    }
}
