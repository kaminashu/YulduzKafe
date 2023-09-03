package www.uzmd.yulduzkafe.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import www.uzmd.yulduzkafe.R
import www.uzmd.yulduzkafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            taomQoshishBtn.setOnClickListener {
                val intent = Intent(this@MainActivity, TaomQoshishActivity::class.java)
                startActivity(intent)
            }
            menuBtn.setOnClickListener {
                val intent = Intent(this@MainActivity, MenuActivity::class.java)
                startActivity(intent)
            }
        }
    }
}