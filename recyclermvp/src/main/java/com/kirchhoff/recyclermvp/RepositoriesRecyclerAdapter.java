package com.kirchhoff.recyclermvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


/**
 * @author Kirchhoff-
 */

public class RepositoriesRecyclerAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {

    private final RepositoriesListPresenter presenter;


    public RepositoriesRecyclerAdapter(RepositoriesListPresenter repositoriesListPresenter) {
        this.presenter = repositoriesListPresenter;
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.r_mvp_repository, parent, false));
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getReposotoriesRowsCount();
    }
}
