package www.uzmd.yulduzkafe.domain.usecases

import www.uzmd.yulduzkafe.domain.repozitories.TaomListREpozitory
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

class AddTaomItemUseCase(val tamListREpozitory: TaomListREpozitory) {

    fun addTaom(a: TaomlarItem) {
        tamListREpozitory.addTaom(a)
    }
}