package com.NTUT_IEM_CER_Lab.direction_identification;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.os.Build;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.text.format.Time;

public class Direction_identification extends ActionBarActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_direction_identification);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
             
        button=(Button)findViewById(R.id.button1);
    }

    public void myClickHandler(View view)
    {
   		
		EditText EditTextName=(EditText)findViewById(R.id.editText1);
		Editable StrName;
		StrName=EditTextName.getText();
		String Name=StrName.toString();
		
		
		EditText EditTextAge=(EditText)findViewById(R.id.editText2);
		Editable StrAge;
		StrAge=EditTextAge.getText();
		String Age=StrAge.toString();
		
		String Gender="";
		RadioButton StrGender=(RadioButton)findViewById(R.id.radio0);
		if(StrGender.isChecked()){
			Gender="Male";
		}
		else{
			Gender="Female";
		}
		
		Time T=new Time();
		T.setToNow();
		int NY=T.year;
		int NM=T.month+1;
		int ND=T.monthDay;
		int NH=T.hour;
		int NMin=T.minute;
		
		String NowYear=Integer.toString(NY);
		String NowMonth=Integer.toString(NM);
		String NowDay=Integer.toString(ND);
		String NowHour=Integer.toString(NH);
		String NowMin=Integer.toString(NMin);
		
		String NowTime=NowYear+NowMonth+NowDay+NowHour+NowMin;
		
		Intent intent=new Intent();
		intent.setClass(Direction_identification.this,Direction_identification02.class);
		
		Bundle bundle=new Bundle();
		bundle.putString("Name", Name);
		bundle.putString("Age",Age);
		bundle.putString("Gender", Gender);
		bundle.putString("NowTime", NowTime);
	
/*
		TextView TV1=(TextView)findViewById(R.id.textView1);
		TV1.setText(Name+NowTime);
		
*/
		
		intent.putExtras(bundle);
		startActivity(intent);
		Direction_identification.this.finish();
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
            View rootView = inflater.inflate(R.layout.fragment_direction_identification, container, false);
            return rootView;
        }
    }

}
