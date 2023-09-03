package www.uzmd.yulduzkafe.domain.usecases

import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

class DeletTaomUseCase(val taomListREpozitory: TaomListREpozitory) {
    fun deletTaom(d: TaomlarItem){
      taomListREpozitory.deletTaom(d)
    }
}