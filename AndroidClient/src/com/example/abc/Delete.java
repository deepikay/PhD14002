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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Delete extends ActionBarActivity implements OnClickListener{
	
	public static String url =  "http://192.168.21.49:8080/ApacheServer/VideoData";
	Button btn3;
	EditText txt12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		
		
		txt12 = (EditText) findViewById(R.id.editText12);
		btn3 = (Button)findViewById(R.id.button3);
		btn3.setOnClickListener(this);
		
		
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		delete();
		
		
	}
	
	
	void delete()
	{

		HttpClient httpClient = new DefaultHttpClient();
		
		HttpDelete httpdel = new HttpDelete(url);
		//List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(5);

		//nameValuePair.add(new BasicNameValuePair("file_name",txt12.getText().toString()));
		try{
		//	httpdel.setHeader("file_name", txt12.getText().toString());
		//	Uri uri = new Uri(txt12.getText().toString());
		//	httpdel.se;
		}catch(Exception r ){
			
			
			
		}
		try {
			HttpResponse response = httpClient.execute(httpdel);

			// writing response to log
			HttpEntity entity = response.getEntity();
			final String responseText = EntityUtils
					.toString(entity);
			
			Log.d("abc", responseText);
		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();
		} catch (IOException e) {
			// writing exception to log
			e.printStackTrace();

		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
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
