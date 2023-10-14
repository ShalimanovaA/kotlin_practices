package com.angi_sh.secondapp

import androidx.room.Insert
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: RateEntity)
    @Query("SELECT * FROM RateEntities")
    fun getAllItems(): Flow<List<RateEntity>>
}