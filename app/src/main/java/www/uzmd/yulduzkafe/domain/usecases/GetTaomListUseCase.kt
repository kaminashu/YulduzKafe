package www.uzmd.yulduzkafe.domain.usecases

import androidx.lifecycle.LiveData
import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

class GetTaomListUseCase(private val taomListREpozitory: TaomListREpozitory){
    fun getTaomList():LiveData<List<TaomlarItem>>{
       return taomListREpozitory.getTaomList()
    }
}