package com.example.gamebacklogLevel5.model
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklogLevel5.R
import kotlinx.android.synthetic.main.item_game.view.*
import android.content.Context

/**
 * @author Raeef Ibrahim
 * 500755393
 */
class GameAdapter(private val games: List<Game>, private val context: Context) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    /**
     * onCreateViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    /* Returns the size of the list*/
    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * onBindViewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    @SuppressLint("StringFormatInvalid")
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        fun bind(game: Game){
            itemView.tvName.text = game.gameTitle
            itemView.tvPlatform.text = game.gamePlatform
            itemView.tvDate.text = context.getString(R.string.release_date, game.gameReleaseDate.dayOfMonth.toString(), game.gameReleaseDate.month.toString().toLowerCase().capitalize(), game.gameReleaseDate.year.toString())
        
        }
    }
}