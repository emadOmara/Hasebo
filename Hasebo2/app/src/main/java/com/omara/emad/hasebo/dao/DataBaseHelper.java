package com.omara.emad.hasebo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emad on 8/12/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="hasebo.db";
    public static final String TABLE_NAME_WORSHIP="WORSHIP";
    public static final String COL_ID="ID";
    public static final String COL_FAJR="FAJR";
    public static final String COL_ZOHR="ZOHR";
    public static final String COL_ASR="ASR";
    public static final String COL_MAGHREB="MAGHREB";
    public static final String COL_ESHAA="ESHAA";
    public static final String COL_DOHA="DOHA";
    public static final String COL_FAJR_SONAH="FAJR_SONAH";
    public static final String COL_ZOHR_SONAH="ZOHR_SONAH";
    public static final String COL_ASR_SONAH="ASR_SONAH";
    public static final String COL_MAGHREB_SONAH="MAGHREB_SONAH";
    public static final String COL_ESHAA_SONAH="ESHAA_SONAH";
    public static final String COL_AZKAR_MORNING="AZKAR_MORNING";
    public static final String COL_AZKAR_NIGHT="AZKAR_NIGHT";
    public static final String COL_QURAN="QURAN";
    public static final String COL_DATE="DATE";


    public static  DataBaseHelper instane;
    private DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 6);

    }
    public SQLiteDatabase getWritableDataBase(){
        return this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(" CREATE TABLE "+TABLE_NAME_WORSHIP+" (  " +COL_ID+
            " INTEGER PRIMARY KEY  AUTOINCREMENT , " +COL_FAJR+
            " INT    DEFAULT 0, "+COL_ZOHR+" INT    DEFAULT 0, "+COL_ASR+"  INT     DEFAULT 0, "
            +COL_MAGHREB+" INT     DEFAULT 0, "+COL_ESHAA+" INT     DEFAULT 0,"+COL_DOHA+" INT     DEFAULT 0, "+
           COL_FAJR_SONAH+ " INT    DEFAULT 0, "+COL_ZOHR_SONAH +" INT    DEFAULT 0, "+COL_ASR_SONAH+
            "  INT    DEFAULT 0, "+COL_MAGHREB_SONAH+"  INT    DEFAULT 0,"+COL_ESHAA_SONAH +" INT    DEFAULT 0, "+
            COL_AZKAR_MORNING+" INT DEFAULT 0,"+COL_AZKAR_NIGHT+ "  INT DEFAULT 0,"+COL_QURAN+ " INT DEFAULT 0, "+COL_DATE
            +" TEXT );" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_WORSHIP);
        onCreate(db);
    }

    public static DataBaseHelper getInstance(Context context) {
        if(instane!=null){
            return instane;
        }
        synchronized (new Object()){
            instane=new DataBaseHelper(context);
        }
        return  instane;
    }
}
