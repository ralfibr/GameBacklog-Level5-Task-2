package com.example.gamebacklogLevel5.ui.ui
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklogLevel5.R
import com.example.gamebacklogLevel5.model.Game
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import org.threeten.bp.LocalDate

const val EXTRA_GAME = "EXTRA_GAME"

/**
 * @author Raeef Ibrahim
 * 500755393
 */

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        fab.setOnClickListener { _ ->
            onSaveClick()
        }
    }


    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank()&& etPlatform.text.toString().isNotBlank()&& etYear.text.toString().isNotBlank()&& etMonth.text.toString().isNotBlank()&& etDay.text.toString().isNotBlank()) {
            val game = Game(etTitle.text.toString(), etPlatform.text.toString(), LocalDate.of(etYear.text.toString().toInt(), etMonth.text.toString().toInt(), etDay.text.toString().toInt()))
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            Toast.makeText(this,"The game is added"
                , Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this,"The field cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
}