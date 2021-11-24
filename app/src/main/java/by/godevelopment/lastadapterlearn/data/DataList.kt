package by.godevelopment.lastadapterlearn.data

import androidx.databinding.ObservableArrayList
import by.godevelopment.lastadapterlearn.model.Header
import by.godevelopment.lastadapterlearn.model.Item

object DataList {
    val items = ObservableArrayList<Any>().apply {
        add(Header("Овощи"))
        add(Item("Картофель", 1.1F))
        add(Item("Капуста", 2.2F))
        add(Item("Перец", 3.3F))
        add(Item("Огурец", 4.4F))
        add(Item("Помидор", 5.5F))
        add(Header("Фрукты"))
        add(Item("Яблоко", 11.1F))
        add(Item("Банан", 12.2F))
        add(Item("Мандарин", 13.3F))
        add(Item("Апельсин", 14.4F))
        add(Item("Кокос", 15.5F))
        add(Header("Мясо"))
        add(Item("Курица", 15.1F))
        add(Item("Хрюшка", 20.3F))
        add(Item("Говядина", 25.5F))
        add(Item("Баранина", 27.7F))
        add(Item("Индюшатина", 17.2F))

    }
}