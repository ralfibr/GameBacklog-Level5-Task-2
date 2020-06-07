package com.example.gamebacklogLevel5.model
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDate

/**
 * @author Raeef Ibrahim
 * 500755393
 */
@Parcelize
@Entity(tableName = "gameTable")
data class Game (
    @ColumnInfo(name = "gameTitle")
    var gameTitle: String,
    
    @ColumnInfo(name = "gamePlatform")
    var gamePlatform: String,
    
    @ColumnInfo(name = "gameReleaseDate")
    var gameReleaseDate: LocalDate,
    
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable