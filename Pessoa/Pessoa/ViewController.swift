import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    @IBOutlet weak var lbContador: UILabel!
    
    var cadastro = Cadastro()
    
    @IBAction func salvar(_ sender: Any) {
        print("\(self.tfNome.text) - \(self.tfIdade.text) ")
        let pessoa = Pessoa(nome: self.tfNome.text!, idade: Int(self.tfIdade.text!)!)
        self.cadastro.add(p: pessoa)
        
        let count = self.cadastro.qtde()
        
        self.lbContador.text = String(count)
        
        self.tfNome.text = ""
        self.tfIdade.text = ""
    }
    
    @IBAction func limpar(_ sender: Any) {
        print("limpou")
        self.tfNome.text = ""
        self.tfIdade.text = ""
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
}

