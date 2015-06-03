package com.james.novgorodapp.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.james.novgorodapp.fragment.MainActivityFragment;
import com.james.novgorodapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager mFm = getSupportFragmentManager();
        FragmentTransaction ft = mFm.beginTransaction();
        ft.add(R.id.main_layout, new MainActivityFragment(), "main frag add");
        ft.commit();
    }
}
