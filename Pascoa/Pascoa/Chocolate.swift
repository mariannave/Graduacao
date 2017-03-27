//
//  Chocolate.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Chocolate:NSObject , NSCoding{
    var pessoa:String!
    var chocolate:String!
    var data: Date!
    
    init(pessoa:String, chocolate:String, data:Date) {
        self.pessoa = pessoa
        self.chocolate = chocolate
        self.data = data
    }
    
    override var description: String {
        return "Pessoa: \(self.pessoa) + Chocolate: \(self.chocolate)"
    }
    
    
    required init?(coder aDecoder: NSCoder) {
        self.pessoa = aDecoder.decodeObject(forKey: "pessoa") as! String
        self.chocolate = aDecoder.decodeObject(forKey: "chocolate") as! String
        self.data = aDecoder.decodeObject(forKey: "data") as! Date
        
    }
    
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.pessoa, forKey: "pessoa")
        aCoder.encode(self.chocolate, forKey: "chocolate")
        aCoder.encode(self.data, forKey: "data")
    }
    
}
