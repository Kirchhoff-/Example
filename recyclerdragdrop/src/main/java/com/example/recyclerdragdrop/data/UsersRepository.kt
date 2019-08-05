package com.example.recyclerdragdrop.data

internal class UsersRepository {

    companion object {
        fun provideUsersList(): MutableList<User> {
            return mutableListOf(User(0, "", "", "Developers"),
                    User(1, "Frederick Hoffman", "https://randomuser.me/api/portraits/men/52.jpg", "Developers"),
                    User(2, "Calvin Young", "https://randomuser.me/api/portraits/men/78.jpg", "Developers"),
                    User(3, "Jeanette Reid", "https://randomuser.me/api/portraits/women/37.jpg", "Developers"),
                    User(4, "Flenn Wilson", "https://randomuser.me/api/portraits/men/40.jpg", "Developers"),
                    User(5, "Martin Holland", "https://randomuser.me/api/portraits/men/0.jpg", "Developers"),
                    User(6, "", "", "Designers"),
                    User(7, "Jeanette Simmmons", "https://randomuser.me/api/portraits/women/3.jpg", "Designers"),
                    User(8, "Wallace Lambert", "https://randomuser.me/api/portraits/men/53.jpg", "Designers"),
                    User(9, "Andy Clark", "https://randomuser.me/api/portraits/men/68.jpg", "Designers"),
                    User(10, "olivia obrien", "https://randomuser.me/api/portraits/women/93.jpg", "Designers"),
                    User(11, "Debbie Bennett", "https://randomuser.me/api/portraits/women/34.jpg", "Designers"),
                    User(12, "", "", "Team Leads"),
                    User(13, "Bernice Lawson", "https://randomuser.me/api/portraits/women/20.jpg", "Team Leads"),
                    User(14, "Camila Elliott", "https://randomuser.me/api/portraits/women/60.jpg", "Team Leads"),
                    User(15, "Gerald Webb", "https://randomuser.me/api/portraits/men/55.jpg", "Team Leads"),
                    User(16, "Russell Hart", "https://randomuser.me/api/portraits/men/18.jpg", "Team Leads"),
                    User(17, "Joyce Mccoy", "https://randomuser.me/api/portraits/women/82.jpg", "Team Leads"),
                    User(18, "", "", "Team Managers"),
                    User(19, "Daryl Banks", "https://randomuser.me/api/portraits/men/4.jpg", "Team Managers"),
                    User(20, "Veronica Vargas", "https://randomuser.me/api/portraits/women/14.jpg", "Team Managers"),
                    User(21, "Natalie Jacobs", "https://randomuser.me/api/portraits/women/0.jpg", "Team Managers"),
                    User(22, "Beverly Kennedy", "https://randomuser.me/api/portraits/women/30.jpg", "Team Managers"))
        }
    }
}