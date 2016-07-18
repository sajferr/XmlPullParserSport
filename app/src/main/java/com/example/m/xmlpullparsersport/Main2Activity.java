package com.example.m.xmlpullparsersport;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView lista;
    ArrayList<SportCollected> arrayList=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lista = (ListView)findViewById(R.id.listView);
        new Asyncc().execute();
    }



public class Asyncc extends AsyncTask<Void,String,String>{

    XmlPullParser parser;
    int wiela=0;
    String name;
    String tekst;
    SportCollected sportCollected;

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int alojzy = arrayList.size();
        ArrayMeine arrayMeine = new ArrayMeine(Main2Activity.this,R.layout.lista_row,arrayList);
        lista.setAdapter(arrayMeine);


    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
            parser.setInput(getAssets().open("lol3.xml"),null);
            wiela = parser.getEventType();
            while (wiela!=XmlPullParser.END_DOCUMENT){
                name = parser.getName();

                switch (wiela){
                    case XmlPullParser.START_TAG:
                       if  (name.equalsIgnoreCase("angielski")){
                           sportCollected = new SportCollected();

                    }
                       else if (name.equalsIgnoreCase("name")){
                            sportCollected.setName(parser.getAttributeValue(null,"name2"));
                        }
                        break;

                    case XmlPullParser.END_TAG:
                      if (name.equalsIgnoreCase("boisko")){
                       sportCollected.setBoisko(tekst);

                    }
                    else if (name.equalsIgnoreCase("gwiazda")){
                        sportCollected.setGwiazda(tekst);

                    }else if (name.equalsIgnoreCase("trener")) {
                          sportCollected.setTrener(tekst);
                          arrayList.add(sportCollected);
                      }
                        break;
                    case XmlPullParser.TEXT:
                         tekst = parser.getText();
                        break;

                }
               wiela = parser.next();






            }



        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
}
