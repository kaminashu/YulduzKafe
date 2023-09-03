package www.uzmd.yulduzkafe.presentation

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import www.uzmd.yulduzkafe.R
import www.uzmd.yulduzkafe.databinding.ActivityMenuBinding
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem
import www.uzmd.yulduzkafe.presentation.adapter.RecycleAdapter
import java.lang.RuntimeException

class MenuActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModell
    private lateinit var recycleAdapter: RecycleAdapter
    var list = ArrayList<TaomlarItem>()
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModell::class.java]

        viewModel.getTaomList().observe(this) {
            recycleAdapter = RecycleAdapter(it){taomlarItem, i ->
                val intent= Intent(this@MenuActivity,TayyorlashActivity::class.java)
                intent.putExtra("nomi",taomlarItem.taomNomi)
                intent.putExtra("tayyorlanshi",taomlarItem.tayyorlanshi)
                intent.putExtra("mahsulot",taomlarItem.mahuslotlar)
                startActivity(intent)
            }
            binding.recView.adapter = recycleAdapter
        }
    }
}