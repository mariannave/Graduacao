//
//  main.swift
//  Linha-de-Comando
//
//  Created by admin on 06/02/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Pessoa: CustomStringConvertible{
    var nome:String!
    var idade:Int!
    
    var description:String{
        //return self.nome + " - " + String(self.idade)
        return "\(self.nome) - \(self.idade)"
    }
    
    init(nome:String, idade:Int) {
        self.nome = nome
        self.idade = idade
    }
    
    func dobro() -> Int {
        return self.idade * 2
    }
}


class PessoaFisica: Pessoa {
    var cpf:String!
    
    init(nome:String, idade:Int, cpf:String) {
        super.init(nome: nome, idade: idade)
        self.cpf = cpf
    }
    
    override func dobro() -> Int {
        return super.dobro() * 2
    }
    
    override var description: String {
        return "\(self.nome) - \(self.idade) - \(self.cpf)"
    }
    
    
}


var p1 = Pessoa(nome: "Marianna", idade: 20)
print(p1.nome)
print(p1.dobro())
print(p1)

print("-------------------------")
var pf1 = PessoaFisica(nome: "Marianna", idade: 15, cpf: "123456789")
print(pf1.nome)
print(pf1.dobro())
print(pf1)
