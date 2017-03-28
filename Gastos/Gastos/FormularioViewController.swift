//
//  FormularioViewController.swift
//  Gastos
//
//  Created by admin on 28/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class FormularioViewController: UIViewController {
   
    var cadastro:Cadastro!
    var gasto: Gasto!

    @IBOutlet weak var tfDescricao: UITextField!
    @IBOutlet weak var tfValor: UITextField!
    @IBOutlet weak var dataCadastro: UIDatePicker!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: UIBarButtonSystemItem.save, target: self, action: #selector(salvar))
    }
    
    func salvar(_ sender: Any) {
        let descricao = self.tfDescricao.text
        let valor = Float(self.tfValor.text!)
        let data = self.dataCadastro.date
        
        
        if(self.gasto != nil){
            self.gasto.descricao = self.tfDescricao.text
            self.gasto.valor = Float(self.tfValor.text!)
            self.gasto.data = self.dataCadastro.date
            
        }else {
            let entrada = Gasto(descricao: descricao!, valor: valor!, data: data)
            self.cadastro.add(gasto: entrada)
        }
        
        self.navigationController?.popViewController(animated: true)
    }
    
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        if (self.gasto != nil){
                    self.tfDescricao.text = self.gasto.descricao
                    self.tfValor.text = String(self.gasto.valor)
                    self.dataCadastro.date = self.gasto.data
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        self.tfDescricao.text = self.gasto.descricao
        self.tfValor.text = String(self.gasto.valor)
        self.dataCadastro.date = self.gasto.data
    }
}
