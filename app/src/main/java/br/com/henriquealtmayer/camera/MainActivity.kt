package br.com.henriquealtmayer.camera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.henriquealtmayer.camera.camera2.internetsample.InternetSampleActivity
import br.com.henriquealtmayer.camera.camera2.lifecycleaware.Camera2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        initializeButtonOnClick(btn_camera_2_internet_sample, InternetSampleActivity::class.java)

        initializeButtonOnClick(btn_camera_2_lifecycle_aware, Camera2Activity::class.java)
    }

    private fun <T> initializeButtonOnClick(
        button: Button,
        activityClass: Class<T>
    ) {
        button.setOnClickListener {
            startActivity(Intent(this, activityClass))
        }
    }

}