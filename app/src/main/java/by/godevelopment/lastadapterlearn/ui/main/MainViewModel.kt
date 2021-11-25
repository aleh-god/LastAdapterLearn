package by.godevelopment.lastadapterlearn.ui.main

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import androidx.lifecycle.ViewModel
import by.godevelopment.lastadapterlearn.data.DataList
import by.godevelopment.lastadapterlearn.model.Header
import by.godevelopment.lastadapterlearn.model.Item
import by.godevelopment.lastadapterlearn.ui.main.extentions.onValueChanged
import com.github.nitrico.lastadapter.StableId

class MainViewModel : ViewModel() {

    val orderSum = ObservableFloat(0.0f)
    val data = ObservableArrayList<StableId>()

    init {
        val itemsToAdd = DataList.items.mapNotNull { item ->
            when (item) {
                is Header -> HeaderViewModel(header = item)
                is Item -> ItemViewModel(
                    item = item,
                    onAddItemCallback = { price -> orderSum.set(orderSum.get() + price) }
                )
                else -> null
            }
        }

        data.addAll(itemsToAdd)


//        DataList.items.filterIsInstance<Item>().map { item ->
//            ItemViewModel(
//                item = item,
//                onAddItemCallback = { price -> orderSum.set(orderSum.get() + price) }
//            )
//        }
    }
}

class ItemViewModel(
    override val stableId: Long = Long.MAX_VALUE,
    val item: Item,
    private val onAddItemCallback: (Float) -> Unit
) : StableId {
    val totalPrice = ObservableFloat()
    val quantityString = ObservableField("1")

    init {
        quantityString.onValueChanged { qtyString ->
            val qty = qtyString?.toIntOrNull() ?: 0
            totalPrice.set(item.price * qty)
        }
    }

    fun onAddClicked() {
        onAddItemCallback.invoke(totalPrice.get())
    }
}

class HeaderViewModel(override val stableId: Long = 0L, val header: Header) : StableId