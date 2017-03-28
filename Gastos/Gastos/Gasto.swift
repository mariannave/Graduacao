//
//  Gasto.swift
//  Gastos
//
//  Created by admin on 28/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Gasto: NSObject, NSCoding {
    var descricao: String!
    var valor: Float!
    var data: Date!
    
    
    init(descricao: String, valor: Float, data: Date){
        self.descricao = descricao
        self.valor = valor
        self.data = data
    }
    
    override var description: String{
        return "Descricao:\(self.descricao) - Valor:\(self.valor)"
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.descricao = aDecoder.decodeObject(forKey: "descricao") as! String
        self.valor = aDecoder.decodeObject(forKey: "valor") as! Float
        self.data = aDecoder.decodeObject(forKey: "data") as! Date
        
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.descricao, forKey: "descricao")
        aCoder.encode(self.valor, forKey: "valor")
        aCoder.encode(self.data, forKey: "data")
    }
}
