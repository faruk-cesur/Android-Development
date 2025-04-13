package com.farukcesur.catchkennygame

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.farukcesur.catchkennygame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val kennyList = ArrayList<ImageView>()
    private var score: Int = 0
    private var remainingTime = 5000L
    private var countDownTimer: CountDownTimer? = null
    private var handler = Handler(Looper.getMainLooper())
    var runnable: Runnable = Runnable { }
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences başlat
        sharedPreferences = getSharedPreferences("HighScore", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val highScore = sharedPreferences.getInt("highScore", 0)
        binding.highScoreText.text = "High Score: $highScore"

        setupKennyImageList()
        spawnRandomKenny()
        countDownBeforeGameOver()
    }


    private fun setupKennyImageList() {
        for (i in 0 until binding.gridLayout.childCount) {
            val view = binding.gridLayout.getChildAt(i)
            if (view is ImageView) {
                kennyList.add(view)
                view.visibility = View.INVISIBLE
            }
        }
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(0, kennyList.size)
    }

    private fun spawnRandomKenny() {
        runnable = object : Runnable {
            override fun run() {
                hideAllKennyImages()

                if (kennyList.isNotEmpty()) {
                    kennyList[generateRandomNumber()].visibility = View.VISIBLE
                }

                handler.postDelayed(this, 500)
            }
        }

        handler.post(runnable)
    }

    private fun hideAllKennyImages() {
        for (kenny in kennyList) {
            kenny.visibility = View.INVISIBLE
        }
    }

    private fun countDownBeforeGameOver() {
        countDownTimer?.cancel() // önceki timer'ı iptal et

        countDownTimer = object : CountDownTimer(remainingTime, 100) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                val seconds = millisUntilFinished / 1000.0
                binding.timeText.text = "Time: ${String.format("%.1f", seconds)}"
            }

            override fun onFinish() {
                binding.timeText.text = "Time: 0"
                handler.removeCallbacks(runnable)
                hideAllKennyImages()
                restartGameAlertDialog()
                saveHighScore(score)
            }
        }

        countDownTimer?.start()
    }

    fun restartGameAlertDialog() {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Game Over")
        alert.setMessage("Restart the Game?")

        alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

        alert.setNegativeButton("No") { p0, p1 ->
            editor.putInt("highScore",0).apply() // Reset Highscore!
            finishAffinity()
        }

        alert.show()
    }

    fun increaseScore(view: View) {
        score++
        binding.scoreText.text = "Score: $score"

        remainingTime += 500  // 0.5 saniye ekle
        countDownBeforeGameOver() // countdown'ı yeniden başlat
    }

    fun saveHighScore(score:Int){
        if (score <= sharedPreferences.getInt("highScore",0)){
            return
        }
        editor.putInt("highScore",score).apply()
    }
}