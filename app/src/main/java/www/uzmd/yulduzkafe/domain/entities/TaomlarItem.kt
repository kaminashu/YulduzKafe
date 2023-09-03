package www.uzmd.yulduzkafe.domain.entities

data class TaomlarItem(
    var taomNomi: String,
    var mahuslotlar: String,
    var tayyorlanshi: String,
    var id: Int = UNIQUE_EMPTY,

    ) {
    companion object{
        const val UNIQUE_EMPTY=-1
    }
}