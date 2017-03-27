//
//  SobreViewController.swift
//  Pascoa
//
//  Created by admin on 17/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {
  
    var cadastro:Cadastro!

    @IBOutlet weak var lbqtde: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.lbqtde.text = String(cadastro.quantidade())
    }

}
