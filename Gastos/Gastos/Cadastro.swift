//
//  Cadastro.swift
//  Gastos
//
//  Created by admin on 28/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Cadastro: NSObject, NSCoding{
    var gastos: Array<Gasto>
    
    override init(){
        self.gastos = Array<Gasto>()
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.gastos = aDecoder.decodeObject(forKey: "gastos") as! Array<Gasto>
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.gastos, forKey: "gastos")
    }
    
    
    func add(gasto:Gasto){
        self.gastos.append(gasto)
    }
    
    func quantidade() -> Int{
        return self.gastos.count
    }
    
    func del(pos: Int){
        self.gastos.remove(at: pos)
    }
    
    func troca(origem: Int, destino: Int) {
        let aux = self.gastos[origem]
        self.gastos[origem] = self.gastos[destino]
        self.gastos[destino] = aux;
    }
}
