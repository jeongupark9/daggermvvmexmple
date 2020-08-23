package com.example.daggermvvmbase.db.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SplashModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var version : String?,
    var weather : String?

)