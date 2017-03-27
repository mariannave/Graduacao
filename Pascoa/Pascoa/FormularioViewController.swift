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

    
    @IBOutlet weak var dataDaEntrega: UIDatePicker!
    @IBOutlet weak var tfPessoa: UITextField!
    @IBOutlet weak var tfChocolate: UITextField!
    
    var chocolate: Chocolate!
    
    
    @IBAction func salvar(_ sender: Any) {
        let pessoa = self.tfPessoa.text
        let chocolate = self.tfChocolate.text
        let data = self.dataDaEntrega.date
        
        let entrada = Chocolate(pessoa: pessoa!, chocolate: chocolate!,data: data)
        
        self.cadastro.add(chocolate: entrada)
        
        print(cadastro.chocolates.description)
        
        self.navigationController?.popViewController(animated: true)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: UIBarButtonSystemItem.save, target: self, action: #selector(salvar))

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    
    override func viewWillAppear(_ animated: Bool) {
        self.tfPessoa.text = self.chocolate.pessoa
        self.tfChocolate.text = self.chocolate.chocolate
        self.dataDaEntrega.date = self.chocolate.data
    }
}
