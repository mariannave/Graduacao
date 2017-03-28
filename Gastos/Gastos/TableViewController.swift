//
//  TableViewController.swift
//  Gastos
//
//  Created by admin on 28/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController {

    var cadastro: Cadastro!
    
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
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows

        return self.cadastro.quantidade()
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {

        let cell = tableView.dequeueReusableCell(withIdentifier: "celula", for: indexPath)
        
        cell.textLabel?.text = self.cadastro.gastos[indexPath.row].descricao
        
        return cell
    }

    
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }

    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "FormularioViewControllerID") as! FormularioViewController
        
        vc.gasto = cadastro.gastos[indexPath.row]
        
        self.navigationController?.pushViewController(vc, animated: true)
    }
    
    
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            
            self.cadastro.del(pos: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
            
        }
    }

  
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }

    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
   
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "principal_formulario"){
            let formVC  = segue.destination as! FormularioViewController
            formVC.cadastro = self.cadastro
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.tableView.reloadData()
    }

}
