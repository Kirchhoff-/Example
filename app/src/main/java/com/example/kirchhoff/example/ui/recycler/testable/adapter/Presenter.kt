package com.example.kirchhoff.example.ui.recycler.testable.adapter

import com.example.kirchhoff.example.ui.recycler.testable.SimpleListItemView

internal class Presenter {

    fun presenterListItem(view: SimpleListItemView, position: Int) {
        view.setText(position.toString())
    }

}