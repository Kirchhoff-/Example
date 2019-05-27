package com.kirchhoff.recyclermvp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class RepositoriesListPresenter {


    private final List<Repository> repositories;


    public RepositoriesListPresenter() {
        repositories = new ArrayList<>();
        repositories.add(new Repository("First", 0));
        repositories.add(new Repository("Second", 1));
        repositories.add(new Repository("Third", 2));
        repositories.add(new Repository("Four", 3));
        repositories.add(new Repository("Five", 4));
    }

    public void onBindRepositoryRowViewAtPosition(int position, RepositoryRowView rowView) {
        Repository row = repositories.get(position);
        rowView.setStarCount(row.getStarsCount());
        rowView.setTitle(row.getTitle());
    }


    public int getReposotoriesRowsCount() {
        return repositories.size();
    }
}
