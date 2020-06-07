package com.example.gamebacklogLevel5.ui.ui
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.gamebacklogLevel5.database.GameRepository
import com.example.gamebacklogLevel5.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Raeef Ibrahim
 * 500755393
 */
class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepository = GameRepository(application.applicationContext)

    val games: LiveData<List<Game>> = gameRepository.getAllGames()

    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }

    fun deleteAllGames() {
        ioScope.launch {
            gameRepository.deleteAllGames()
        }
    }
}