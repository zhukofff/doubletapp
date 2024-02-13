package com.example.doubletapp_test

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doubletapp_test.R
import org.apache.commons.math3.util.ArithmeticUtils.pow

class SquareActivity : AppCompatActivity() {

    private lateinit var changeConfigurationCount: TextView
    private lateinit var switchActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        Log.i(States.ACTIVITY_LIFECYCLE.name, "Second activity has been created!")

        val intent = getIntent()

        changeConfigurationCount = findViewById(R.id.count)
        switchActivity = findViewById(R.id.transition_to_first)

        switchActivity.setOnClickListener {
            finish()
        }

        changeConfigurationCount.text = pow(intent.getStringExtra(States.CHANGE_CONFIG.name)!!.toInt(), 2).toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "Second activity has been started!")
    }

    override fun onResume() {
        super.onResume()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "Second activity has been resumed!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "Second activity has been stopped!")
    }

    override fun onPause() {
        super.onPause()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "Second activity has been paused!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "Second activity has been destroyed!")
    }
}