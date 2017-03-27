//
//  Cadastro.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Cadastro: NSObject, NSCoding {
    var chocolates:Array<Chocolate>!
    
    override init(){
        self.chocolates = Array<Chocolate>()
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.chocolates = aDecoder.decodeObject(forKey: "chocolates") as! Array<Chocolate>
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.chocolates, forKey: "chocolates")
    }
    
    
    func add(chocolate:Chocolate){
        self.chocolates.append(chocolate)
    }
    
    func quantidade() -> Int{
        return self.chocolates.count
    }
    
    func del(pos: Int){
        self.chocolates.remove(at: pos)
    }
    
}
