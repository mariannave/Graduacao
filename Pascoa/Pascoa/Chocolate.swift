//
//  Chocolate.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Chocolate:NSObject {
    var pessoa:String!
    var chocolate:String!
    
    init(pessoa:String, chocolate:String) {
        self.pessoa = pessoa
        self.chocolate = chocolate
    }
    
    override var description: String {
        return "Pessoa: \(self.pessoa) + Chocolate: \(self.chocolate)"
    }
    
}
