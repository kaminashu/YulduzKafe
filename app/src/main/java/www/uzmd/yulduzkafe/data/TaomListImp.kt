package www.uzmd.yulduzkafe.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem
import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import java.lang.RuntimeException

object  TaomListImp:TaomListREpozitory {
    private val listLv= MutableLiveData<List<TaomlarItem>>()
    private val list= mutableListOf<TaomlarItem>()

private var autoincrement=0
    override fun addTaom(a: TaomlarItem) {
       if(a.id==TaomlarItem.UNIQUE_EMPTY){
           a.id= autoincrement
           autoincrement++
       }
        Log.d(TAG, "addTaom: ${list.size}")
        list.add(a)
        listLv.value= list.toList()
    }

    override fun deletTaom(d: TaomlarItem) {
        list.remove(d)
    }

    override fun editTaom(e: TaomlarItem) {
      /*  var hozirgiID= getByTaomID(e.id)
        deletTaom(hozirgiID)
        addTaom(e)*/
        listLv.value= list.toList()
    }

    override fun getByTaomID(i: Int): TaomlarItem {
      return list.find { it.id==i }?: throw RuntimeException("$i bunaqa id li element yoq")
    }

    override fun getTaomList(): LiveData<List<TaomlarItem>> {
        return listLv
    }
}