package com.example.gamebacklogLevel5.database
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamebacklogLevel5.model.Game
/**
 * @author Raeef Ibrahim
 * 500755393
 */
@Dao
interface GameDAO {
    @Query("SELECT * FROM gameTable ORDER BY gameReleaseDate ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGames()
}