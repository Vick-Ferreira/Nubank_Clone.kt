package com.grud.clone_nubank.nubank_clonekt

import androidx.lifecycle.ViewModel

//Criando uma ViewModel que conterá os dados do usuário que desejo coletar durante o processo de registro
class RegistroViewModel : ViewModel(){

    var cpf: String = ""
    var email: String = ""
    var telefone: String = ""
    var nome: String = ""
    var senha: String = ""


}