//
//  ViewController.swift
//  Pessoa
//
//  Created by admin on 13/02/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    @IBOutlet weak var lbContador: UILabel!
    
    @IBAction func salvar(_ sender: Any) {
        print("funfou")
    
    }
    
    @IBAction func limpar(_ sender: Any) {

    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
}

