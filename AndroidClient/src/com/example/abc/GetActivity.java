package com.example.abc;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GetActivity extends ActionBarActivity {

	//public static String url = "http://10.0.2.2:8080/HelloWorld/VideoData";
	
	//public static String url = "http://120.59.13.63:8080/HelloWorld/VideoData";
	//public static String url = "http://192.168.1.101:8080/ApacheServer/VideoData";
	public static String url =  "http://192.168.21.49:8080/ApacheServer/VideoData";
	//public static String url = "http://169.254.146.243:8080/HelloWorld/VideoData";
	
	TextView txtv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_get);
		
		
		//Intent intent = getIntent();
		System.out.println("Get Activity entered");
		Log.d("abc","GetActivity onCreate");
		txtv = (TextView)findViewById(R.id.textViewget);
		String output = null;
		
/*		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
		
					Log.d("abc",  "Inside Thread");
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            
            HttpResponse httpResponse = httpClient.execute(httpGet);
            StatusLine st = httpResponse.getStatusLine();
            Log.d("abc",st.toString());
            if(st.getStatusCode()== HttpStatus.SC_OK)
           {
            	Log.d("abc",  "HttpStatus OK");
            	HttpEntity httpEntity = httpResponse.getEntity();
            	ByteArrayOutputStream out = new ByteArrayOutputStream();
            	httpEntity.writeTo(out);
            	out.close();
            	//output = EntityUtils.toString(httpEntity);
            		
            	output = out.toString();
            	System.out.println(output);
            	Log.d("abc", output);
            	//txtv.setText(output);
            }else{
            	Log.d("abc",  "HttpStatus Not OK");
            	String output = null;
            	output = "error";
            	Log.d("abc", output);
            	//txtv.setText(output);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
			}
		});

		thread.start();
	//txtv.setText(output);
	}	
	*/
		GetVideoData gdt = new GetVideoData();
	    gdt.execute(new String[] { url });
	}

	
	private class GetVideoData extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String output = null;
            System.out.println("doinbackground");
           for (String url : urls) {
                output = getOutputFromUrl(url);
           }
            return output;
        }
        
        
        private String getOutputFromUrl(String url) {
            //StringBuffer output = new StringBuffer("");
            String output = null;
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);
                
                HttpResponse httpResponse = httpClient.execute(httpGet);
                StatusLine st = httpResponse.getStatusLine();
                if(st.getStatusCode()== HttpStatus.SC_OK)
               {
                	Log.d("abc", "HttpStatus.SC_OK");
                	HttpEntity httpEntity = httpResponse.getEntity();
                	ByteArrayOutputStream out = new ByteArrayOutputStream();
                	httpEntity.writeTo(out);
                	out.close();
                	//output = EntityUtils.toString(httpEntity);
                	
                	output = out.toString();
                	System.out.println(output);
                	Log.d("abc", output);
                }else{
                	Log.d("abc","HttpStatus Not oK");
                	output = "error";
                	System.out.println(output);
                	Log.d("abc", output);
                	
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }
          /*  try {////
                InputStream stream = getHttpConnection(url);
                BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(stream));
                String s = "";
                while ((s = buffer.readLine()) != null)
                    output.append(s);
                System.out.println(s);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return output.toString();
        }
        
        private InputStream getHttpConnection(String urlString)
                throws IOException {
            InputStream stream = null;
            URL url = new URL(urlString);  
            URLConnection connection = url.openConnection();
 
            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();
 
                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                	System.out.println("Get COnnection response");
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return stream;
        }
 */
        @Override
        protected void onPostExecute(String output) {
        	txtv.setText(output);
        }}
 
	
}
