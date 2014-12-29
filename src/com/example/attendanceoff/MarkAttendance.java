package com.example.attendanceoff;

import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MarkAttendance extends Activity{
	ListView studentlist;
	Button commit;
	ListView ls;
	String Table_Name = "students";
	String[] uname = new String[20];
	public DatabaseManager dbase;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.students_list);
		String tb_name="students";
		studentlist=(ListView)findViewById(R.id.studentlist);
		commit=(Button)findViewById(R.id.commitbtn);
		dbase=new DatabaseManager(this);
		List<StringBuffer> list=dbase.showAll(tb_name);
		ArrayAdapter<StringBuffer> adapter=new ArrayAdapter<StringBuffer>(this,android.R.layout.simple_list_item_multiple_choice, list);
		ls.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		ls.setAdapter(adapter);
		Cursor cursor2=dbase.select("SELECT * FROM" + " " + Table_Name);
        int i=0;
        try {
			if(cursor2.moveToFirst()){
     
				do
				{
				uname[i] = cursor2.getString(cursor2.getColumnIndex("class"));
				//list.add(uname[i]);
				i++;
				}while (cursor2.moveToNext() && i<=cursor2.getCount());
			  	 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OnClickListener comm = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				
			}
		};
		commit.setOnClickListener(comm);
	}
}


