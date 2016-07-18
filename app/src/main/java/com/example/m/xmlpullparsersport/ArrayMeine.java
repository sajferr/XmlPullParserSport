package com.example.m.xmlpullparsersport;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by m on 2016-07-18.
 */
public class ArrayMeine extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<SportCollected> objects;

    public ArrayMeine(Context context, int resource, ArrayList<SportCollected> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects= objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tekst1,tekst2,tekst3,tekst4;
        DataHandler handler ;

        if (convertView==null){
            handler = new DataHandler();
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(resource,parent,false);
           handler.tekst1=(TextView)convertView.findViewById(R.id.textView);
           handler.tekst2=(TextView)convertView.findViewById(R.id.textView2);
           handler.tekst3=(TextView)convertView.findViewById(R.id.textView3);
           handler.tekst4=(TextView)convertView.findViewById(R.id.textView4);
            convertView.setTag(handler);

        }
        else{
            handler= (DataHandler) convertView.getTag();

        }
        handler.tekst1.setText(objects.get(position).getName());
        Log.d("Uwaga","teksty");
        handler.tekst2.setText(objects.get(position).getBoisko());
        handler.tekst3.setText(objects.get(position).getGwiazda());
        handler. tekst4.setText(objects.get(position).getTrener());

        return convertView;

    }



    public class DataHandler{
        TextView tekst1;
        TextView tekst2;
        TextView tekst3;
        TextView tekst4;

    }
}
