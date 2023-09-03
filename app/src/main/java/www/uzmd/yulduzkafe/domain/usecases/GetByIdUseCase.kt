package www.uzmd.yulduzkafe.domain.usecases

import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

class GetByIdUseCase(val taomListREpozitory: TaomListREpozitory) {
    fun getByTaomID(i:Int): TaomlarItem {
      return  taomListREpozitory.getByTaomID(i)
    }
}