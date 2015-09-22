package com.test.test;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


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
        showFragment1();
    }
    private void showFragment1()
    {
        mFragmentManager.beginTransaction()
                .replace(R.id.f, new Fragment1()).commit();

    }
    private void showFragment1(String text)
    {
        f1 = new Fragment1();
        Bundle b = new Bundle();
        b.putString("key", text);
        f1.setArguments(b);
        mFragmentManager.beginTransaction()
                .replace(R.id.f, f1).commit();
    }

    private void showFragment2(String text)
    {
        f2 = new Fragment2();
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
        showFragment2(text);
    }

    @Override
    public void onClick2(String text)
    {
        setTitle("Fragment1");
        showFragment1(text);
    }
}
