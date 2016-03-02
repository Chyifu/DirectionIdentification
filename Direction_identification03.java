package com.NTUT_IEM_CER_Lab.direction_identification;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class Direction_identification03 extends ActionBarActivity implements OnTouchListener{
	private Button button;
	private String Name;
	private String Age;
	private String Gender;
	private String NowTime;
	private TextView tvShowMessage = null;
	private LinearLayout DILayout = null;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.fragment_dir_iden_03);
		
		Bundle bundle03=this.getIntent().getExtras();
		Name=bundle03.getString("Name");
		Age=bundle03.getString("Age");
		Gender=bundle03.getString("Gender");
		NowTime=bundle03.getString("NowTime");
		
        DILayout = (LinearLayout)findViewById(R.id.layout);
        tvShowMessage = (TextView)findViewById(R.id.textView1);  
        DILayout.setOnTouchListener(this);

/**create new file test**/		
/*		try{
			FileReader fr=new FileReader("/sdcard1/string.txt");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null){
				temp=br.readLine();
			}
			br.close();
		   	}catch(IOException e){
		        e.printStackTrace();
		     }

		   try{
		        FileWriter fw = new FileWriter("/sdcard1/string.txt", false);
		        BufferedWriter bw = new BufferedWriter(fw); //將BufferedWeiter與FileWrite物件做連結
		        
		   }catch(IOException e){
		       e.printStackTrace();
		    }
*/		
/**get touch&leave screen location**/
		   


	}
	   public boolean onTouch(View v, MotionEvent event) {
		  	int iEventType = event.getAction();
		   	float x = event.getX();
		   	float y = event.getY();
		   	String Filename="";
		   	String Coordinate="";
		   	Filename=NowTime+"_"+Name+"_"+Age+"_"+Gender+".txt";
		   	try{
			FileReader fr=new FileReader("/storage/emulated/0/Download/"+Filename);
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null){
				Coordinate+=temp;
				temp=br.readLine();
			}
			br.close();
		   	}catch(IOException e){
		        e.printStackTrace();
		     }
		    ///*
		    try{
		    	//tvShowMessage.append("\nREAD=="+Coordinate);
		        FileWriter fw = new FileWriter("/storage/emulated/0/Download/"+Filename, false);
		        BufferedWriter bw = new BufferedWriter(fw); //將BufferedWeiter與FileWrite物件做連結
		        //*/
		       	switch(iEventType){
		       	case MotionEvent.ACTION_DOWN:
		       	//	tvShowMessage.append("Down:");
		           	x = event.getX();
		           	y = event.getY();
		        //   	tvShowMessage.append("X: " + x + ", Y: " + y);
		           	Coordinate=Coordinate.concat(x+","+y);
		            bw.write(Coordinate);
		            bw.close();
		       		return true;
		       		
		      	case MotionEvent.ACTION_MOVE:
		       	//	tvShowMessage.append("MOVE:");
		           	x = event.getX();
		           	y = event.getY();
		       //    	tvShowMessage.append("X: " + x + ", Y: " + y);
		            bw.write(Coordinate);
		            bw.close();
		           	return true;
		       		
		       	case MotionEvent.ACTION_UP:
		       	//	tvShowMessage.append("Up");
		           	x = event.getX();
		           	y = event.getY();
		       //    	tvShowMessage.append(":X: " + x + ", Y: " + y);
		           	Coordinate=Coordinate.concat(","+x+","+y+";");
		            bw.write(Coordinate);
		            bw.close();
		           	return true;
		       	}
		        bw.close();
		    }catch(IOException e){
		       e.printStackTrace();
		    }

			return false;
	   }
	

	   @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.direction_identification, menu);
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

	    /**
	     * A placeholder fragment containing a simple view.
	     */
	    public static class PlaceholderFragment extends Fragment {

	        public PlaceholderFragment() {
	        }

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.fragment_dir_iden_03, container, false);
	            return rootView;
	        }
	    }
 
}