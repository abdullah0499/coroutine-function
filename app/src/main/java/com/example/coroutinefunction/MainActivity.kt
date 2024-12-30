package com.example.coroutinefunction

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.coroutinefunction.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.statusTextView.text = "Status : Ready to download..."

        binding.downloadButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                  val result = downloadDataFromNetwork()

                    binding.statusTextView.text = result
                }catch (e: Exception){
                    binding.statusTextView.text = "Status:Error occurred"
                    Toast.makeText(this@MainActivity, "Download failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    suspend fun downloadDataFromNetwork():String{
        return withContext(Dispatchers.IO){

            Thread.sleep(2000)
            "Download Data"
        }
    }
}