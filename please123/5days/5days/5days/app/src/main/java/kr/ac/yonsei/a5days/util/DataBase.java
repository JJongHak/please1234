package kr.ac.yonsei.a5days.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.yonsei.a5days.item.Goal;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Goal(name TEXT,date  TEXT, level INTEGER, point INTEGER, PRIMARY KEY(name,date));");
        db.execSQL("CREATE TABLE Point(_ID INTEGER PRIMARY KEY AUTOINCREMENT,date TEXT, point INTEGER)");
    }
    public int selectPoint(String name){// return yester day point
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT point FROM Goal where name =='"+name+"'",null);
        db.close();
        if(cursor.getCount()!=0) return cursor.getInt(3);
        else return -10;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public List<String> select(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = new Date();
        String day = sdf.format(time);
        SQLiteDatabase db = getReadableDatabase();
        List<String> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from Goal where date == '" +day +"'",null);
        while(cursor.moveToNext()){
            String str = cursor.getString(0)+"@"+cursor.getString(1)+
                    "@"+ cursor.getInt(2)+"@"+cursor.getInt(3);
            list.add(str);
        }
        return list;
    }
    public void exequte(String _query) {
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }
}
