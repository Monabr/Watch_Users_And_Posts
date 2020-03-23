package com.example.watchusersandposts.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.watchusersandposts.R

/**
 * Main container for all application fragments since it's single activity application
 */
class MainContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
    }

}
