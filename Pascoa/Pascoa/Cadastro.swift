//
//  Cadastro.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Cadastro: NSObject {
    var chocolates:Array<Chocolate>!
    
    override init(){
        self.chocolates = Array<Chocolate>()
    }
    
    func add(chocolate:Chocolate){
        self.chocolates.append(chocolate)
    }
    
    func quantidade() -> Int{
        return self.chocolates.count
    }
    
}
