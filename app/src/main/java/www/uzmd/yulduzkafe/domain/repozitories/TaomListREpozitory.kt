package www.uzmd.yulduzkafe.domain.repozitories

import androidx.lifecycle.LiveData
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

interface TaomListREpozitory {
    fun addTaom(a: TaomlarItem)
    fun deletTaom(d: TaomlarItem)
    fun editTaom(e: TaomlarItem)
    fun getByTaomID(i:Int): TaomlarItem
    fun getTaomList():LiveData<List<TaomlarItem>>
}