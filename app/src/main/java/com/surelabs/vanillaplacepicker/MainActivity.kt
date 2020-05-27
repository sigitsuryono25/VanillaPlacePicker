package com.surelabs.vanillaplacepicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vanillaplacepicker.presentation.builder.VanillaPlacePicker
import com.vanillaplacepicker.utils.MapType
import com.vanillaplacepicker.utils.PickerLanguage
import com.vanillaplacepicker.utils.PickerType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vanillaPlacePicker.setOnClickListener {
            val placePicker = VanillaPlacePicker.Builder(this@MainActivity)
                .with(PickerType.MAP_WITH_AUTO_COMPLETE)
                .setMapType(MapType.NORMAL)
                .build()

            startActivityForResult(placePicker, 1052)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                1052 -> {
                    val vanillaAddress = VanillaPlacePicker.onActivityResult(data)
                    Toast.makeText(
                        this@MainActivity,
                        vanillaAddress?.formattedAddress,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
