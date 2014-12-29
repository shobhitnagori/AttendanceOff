package com.example.attendanceoff;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {
	
	public QueryBuilder query1 = new QueryBuilder();
	private static String dbname="Attendence";
	private static int version=1;
/*	private String createtable_1csa="CREATE TABLE `1csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_1csb="CREATE TABLE `1csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2csa="CREATE TABLE `2csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2csb="CREATE TABLE `2csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3csa="CREATE TABLE `3csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3csb="CREATE TABLE `3csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4csa="CREATE TABLE `4csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4csb="CREATE TABLE `4csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5csa="CREATE TABLE `5csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5csb="CREATE TABLE `5csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6csa="CREATE TABLE `6csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6csb="CREATE TABLE `6csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7csa="CREATE TABLE `7csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7csb="CREATE TABLE `7csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8csa="CREATE TABLE `8csa` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8csb="CREATE TABLE `8csb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	
	//ec branch
	private String createtable_1eca="CREATE TABLE `1eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_1ecb="CREATE TABLE `1ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2eca="CREATE TABLE `2eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2ecb="CREATE TABLE `2ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3eca="CREATE TABLE `3eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3ecb="CREATE TABLE `3ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4eca="CREATE TABLE `4eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4ecb="CREATE TABLE `4ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5eca="CREATE TABLE `5eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5ecb="CREATE TABLE `5ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6eca="CREATE TABLE `6eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6ecb="CREATE TABLE `6ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7eca="CREATE TABLE `7eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7ecb="CREATE TABLE `7ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8eca="CREATE TABLE `8eca` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8ecb="CREATE TABLE `8ecb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	
	//me branch
	private String createtable_1mea="CREATE TABLE `1mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_1meb="CREATE TABLE `1meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2mea="CREATE TABLE `2mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2meb="CREATE TABLE `2meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3mea="CREATE TABLE `3mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3meb="CREATE TABLE `3meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4mea="CREATE TABLE `4mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4meb="CREATE TABLE `4meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5mea="CREATE TABLE `5mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5meb="CREATE TABLE `5meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6mea="CREATE TABLE `6mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6meb="CREATE TABLE `6meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7mea="CREATE TABLE `7mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7meb="CREATE TABLE `7meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8mea="CREATE TABLE `8mea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8meb="CREATE TABLE `8meb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	
	//civil branch
	private String createtable_1cea="CREATE TABLE `1cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_1ceb="CREATE TABLE `1ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2cea="CREATE TABLE `2cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2ceb="CREATE TABLE `2ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3cea="CREATE TABLE `3cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3ceb="CREATE TABLE `3ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4cea="CREATE TABLE `4cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4ceb="CREATE TABLE `4ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5cea="CREATE TABLE `5cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5ceb="CREATE TABLE `5ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6cea="CREATE TABLE `6cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6ceb="CREATE TABLE `6ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7cea="CREATE TABLE `7cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7ceb="CREATE TABLE `7ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8cea="CREATE TABLE `8cea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8ceb="CREATE TABLE `8ceb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	
	//electrical
	private String createtable_1eea="CREATE TABLE `1eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_1eeb="CREATE TABLE `1eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2eea="CREATE TABLE `2eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_2eeb="CREATE TABLE `2eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3eea="CREATE TABLE `3eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_3eeb="CREATE TABLE `3eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4eea="CREATE TABLE `4eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_4eeb="CREATE TABLE `4eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5eea="CREATE TABLE `5eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_5eeb="CREATE TABLE `5eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6eea="CREATE TABLE `6eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_6eeb="CREATE TABLE `6eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7eea="CREATE TABLE `7eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_7eeb="CREATE TABLE `7eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8eea="CREATE TABLE `8eea` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	private String createtable_8eeb="CREATE TABLE `8eeb` (`roll_no`	INTEGER PRIMARY KEY ,`student_name`	TEXT)";
	*/
	
	private String createtable_classes="CREATE TABLE `classes` (`class`	TEXT)";
	private String createtable_teachers1="CREATE TABLE `createtable_teachers1` (`teacher_id`	INTEGER NOT NULL,`teacher_name`	TEXT NOT NULL,`phone_no`	TEXT,PRIMARY KEY(teacher_id))";
	private String createtable_students="CREATE TABLE `students` (`roll_no`	INTEGER NOT NULL,`student_name`	TEXT NOT NULL,`class`	TEXT NOT NULL,PRIMARY KEY(roll_no))";
	private String createtable_teachers2="CREATE TABLE `createtable_teachers2` (`teacher_id`	INTEGER NOT NULL,`subject`	TEXT,`class`	TEXT)";
	SQLiteDatabase db;
	
	public DatabaseManager(Context context)
	{
		super(context,dbname,null,version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		db.execSQL(createtable_classes);
		db.execSQL(createtable_students);
		db.execSQL(createtable_teachers1);
		db.execSQL(createtable_teachers2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	/*public void dummy()
	{
		db=getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(column1_userlogintable, "admin");
		cv.put(column2_userlogintable, "1234");
		db.insert(table_name1, null,cv);
		db.close();
	}*/
	
	public void insert(String table, ContentValues values) throws SQLException {
		db=getWritableDatabase();
        db.insert(table, null, values);
        db.close();
    }
	public Cursor select(String query) throws SQLException {
		db=getReadableDatabase();
        return db.rawQuery(query, null);
    }
	 public void update(String table, ContentValues values, String where) {
		 db=getWritableDatabase();
	        db.update(table, values, where, null);
	 db.close();
	    }
	 public int deleteRecord(String table_name,String where,ArrayList<String> uname)
		{
			db=getWritableDatabase();
			//String value[]=uname;
			Iterator<String> itr = uname.iterator();
			int j=0;
	        while(itr.hasNext())
	        {
	            
	        String[] str={itr.next()};
			int i=db.delete(table_name, where, str);
			j=j+i;
	        }
			db.close();
			
			return j;
		}
	 public ArrayList<StringBuffer> showAll(String tb_name)
		{

			ArrayList<StringBuffer> list=new ArrayList<StringBuffer>();
			db=getWritableDatabase();
			Cursor cursor=db.rawQuery("select * from"+tb_name+" order by name", null);
			if(cursor!=null)
			{
				while(cursor.moveToNext())
				{
					String uname=cursor.getString(1);
					/*String pass=cursor.getString(2);
					String contact=cursor.getString(3);*/
					
					StringBuffer sb=new StringBuffer();
					sb.append(uname);
					/*sb.append(uname).append(",").append(pass).append(",").append(contact);*/
					list.add(sb);
				}
			}
			db.close();
			return list;
		}
	 
	 public String buildattendancetable(String name)
		{
			String def= new String();
			String query = new String();
			query = ""+"\"CREATE TABLE " + "`"+name+"` (";
			def = "`Date` TEXT, `profname` TEXT,";
			query = ""+query+def;
			for(int i=78;i<=156;i++)
			{
			query = ""+query+"`roll"+i+"`"+"\t"+"TEXT";
			}
			query = query+")";
			return query;
		}
}