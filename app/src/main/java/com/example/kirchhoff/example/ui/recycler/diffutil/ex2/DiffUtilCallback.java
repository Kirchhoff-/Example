package com.example.kirchhoff.example.ui.recycler.diffutil.ex2;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * @author Kirchhoff-
 */

public class DiffUtilCallback extends DiffUtil.Callback {

    private List<Thing> current;
    private List<Thing> next;

    public DiffUtilCallback(List<Thing> current, List<Thing> next) {
        this.current = current;
        this.next = next;
    }

    @Override
    public int getOldListSize() {
        return current.size();
    }

    @Override
    public int getNewListSize() {
        return next.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Thing currentItem = current.get(oldItemPosition);
        Thing nextItem = next.get(newItemPosition);
        return currentItem.getId() == nextItem.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Thing currentItem = current.get(oldItemPosition);
        Thing nextItem = next.get(newItemPosition);
        return currentItem.equals(nextItem);
    }
}
