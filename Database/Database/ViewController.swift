//
//  ViewController.swift
//  Database
//
//  Created by admin on 03/04/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit
import CoreData

class ViewController: UIViewController {

    @IBOutlet weak var tfNome: UITextField!
       
    @IBOutlet weak var tdIdade: UITextField!
    
    
    @IBAction func salvar(_ sender: Any) {
        let ad = UIApplication.shared.delegate as! AppDelegate
        let context = ad.persistentContainer.viewContext
        let pessoa = NSEntityDescription.insertNewObject(forEntityName: "Pessoa", into: context)
        
        pessoa.setValue(self.tfNome.text, forKeyPath: "nome")
        pessoa.setValue(Int(self.tdIdade.text!), forKeyPath: "idade")
        
        do {
            try context.save()
            print("Deu certo")
        }catch {
            print("Deu errado")
        }
    }
    
    
    
    
}

