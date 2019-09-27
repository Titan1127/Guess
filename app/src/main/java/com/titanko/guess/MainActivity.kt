package com.titanko.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    public val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","secret:" + secretNumber.secret)
    }

    fun check(view:View)
    {
        val n = number.text.toString().toInt()
        println("number:  $n")
        Log.d("MainActivity","number:"+n)

        getGuessResult(n)

    }

    private fun getGuessResult(n: Int) {
        val diff = secretNumber.validate(n)
        Log.d("MainActivity","validate:"+diff)
        var message = "猜對了"
        if (diff < 0){
            message = "大一點"
        }
        else if (diff > 0){
            message = "小一點"
        }

//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        AlertDialog.Builder(this)
            .setTitle("系統訊息")
            .setMessage(message)
            .setPositiveButton("OK",null)
            .show()
    }
}
