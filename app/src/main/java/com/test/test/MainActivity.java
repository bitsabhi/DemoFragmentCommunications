package com.test.test;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends ActionBarActivity implements Fragment1.CallBacks1, Fragment2.CallBacks2
{

    private FragmentManager mFragmentManager;
    private Fragment1 f1;
    private Fragment2 f2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        show1();
    }
    private void show1()
    {
        mFragmentManager.beginTransaction()
                .replace(R.id.f, new Fragment1()).commit();
        f1 = new Fragment1();
        f2 = new Fragment2();
    }
    private void show1(String text)
    {
        Bundle b = new Bundle();
        b.putString("key", text);
        f1.setArguments(b);
        mFragmentManager.beginTransaction()
                .replace(R.id.f, f1).commit();
    }

    private void show2(String text)
    {
        Bundle b = new Bundle();
        b.putString("key", text);
        f2.setArguments(b);
        mFragmentManager.beginTransaction()
                .replace(R.id.f, f2).commit();
    }


    @Override
    public void onClick1(String text)
    {
        setTitle("Fragment2");
        show2(text);
    }

    @Override
    public void onClick2(String text)
    {
        setTitle("Fragment1");
        show1(text);
    }
}
