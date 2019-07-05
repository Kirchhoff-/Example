package com.kirchhoff.recyclermvp

class RepositoriesListPresenter {

    private val repositories: List<Repository> = listOf(
            Repository("Zero", 0),
            Repository("One", 1),
            Repository("Two", 2),
            Repository("Three", 3),
            Repository("Four", 4)
    )

    fun getReposotoriesRowsCount() = repositories.size

    fun onBindRepositoryRowViewAtPosition(position: Int, rowView: RepositoryRowView) {
        val row = repositories[position]
        rowView.setStarCount(row.starsCount)
        rowView.setTitle(row.title)
    }
}