package be.johnkichi.sampleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import be.johnkichi.sampleapp.databinding.SplashActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Observer

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val splashViewModel by viewModels<SplashViewModel>()

    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        splashViewModel.get("demo_key")
            .observe(
                this,
                Observer {
                    Log.d("FGV", "demo_key = $it")
                }
            )

        splashViewModel.put("demo_key", "demo_value")

        binding.buttonFeature.setOnClickListener {
            val clazz = Class.forName("be.johnkichi.sampleapp.hilt.feature.FeatureActivity")
            startActivity(Intent(this, clazz))
        }
    }
}
