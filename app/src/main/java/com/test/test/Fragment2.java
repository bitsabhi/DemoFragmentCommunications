package com.test.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment implements View.OnClickListener
{

    private EditText e;
    private Button t;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_main2, container, false);
        if (v != null)
        {
            t = (Button) v.findViewById(R.id.tv2);
            t.setOnClickListener(this);
            e = (EditText) v.findViewById(R.id.et2);
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
        if (view.getId() == R.id.tv2)
        {

            mCallbAck.onClick2(e.getText().toString());
        }
    }

    public interface CallBacks2
    {
        void onClick2(String text);
    }

    private CallBacks2 mCallbAck;


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mCallbAck = (CallBacks2) context;
    }

}
