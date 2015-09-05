package com.project.be.samplelayout;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TabHost;
import android.widget.Toast;


public class MainActivity extends TabActivity {
    CheckBox c1,c2,c3;
    int key=0;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Success Stories");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("New Complains");

        tab1.setIndicator("Success Stories");
        tab1.setContent(new Intent(this,Tab1Activity.class));

        tab2.setIndicator("New Complains");
        tab2.setContent(new Intent(this,Tab2Activity.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

        //For the bottom sliding menu
        final Sliding popup = (Sliding) findViewById(R.id.sliding1);
        popup.setVisibility(View.GONE);

        final Button btn=(Button)findViewById(R.id.show1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(key==0){
                    popup.setVisibility(View.VISIBLE);
                    btn.setBackgroundResource(R.drawable.collapse);

                    Button opt1=(Button)findViewById(R.id.check1);
                    Button opt2=(Button)findViewById(R.id.check2);
                    Button opt3=(Button)findViewById(R.id.check3);

                    opt1.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            // TODO Auto-generated method stub
                            Intent intent;
                            intent = new Intent(MainActivity.this,MenuActivity1.class);
                            startActivity(intent);
                        }
                    });
                    key=1;
                }
                else if(key==1){
                    key=0;
                    popup.setVisibility(View.GONE);
                    btn.setBackgroundResource(R.drawable.collapse);
                }
            }
        });

    }
}
