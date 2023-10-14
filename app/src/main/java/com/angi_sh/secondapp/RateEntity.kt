package com.angi_sh.secondapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "RateEntities")
data class RateEntity (
    @PrimaryKey var id: String,
    @ColumnInfo(name = "rate") var rate: Double
        )