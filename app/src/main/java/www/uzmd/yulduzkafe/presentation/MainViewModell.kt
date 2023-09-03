package www.uzmd.yulduzkafe.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import www.uzmd.yulduzkafe.data.TaomListImp
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem
import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import www.uzmd.yulduzkafe.domain.usecases.AddTaomItemUseCase
import www.uzmd.yulduzkafe.domain.usecases.DeletTaomUseCase
import www.uzmd.yulduzkafe.domain.usecases.EditTaomUseCase
import www.uzmd.yulduzkafe.domain.usecases.GetByIdUseCase
import www.uzmd.yulduzkafe.domain.usecases.GetTaomListUseCase
import java.lang.RuntimeException

class MainViewModell : ViewModel() {
    var list = ArrayList<TaomlarItem>()
    val liveData = MutableLiveData<List<TaomlarItem>>()

    private val taomListREpozitoryIml = TaomListImp
    val addTaomItemUseCase = AddTaomItemUseCase(taomListREpozitoryIml)
    val deletTaomUseCase = DeletTaomUseCase(taomListREpozitoryIml)
    val editTaomUseCase = EditTaomUseCase(taomListREpozitoryIml)
    val getByIdUseCase = GetByIdUseCase(taomListREpozitoryIml)
    val getTaomUseCase = GetTaomListUseCase(taomListREpozitoryIml)


    fun getTaomList(): LiveData<List<TaomlarItem>> {
        val taomList = getTaomUseCase.getTaomList()
        return taomList
    }

    fun deletTaomItem(taomlarItem: TaomlarItem) {
        deletTaomUseCase.deletTaom(taomlarItem)
        getTaomList()
    }

    fun addTaom(taomlarItem: TaomlarItem) {
        addTaomItemUseCase.addTaom(taomlarItem)
        Log.d(TAG, "addTaom: ${taomlarItem.taomNomi}")
    }
}