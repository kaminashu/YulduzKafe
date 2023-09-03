package www.uzmd.yulduzkafe.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.uzmd.yulduzkafe.R
import www.uzmd.yulduzkafe.databinding.ActivityTaomQoshishBinding
import www.uzmd.yulduzkafe.databinding.ActivityTayyorlashBinding

class TayyorlashActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTayyorlashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTayyorlashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intant= Intent()
        var name=intent.extras?.getString("nomi")
        var tayyorlash=intent.extras?.getString("tayyorlanshi")
        var mahsulot=intent.extras?.getString("mahsulot")
        binding.apply {
            taomNomiTxt.setText(name)
            tayyorlanshiText.setText(tayyorlash)
            kerakliMahsulotTxt.setText(mahsulot)
        }
    }
}