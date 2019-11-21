package com.example.recyclerdragdrop.data

internal class UsersRepository {

    companion object {
        fun provideUsersList(): MutableList<User> {
            val resultList: MutableList<User> = ArrayList()
            resultList.addAll(provideDevelopersList())
            resultList.addAll(provideDesignersList())
            resultList.addAll(provideTeamLeadsList())
            resultList.addAll(provideTeamManagersList())
            return resultList
        }

        private fun provideDevelopersList(): List<User> {
            return listOf(
                    User(DEVELOPERS),
                    User("Frederick Hoffman", "https://randomuser.me/api/portraits/men/52.jpg", "Developers"),
                    User("Calvin Young", "https://randomuser.me/api/portraits/men/78.jpg", "Developers"),
                    User("Jeanette Reid", "https://randomuser.me/api/portraits/women/37.jpg", "Developers"),
                    User("Flenn Wilson", "https://randomuser.me/api/portraits/men/40.jpg", "Developers"),
                    User("Martin Holland", "https://randomuser.me/api/portraits/men/0.jpg", "Developers")
            )
        }

        private fun provideDesignersList(): List<User> {
            return listOf(
                    User(DESIGNERS),
                    User("Jeanette Simmmons", "https://randomuser.me/api/portraits/women/3.jpg", "Designers"),
                    User("Wallace Lambert", "https://randomuser.me/api/portraits/men/53.jpg", "Designers"),
                    User("Andy Clark", "https://randomuser.me/api/portraits/men/68.jpg", "Designers"),
                    User("olivia obrien", "https://randomuser.me/api/portraits/women/93.jpg", "Designers"),
                    User("Debbie Bennett", "https://randomuser.me/api/portraits/women/34.jpg", "Designers")
            )
        }

        private fun provideTeamLeadsList(): List<User> {
            return listOf(
                    User(TEAM_LEADS),
                    User("Bernice Lawson", "https://randomuser.me/api/portraits/women/20.jpg", "Team Leads"),
                    User("Camila Elliott", "https://randomuser.me/api/portraits/women/60.jpg", "Team Leads"),
                    User("Gerald Webb", "https://randomuser.me/api/portraits/men/55.jpg", "Team Leads"),
                    User("Russell Hart", "https://randomuser.me/api/portraits/men/18.jpg", "Team Leads"),
                    User("Joyce Mccoy", "https://randomuser.me/api/portraits/women/82.jpg", "Team Leads")
            )
        }

        private fun provideTeamManagersList(): List<User> {
            return listOf(
                    User(TEAM_MANAGERS),
                    User("Daryl Banks", "https://randomuser.me/api/portraits/men/4.jpg", "Team Managers"),
                    User("Veronica Vargas", "https://randomuser.me/api/portraits/women/14.jpg", "Team Managers"),
                    User("Natalie Jacobs", "https://randomuser.me/api/portraits/women/0.jpg", "Team Managers"),
                    User("Beverly Kennedy", "https://randomuser.me/api/portraits/women/30.jpg", "Team Managers")
            )
        }

        private const val DEVELOPERS = "Developers"
        private const val DESIGNERS = "Designers"
        private const val TEAM_LEADS = "Team Leads"
        private const val TEAM_MANAGERS = "Team Managers"
    }
}
