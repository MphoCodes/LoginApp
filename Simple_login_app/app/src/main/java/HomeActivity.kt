// HomeActivity.kt

package com.example.simple_login_app

import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
class HomeActivity : AppCompatActivity() {

    private lateinit var backgroundSwitch: Switch
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var welcometextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        welcometextView= findViewById(R.id.homeTv)
        backgroundSwitch = findViewById(R.id.backgroundSwitch)
        constraintLayout = findViewById(R.id.con_layout)

        backgroundSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch is ON, set background to black
                constraintLayout.setBackgroundColor(resources.getColor(android.R.color.black))
                welcometextView.setTextColor(resources.getColor(android.R.color.white))
            } else {
                // Switch is OFF, set background to white
                constraintLayout.setBackgroundColor(resources.getColor(android.R.color.white))
                welcometextView.setTextColor(resources.getColor(android.R.color.black))
            }
        }
    }
}