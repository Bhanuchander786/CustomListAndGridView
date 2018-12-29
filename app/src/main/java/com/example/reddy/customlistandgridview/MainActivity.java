package com.example.reddy.customlistandgridview;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list = new ArrayList<>();
    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.btn1);
        list.add("hello");
        list.add("hii");
        list.add("reddy");
        button.setOnClickListener(new View.OnClickListener() {
            Adapter1 a= new Adapter1();
            @Override
            public void onClick(View v) {
                ListView lv=findViewById(R.id.listView);

                list.add(""+i+"");
                i++;
                a.notifyDataSetChanged();
                lv.setAdapter(a);


            }
        });


    }
   class Adapter1 extends BaseAdapter{

        @Override
        public int getCount() {

            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.listitem1,parent,false);
                TextView tv=convertView.findViewById(R.id.txt);
             String a = tv.getText().toString();
                tv.setText(+position+list.get(position)+"     "+a);

            }
            return convertView;
        }
    }
}
