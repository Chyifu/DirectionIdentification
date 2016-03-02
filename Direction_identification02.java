package com.NTUT_IEM_CER_Lab.direction_identification;

import com.NTUT_IEM_CER_Lab.direction_identification.Direction_identification.PlaceholderFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.format.Time;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Direction_identification02 extends ActionBarActivity{
	private Button button;
	private String Name;
	private String Age;
	private String Gender;
	private String NowTime;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.fragment_dir_iden_02);

		Bundle bundle02=this.getIntent().getExtras();
		Name=bundle02.getString("Name");
		Age=bundle02.getString("Age");
		Gender=bundle02.getString("Gender");
		NowTime=bundle02.getString("NowTime");
		
		TextView TV1=(TextView)findViewById(R.id.textView2);
		TextView TV2=(TextView)findViewById(R.id.textView4);
		TextView TV3=(TextView)findViewById(R.id.textView6);
		TextView TV4=(TextView)findViewById(R.id.textView8);
		
		TV1.setText(Name);
		TV2.setText(Age);
		TV3.setText(Gender);
		TV4.setText(NowTime);
		
		button=(Button)findViewById(R.id.button1);
	}
	   public void myClickHandler(View view)
	    {
	   					
			Intent intent=new Intent();
			intent.setClass(Direction_identification02.this,Direction_identification03.class);
			
			Bundle bundle=new Bundle();
			bundle.putString("Name", Name);
			bundle.putString("Age",Age);
			bundle.putString("Gender", Gender);
			bundle.putString("NowTime", NowTime);
				
			intent.putExtras(bundle);
			startActivity(intent);
			Direction_identification02.this.finish();
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
	            View rootView = inflater.inflate(R.layout.fragment_dir_iden_02, container, false);
	            return rootView;
	        }
	    }
}