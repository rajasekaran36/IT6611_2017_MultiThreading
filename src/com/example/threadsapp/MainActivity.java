package com.example.threadsapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity extends Activity{
	TextView tv;
	Handler handler;
	EditText limit;
	Button push;
	int data = 0;
	Runnable run;
	Runnable colorChanger;
	NumberPicker pic;
	int[] colors = {Color.GREEN, Color.RED};
	boolean is_green = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	handler = new Handler();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.secs);
        limit = (EditText) findViewById(R.id.limit);
        push = (Button) findViewById (R.id.push_button);
       
        tv.setText("");
        
        run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(data!=-1){
				tv.setText(String.valueOf(data));
				data = data - 1;
				handler.postDelayed(this, 100);
			}
			}
		};
		
		colorChanger = new Runnable() {
			
			@Override
			public void run() {
				
				if(is_green){
					tv.setTextColor(Color.RED);
					is_green = false;
				}
				else {
					tv.setTextColor(Color.GREEN);
					is_green = true;
				}
				
				handler.postDelayed(this, 200);
			}
		};
		
		
		push.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				data = Integer.parseInt(limit.getText().toString());
				handler.post(run);
				handler.post(colorChanger);
			}
		});
		
    }
}


