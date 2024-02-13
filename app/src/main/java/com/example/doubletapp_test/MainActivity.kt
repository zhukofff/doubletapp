package com.example.doubletapp_test

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import android.widget.Button
import android.util.Log
import com.example.doubletapp_test.R

class MainActivity : AppCompatActivity() {

    private lateinit var changeConfigurationCount: TextView
    private lateinit var switchActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(States.ACTIVITY_LIFECYCLE.name, "First activity has been created!")

        changeConfigurationCount = findViewById(R.id.count)
        switchActivity = findViewById(R.id.transition_to_second)

        // объявить интенты для передачи информации в бандл
        switchActivity.setOnClickListener {
            val switch_to_square_activity = Intent(this, SquareActivity::class.java).apply {
                putExtra(States.CHANGE_CONFIG.name, changeConfigurationCount.text.toString())
            }
            startActivity(switch_to_square_activity)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(States.CHANGE_CONFIG.name, changeConfigurationCount.text.toString().toInt())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.run {
            changeConfigurationCount.text = (getInt(States.CHANGE_CONFIG.name) + 1).toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "First activity has been started!")
    }

    override fun onResume() {
        super.onResume()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "First activity has been resumed!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "First activity has been stopped!")
    }

    override fun onPause() {
        super.onPause()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "First activity has been paused!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(States.ACTIVITY_LIFECYCLE.name, "First activity has been destroyed!")
    }

}