package com.photocad.dibujartrazos;

import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SingleTouchEventView(this, null));
    }
}
