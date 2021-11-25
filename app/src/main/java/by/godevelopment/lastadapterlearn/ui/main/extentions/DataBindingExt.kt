package by.godevelopment.lastadapterlearn.ui.main.extentions

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

fun ObservableInt.onValueChanged(callback: (Int) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable, propertyId: Int) {
            callback.invoke(get())
        }
    })
}

fun ObservableField<String>.onValueChanged(callback: (String?) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable, propertyId: Int) {
            callback.invoke(get())
        }
    })
}