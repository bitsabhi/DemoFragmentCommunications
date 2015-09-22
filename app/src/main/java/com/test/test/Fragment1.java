package com.test.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment implements View.OnClickListener
{

    private FragmentManager mFragmentManager;
    private Button t;
    private EditText e;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_main1, container, false);
        if (v != null)
        {
            t = (Button) v.findViewById(R.id.tv1);
            t.setOnClickListener(this);
            e = (EditText) v.findViewById(R.id.et1);
            e.setText("");
            if (getArguments() != null)
            {
                String s = (String) getArguments().get("key");
                e.setText(s);
            }
            return v;
        }
        return null;
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.tv1)
        {
            mCallbAck.onClick1(e.getText().toString());
        }
    }


    public interface CallBacks1
    {
        void onClick1(String text);
    }

    private CallBacks1 mCallbAck;


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mCallbAck = (CallBacks1) context;
    }

}
