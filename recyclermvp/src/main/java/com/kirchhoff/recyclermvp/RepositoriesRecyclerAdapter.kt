package com.kirchhoff.recyclermvp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class RepositoriesRecyclerAdapter(private val presenter: RepositoriesListPresenter) : RecyclerView.Adapter<RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            RepositoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.r_mvp_repository, parent, false))

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder)
    }

    override fun getItemCount() = presenter.getReposotoriesRowsCount()
}
