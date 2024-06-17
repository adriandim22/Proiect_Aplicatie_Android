package com.cst.proiectaplicatieandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cst.proiectaplicatieandroid.utils.extensions.logErrorMessage

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onDestroy() {
        super.onDestroy()

        "onDestroy2".logErrorMessage()
    }
}