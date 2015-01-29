package com.pruebas.spinnercomplejo;

import android.os.Bundle;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity {
    // declare three arrays for content of spinner
    String[] strings = {"Inter Milan","AC Milan",
            "Manchester City", "Barcelona", "Valencia","Juventus"};

    String[] subs = {"Italia","Italia",
            "England", "Spain", "Spain","Italia"};

    int arr_images[] = { R.drawable.pic1,
            R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6};

    Button button;
    TextView textview;
    Spinner spinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        button = (Button)findViewById(R.id.button1);
        textview = (TextView)findViewById(R.id.textView);
        spinner = (Spinner)findViewById(R.id.spinner1);
        spinner.setAdapter(new AdapterSpinner(this, R.layout.row, strings));
    }
    // button onclick
    public void button_click(View view) {
        textview.setText(spinner.getSelectedItem().toString());
    }
    // Adapter class for spinner control
    public class AdapterSpinner extends ArrayAdapter<String>{

        public AdapterSpinner(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView,ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row, parent, false);
            TextView label=(TextView)row.findViewById(R.id.company);
            label.setText(strings[position]);

            TextView sub=(TextView)row.findViewById(R.id.sub);
            sub.setText(subs[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.image);
            icon.setImageResource(arr_images[position]);
            return row;
        }
    }
}
