//
//  FormularioViewController.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class FormularioViewController: UIViewController {
   
    var cadastro:Cadastro!
    
    @IBOutlet weak var tfPessoa: UITextField!

    @IBOutlet weak var tfChocolate: UITextField!
    
    @IBAction func salvar(_ sender: Any) {
        let pessoa = self.tfPessoa.text
        let chocolate = self.tfChocolate.text
        
        let entrada = Chocolate(pessoa: pessoa!, chocolate: chocolate!)
        
        self.cadastro.add(chocolate: entrada)
        
        print(cadastro.chocolates.description)
        
        self.navigationController?.popViewController(animated: true)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
    
    }

}
