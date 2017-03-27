//
//  TableViewController.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController {
    
    var cadastro = Cadastro()

    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.leftBarButtonItem = self.editButtonItem

        let appdel = UIApplication.shared.delegate as! AppDelegate
        self.cadastro = appdel.cadastro
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.cadastro.quantidade()
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "celula", for: indexPath)

        cell.textLabel?.text = self.cadastro.chocolates[indexPath.row].pessoa

        return cell
    }

    
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print(cadastro.chocolates[indexPath.row])
        
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "FormularioViewControllerID") as! FormularioViewController
        
        vc.chocolate = cadastro.chocolates[indexPath.row]
        
        self.navigationController?.pushViewController(vc, animated: true)
        
    }

    
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            
            self.cadastro.del(pos: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
            
        }   
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "principal_sobre"){
            let sobreVC = segue.destination as! SobreViewController
            sobreVC.cadastro = self.cadastro
        }else if(segue.identifier == "principal_formulario"){
            let formVC  = segue.destination as! FormularioViewController
            formVC.cadastro = self.cadastro
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.tableView.reloadData()
    }
 

}
