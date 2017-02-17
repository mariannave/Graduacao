//
//  Pessoa.swift
//  Pessoa
//
//  Created by admin on 17/02/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Pessoa: NSObject {
    var nome: String!
    var idade: Int!
    
    init(nome:String, idade:Int) {
        self.nome = nome
        self.idade = idade
    }
    
    override var description: String {
        return "Nome: \(self.nome) - Idade: \(self.idade)"
    }
    
}
