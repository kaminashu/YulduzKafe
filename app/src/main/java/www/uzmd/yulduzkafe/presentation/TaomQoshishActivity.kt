package www.uzmd.yulduzkafe.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import www.uzmd.yulduzkafe.R
import www.uzmd.yulduzkafe.databinding.ActivityTaomQoshishBinding
import www.uzmd.yulduzkafe.databinding.DialogAddBinding
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem
import www.uzmd.yulduzkafe.domain.usecases.AddTaomItemUseCase

private lateinit var viewModel: MainViewModell

class TaomQoshishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaomQoshishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaomQoshishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModell::class.java]
        val dialogAddBinding = DialogAddBinding.inflate(LayoutInflater.from(this), null, false)
        val dialog = AlertDialog.Builder(this).create()
        dialog.setView(dialogAddBinding.root)
        binding.saqlashBtn.setOnClickListener {
            val nomi = binding.taomNomiEdt.text.toString()
            val retsept = binding.kerakliMahsulot.text.toString()
            val tayyorlanshi = binding.tayyorlanshiEdt.text.toString()
            viewModel.addTaom(TaomlarItem(nomi, retsept, tayyorlanshi))
            val window: Window = dialog.window!!
            val wlp: WindowManager.LayoutParams = window.attributes
            wlp.gravity = Gravity.TOP
            dialog.show()
        }
        dialogAddBinding.apply {
            menuImg.setOnClickListener {
                val intent = Intent(this@TaomQoshishActivity, MenuActivity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
            closeImg.setOnClickListener {
                binding.taomNomiEdt.setText("")
                binding.kerakliMahsulot.setText("")
                binding.tayyorlanshiEdt.setText("")
                dialog.dismiss()
            }
        }
    }
}