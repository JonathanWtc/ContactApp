package com.example.app

class NameList {
    companion object {
        var names = mutableListOf<MyListModel>(
            MyListModel(
                nombre = "Jonathan",
                numero = 997479237,
                imagen = "https://w7.pngwing.com/pngs/870/997/png-transparent-creative-hand-painted-cartoon-villain-cartoon-business-flat-silhouette-figures-character-people-icon.png"
            ),
            MyListModel(
                nombre = "Judith",
                numero = 984293478,
                imagen = "https://thumbs.dreamstime.com/b/aislado-secretaria-mujer-logo-profesiones-empleo-icono-vector-204846010.jpg"
            )
        )
    }
}