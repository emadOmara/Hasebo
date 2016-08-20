package com.omara.emad.hasebo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.omara.emad.hasebo.model.Worship;

import java.io.IOException;

/**
 * Created by Emad on 8/15/2016.
 */
public class HaseboDao {

    private static HaseboDao instance;
    private DataBaseHelper helper;

    private HaseboDao(Context context) {
        helper = DataBaseHelper.getInstance(context);
    }

    public static HaseboDao getInstance(Context context) {
        if (instance != null) {
            return instance;
        }
        synchronized (new Object()) {
            instance = new HaseboDao(context);
        }
        return instance;
    }

    public Worship getWorship(String date) {
//        Cursor cursor = helper.getWritableDataBase() .query(
//                DataBaseHelper.TABLE_NAME_WORSHIP, new String[]{DataBaseHelper.COL_ID,DataBaseHelper.COL_FAJR}, whereClause, whereArgs, groupBy, having, orderBy);
         try {
             Cursor cursor = helper.getWritableDataBase().rawQuery("select * from " + DataBaseHelper.TABLE_NAME_WORSHIP + " where date= ? ", new String[]{date});
             return extractWorship(cursor);
         }catch (Exception e){
            throw e;
         }
    }


    private int update(Worship worship) {
        ContentValues contentValues=prepareWorShip(worship);
        contentValues.put(DataBaseHelper.COL_ID,worship.getId());
        int numOfRecords=(int) helper.getWritableDataBase().update(DataBaseHelper.TABLE_NAME_WORSHIP,contentValues, DataBaseHelper.COL_ID+" = ? ", new String[] { Integer.toString(worship.getId()) } );
        return  numOfRecords;

    }
    private int add(Worship worship) {

        ContentValues contentValues=prepareWorShip(worship);

        int numOfRecords=(int) helper.getWritableDataBase().insert(DataBaseHelper.TABLE_NAME_WORSHIP, null, contentValues);
        return  numOfRecords;
    }

    private ContentValues prepareWorShip(Worship worship ){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_FAJR, worship.isFajr());
        contentValues.put(DataBaseHelper.COL_ZOHR,worship.isZohr());
        contentValues.put(DataBaseHelper.COL_ASR, worship.isAsr());
        contentValues.put(DataBaseHelper.COL_MAGHREB, worship.isMaghreb());
        contentValues.put(DataBaseHelper.COL_ESHAA, worship.isEshaa());
        contentValues.put(DataBaseHelper.COL_DOHA, worship.isDoha());
        contentValues.put(DataBaseHelper.COL_FAJR_SONAH, worship.getFajrSonah());
        contentValues.put(DataBaseHelper.COL_ZOHR_SONAH, worship.getZohrSonah());
        contentValues.put(DataBaseHelper.COL_ASR_SONAH, worship.getAsr_sonah());
        contentValues.put(DataBaseHelper.COL_MAGHREB_SONAH, worship.getMaghreb_sonah());
        contentValues.put(DataBaseHelper.COL_ESHAA_SONAH, worship.getEshaaSonah());
        contentValues.put(DataBaseHelper.COL_AZKAR_MORNING, worship.isAzkarMoorning());
        contentValues.put(DataBaseHelper.COL_AZKAR_NIGHT, worship.isAzkarNight());
        contentValues.put(DataBaseHelper.COL_QURAN, worship.getQuran());
        contentValues.put(DataBaseHelper.COL_DATE, worship.getDate());
        return  contentValues;
    }
    private Worship extractWorship(Cursor cursor) {
        Worship worship = new Worship();


        if (cursor != null) {
            if(cursor.moveToFirst()) {
                do {

                    worship.setFajr(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_FAJR)) == 1);
                    worship.setZohr(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ZOHR)) == 1);
                    worship.setAsr(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ASR)) == 1);
                    worship.setMaghreb(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_MAGHREB)) == 1);
                    worship.setEshaa(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ESHAA)) == 1);
                    worship.setDoha(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_DOHA)) == 1);

                    worship.setFajrSonah(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_FAJR_SONAH)));
                    worship.setZohrSonah(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ZOHR_SONAH)));
                    worship.setAsr_sonah(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ASR_SONAH)));
                    worship.setMaghreb_sonah(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_MAGHREB_SONAH)));
                    worship.setEshaaSonah(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ESHAA_SONAH)));
                    worship.setId(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_ID)));
                    worship.setAzkarMoorning(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_AZKAR_MORNING)) == 1);
                    worship.setAzkarNight(cursor.getInt(getColIndex(cursor, DataBaseHelper.COL_AZKAR_NIGHT)) == 1);
                    worship.setDate(cursor.getString(getColIndex(cursor, DataBaseHelper.COL_DATE)));


                } while (cursor.moveToNext());
            }
        }
        cursor.close();
            return worship;

    }

    private int getColIndex(Cursor cursor, String name) {
        return cursor.getColumnIndex(name);
    }

    public int save(Worship worship) {
        if(worship.getId()>0){
            return  update(worship);
        }else{
            return add(worship);

        }
    }
}
