package cz.fit.cvut.biand.homework1.model

data class Character (
    val id : Int,
    val name : String,
    val status : String,
    val species : String,
    val type : String,
    val gender : String,
    val origin : String,
    val location : String,
    val imgUrl : String
)

val characters = listOf(
    Character(1, "Rick Sanchez", "Alive", "Human", "", "Male", "Earth (C-137)", "Citadel of Ricks", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
    Character(2, "Morty Smith", "Alive", "Human", "", "Male", "unknown", "Citadel of Ricks", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
    Character(3, "Summer Smith", "Alive", "Human", "", "Female", "Earth (Replacement Dimension)", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/character/avatar/3.jpeg"),
    Character(4, "Beth Smith", "Alive", "Human", "", "Female", "Earth (Replacement Dimension)", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/character/avatar/4.jpeg"),
    Character(5, "Jerry Smith", "Alive", "Human", "", "Male", "Earth (Replacement Dimension)", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
    Character(6, "Abadango Cluster Princess", "Alive", "Alien", "", "Female", "Abadango", "Abadango", "https://rickandmortyapi.com/api/character/avatar/6.jpeg"),
    Character(7, "Abradolf Lincler", "unknown", "Human", "Genetic experiment", "Male", "Earth (C-137)", "Testicle Monster Dimension", "https://rickandmortyapi.com/api/character/avatar/7.jpeg"),
    Character(8, "Adjudicator Rick", "Dead", "Human", "", "Male", "unknown", "Citadel of Ricks", "https://rickandmortyapi.com/api/character/avatar/8.jpeg"),
    Character(9, "Agency Director", "Dead", "Human", "", "Male", "unknown", "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/character/avatar/9.jpeg"),
    Character(10, "Alan Rails", "Dead", "Human", "Superhuman (Ghost trains summoner)", "Male", "unknown", "Worldender's lair", "https://rickandmortyapi.com/api/character/avatar/10.jpeg")
)