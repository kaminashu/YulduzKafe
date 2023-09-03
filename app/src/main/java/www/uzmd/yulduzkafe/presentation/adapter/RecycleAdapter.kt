package www.uzmd.yulduzkafe.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import www.uzmd.yulduzkafe.databinding.ItemTaomBinding
import www.uzmd.yulduzkafe.domain.entities.TaomlarItem

class RecycleAdapter(val list: List<TaomlarItem>, val onClick: (TaomlarItem, Int) -> Unit) :
    RecyclerView.Adapter<RecycleAdapter.VH>() {
    inner class VH(val itemTaomBinding: ItemTaomBinding) :
        RecyclerView.ViewHolder(itemTaomBinding.root) {
        fun binding(taomlarItem: TaomlarItem, pazition: Int) {
            itemTaomBinding.taomNameTx.setText(taomlarItem.taomNomi)
            itemTaomBinding.itemLv.setOnClickListener {
                onClick.invoke(taomlarItem, pazition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemTaomBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding(list[position], position)
    }
}