package com.metro.itunesdemo.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.metro.itunesdemo.data.remote.model.Result;

import java.util.List;

@Dao
public interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> itemList);

    @Query("SELECT * FROM result")
    List<Result> loadAll();

    @Query("SELECT * FROM result WHERE trackId=:id")
    Result getTrackById(int id);

    @Query("DELETE FROM result")
    void delete();
}
