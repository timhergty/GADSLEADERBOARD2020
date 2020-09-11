package com.codehergty.gadsleaderboard2020.activity;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.codehergty.gadsleaderboard2020.R

/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            finish()
        }, 3000)


    }
}