package com.example.recyclerdragdrop.data

internal class UsersRepository private constructor() {

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
                    User("Frederick Hoffman", "https://randomuser.me/api/portraits/men/52.jpg", DEVELOPERS),
                    User("Calvin Young", "https://randomuser.me/api/portraits/men/78.jpg", DEVELOPERS),
                    User("Jeanette Reid", "https://randomuser.me/api/portraits/women/37.jpg", DEVELOPERS),
                    User("Flenn Wilson", "https://randomuser.me/api/portraits/men/40.jpg", DEVELOPERS),
                    User("Martin Holland", "https://randomuser.me/api/portraits/men/0.jpg", DEVELOPERS)
            )
        }

        private fun provideDesignersList(): List<User> {
            return listOf(
                    User(DESIGNERS),
                    User("Jeanette Simmmons", "https://randomuser.me/api/portraits/women/3.jpg", DESIGNERS),
                    User("Wallace Lambert", "https://randomuser.me/api/portraits/men/53.jpg", DESIGNERS),
                    User("Andy Clark", "https://randomuser.me/api/portraits/men/68.jpg", DESIGNERS),
                    User("olivia obrien", "https://randomuser.me/api/portraits/women/93.jpg", DESIGNERS),
                    User("Debbie Bennett", "https://randomuser.me/api/portraits/women/34.jpg", DESIGNERS)
            )
        }

        private fun provideTeamLeadsList(): List<User> {
            return listOf(
                    User(TEAM_LEADS),
                    User("Bernice Lawson", "https://randomuser.me/api/portraits/women/20.jpg", TEAM_LEADS),
                    User("Camila Elliott", "https://randomuser.me/api/portraits/women/60.jpg", TEAM_LEADS),
                    User("Gerald Webb", "https://randomuser.me/api/portraits/men/55.jpg", TEAM_LEADS),
                    User("Russell Hart", "https://randomuser.me/api/portraits/men/18.jpg", TEAM_LEADS),
                    User("Joyce Mccoy", "https://randomuser.me/api/portraits/women/82.jpg", TEAM_LEADS)
            )
        }

        private fun provideTeamManagersList(): List<User> {
            return listOf(
                    User(TEAM_MANAGERS),
                    User("Daryl Banks", "https://randomuser.me/api/portraits/men/4.jpg", TEAM_MANAGERS),
                    User("Veronica Vargas", "https://randomuser.me/api/portraits/women/14.jpg", TEAM_MANAGERS),
                    User("Natalie Jacobs", "https://randomuser.me/api/portraits/women/0.jpg", TEAM_MANAGERS),
                    User("Beverly Kennedy", "https://randomuser.me/api/portraits/women/30.jpg", TEAM_MANAGERS)
            )
        }

        private const val DEVELOPERS = "Developers"
        private const val DESIGNERS = "Designers"
        private const val TEAM_LEADS = "Team Leads"
        private const val TEAM_MANAGERS = "Team Managers"
    }
}
