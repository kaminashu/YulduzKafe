package www.uzmd.yulduzkafe.domain.usecases

import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

class EditTaomUseCase(val taomListREpozitory: TaomListREpozitory) {
    fun editTaom(e: TaomlarItem){
        taomListREpozitory.editTaom(e)
    }
}