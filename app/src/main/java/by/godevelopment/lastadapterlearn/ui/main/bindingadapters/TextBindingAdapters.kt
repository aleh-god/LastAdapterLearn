package by.godevelopment.lastadapterlearn.ui.main.bindingadapters

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("price")
fun TextView.setFloatPrice(price: Float) {
    text = price.toString()
}

//@BindingAdapter("quantity")
//fun EditText.setQuantity(qty: Int) {
//    setText(qty.toString())
//}