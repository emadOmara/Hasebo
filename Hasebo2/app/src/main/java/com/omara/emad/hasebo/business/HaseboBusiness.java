package com.omara.emad.hasebo.business;

import android.content.Context;

import com.omara.emad.hasebo.dao.DataBaseHelper;
import com.omara.emad.hasebo.dao.HaseboDao;
import com.omara.emad.hasebo.model.Worship;

/**
 * Created by Emad on 8/15/2016.
 */
public class HaseboBusiness {

    public  static HaseboBusiness instance;
    private HaseboDao haseboDao;

    private HaseboBusiness(Context context){
       haseboDao=HaseboDao.getInstance(context);
    }
    public static HaseboBusiness getInstance(Context context){
        if(instance!=null){
            return instance;
        }
        synchronized (new Object()) {
            instance = new HaseboBusiness(context);
        }
        return instance;
    }
    public int save(Worship worship){
      return haseboDao.save(worship);
    }

    public Worship getWorship(String date){
        return haseboDao.getWorship(date);
    }

}
