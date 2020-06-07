package com.example.gamebacklogLevel5.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gamebacklogLevel5.model.DateConverter
import com.example.gamebacklogLevel5.model.Game
/**
 * @author Raeef Ibrahim
 * 500755393
 */
@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class GameRoomDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDAO

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var gameRoomDatabaseInstance: GameRoomDatabase? = null

        fun getDatabase(context: Context): GameRoomDatabase? {
            if(gameRoomDatabaseInstance == null) {
                synchronized(GameRoomDatabase::class.java) {
                    if(gameRoomDatabaseInstance == null) {
                        gameRoomDatabaseInstance = Room.databaseBuilder(context.applicationContext, GameRoomDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return gameRoomDatabaseInstance
        }
    }
}