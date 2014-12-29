package com.example.attendanceoff;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView classes;
	Button addclass;
	String[] uname = new String[20];
	public DatabaseManager dbase;
	String Table_Name = "classes";
	TextView title;
	final ArrayList<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbase=new DatabaseManager(this);
		classes =(ListView)findViewById(R.id.classlist);
		title = (TextView)this.findViewById(R.id.textView1);
		// new GetAllclassesTask().execute(new ApiConnector());
		Cursor cursor3=dbase.select("SELECT * FROM" + " " + Table_Name);
		{
			if(cursor3.getCount()==1)
			dummy();	
		}
		 Cursor cursor2=dbase.select("SELECT * FROM" + " " + Table_Name);
        int i=0;
        try {
			if(cursor2.moveToFirst()){
     
				do
				{
				uname[i] = cursor2.getString(cursor2.getColumnIndex("class"));
				list.add(uname[i]);
				i++;
				}while (cursor2.moveToNext() && i<=cursor2.getCount());
			  	 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
       ArrayAdapter<String> arrayadap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
       classes.setAdapter(arrayadap);
       classes.setOnItemClickListener(new OnItemClickListener() {

   		@Override
   		public void onItemClick(AdapterView<?> arg0, View view, int position,
   				long arg3) {
   			String selectedclass=classes.getItemAtPosition(position).toString();
               
   			Toast.makeText(getApplicationContext(), selectedclass,   Toast.LENGTH_SHORT).show();
   			Intent loginjump = new Intent(MainActivity.this, MarkAttendance.class);
   			loginjump.putExtra("classname", selectedclass);
   			startActivity(loginjump);
   			
   		}
       	   
       	   
   	});
       
      
	}
public void dummy()
{
	ContentValues cv = new ContentValues();
	cv.put("class","1csa");
	dbase.insert(Table_Name, cv);
	ContentValues cv1 = new ContentValues();
	cv1.put("class","1csb");
	dbase.insert(Table_Name, cv1);
	ContentValues cv2 = new ContentValues();
	cv2.put("class","3csa");
	dbase.insert(Table_Name, cv2);
	ContentValues cv3 = new ContentValues();
	cv3.put("class","3csb");
	dbase.insert(Table_Name, cv3);
	ContentValues cv4 = new ContentValues();
	cv4.put("class","5csa");
	dbase.insert(Table_Name, cv4);
	ContentValues cv5 = new ContentValues();
	cv5.put("class","5csb");
	dbase.insert(Table_Name, cv5);
	ContentValues cv6 = new ContentValues();
	cv6.put("class","7csa");
	dbase.insert(Table_Name, cv6);
	/*ContentValues cv7 = new ContentValues();
	cv7.put("class","7csb");
	dbase.insert(Table_Name, cv7);*/
}
}

/*	public void setTextToTextView(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		
		String s = "";
		for(int i=0; i<jsonArray.length();i++)
		{
			JSONObject json = null;
			try{
				json = jsonArray.getJSONObject(i);
				s = s + "Name: "+json.getString("Name") + "\nClass: "+json.getString("Section");
			} catch (JSONException e)
			{
				e.printStackTrace();
			}
		}
		this.title.setText(s);
	}
	
	
	public class GetAllclassesTask extends AsyncTask<ApiConnector,Long,JSONArray>
	{

		@Override
		protected JSONArray doInBackground(ApiConnector... params) {
			// TODO Auto-generated method stub
			return params[0].getclasses();
		}
		@Override
		protected void onPostExecute(JSONArray jsonArray) {
			// TODO Auto-generated method stub
			super.onPostExecute(jsonArray);
			setTextToTextView(jsonArray);
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case R.id.ViewAtt:
		{
			Intent intent = new Intent(MainActivity.this,SelectOrder.class);
			intent.putExtra("fromclass", "admin");
			intent.putExtra("requirement", "ViewAtt");
			startActivity(intent);
			
			break;
		}
		}
		return false; 
	}
}
*/
