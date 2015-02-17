package com.example.abc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	
	Button btn1, btn2, btn3, btn4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		btn3 = (Button)findViewById(R.id.button3);
		btn4 = (Button)findViewById(R.id.button4);
		
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		if(v==btn1)
		{
			Log.d("abc","Calling GetActivity");
			Intent intent = new Intent(getApplicationContext(),GetActivity.class);
			
			//intent.putExtra("Msg", "Hey");
			startActivity(intent);
			
		}
		if(v==btn2){
			
			Log.d("abc","Calling PostMehtod");
	
			Intent intent = new Intent(getApplicationContext(),Post.class);
			startActivity(intent);
			
			
		}
		if(v==btn3){
			
			Log.d("abc","Calling PutMethod");
			
			Intent intent = new Intent(getApplicationContext(),Put.class);
			startActivity(intent);
			
			
			
		}
		if(v==btn4){
			Log.d("abc","Calling DeleteMethod");
			
			Intent intent = new Intent(getApplicationContext(),Delete.class);
			startActivity(intent);
			
			
		}
		
		
		
	}
}
