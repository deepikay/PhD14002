package com.example.abc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Post extends ActionBarActivity implements android.view.View.OnClickListener{

	public static String url =  "http://192.168.21.49:8080/ApacheServer/VideoData";
	
	EditText txt1,txt2,txt3, txt4,txt5;
	Button btn;
	String output = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		
		System.out.println("POst Activity entered");
		Log.d("abc","POst Activity onCreate");
		txt1 = (EditText)findViewById(R.id.editText1);
		txt2 = (EditText)findViewById(R.id.editText2);
		txt3 = (EditText)findViewById(R.id.editText3);
		txt4 = (EditText)findViewById(R.id.editText4);
		txt5 = (EditText)findViewById(R.id.editText5);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
	
		Toast toast = Toast.makeText(getApplicationContext(), output, Toast.LENGTH_SHORT);
				
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btn){
			
			uploadData();
		}
	}

	void uploadData () {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
										
					List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(5);

					nameValuePair.add(new BasicNameValuePair("file_name",txt1.getText().toString()));
					nameValuePair.add(new BasicNameValuePair("file_size",txt2.getText().toString()));
					nameValuePair.add(new BasicNameValuePair("duration", txt3.getText().toString()));
					nameValuePair.add(new BasicNameValuePair("type", txt4.getText().toString()));
					nameValuePair.add(new BasicNameValuePair("url", txt5.getText().toString()));
					
					
					HttpClient httpClient = new DefaultHttpClient();
					
					HttpPost httpPost = new HttpPost(url);
					
							
				
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
				} catch (UnsupportedEncodingException e) {
					// writing error to Log
					e.printStackTrace();
				}
				
				
				// Making HTTP Request
				try {
					HttpResponse response = httpClient.execute(httpPost);

					// writing response to log
					HttpEntity entity = response.getEntity();
					final String responseText = EntityUtils
							.toString(entity);
					output = responseText;
					Log.d("abc", responseText);
				} catch (ClientProtocolException e) {
					// writing exception to log
					e.printStackTrace();
				} catch (IOException e) {
					// writing exception to log
					e.printStackTrace();

				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	});

		thread.start();
        }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post, menu);
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


}
