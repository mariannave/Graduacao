//
//  AppDelegate.swift
//  Gastos
//
//  Created by admin on 28/03/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    var cadastro: Cadastro!

    
    func arquivo() -> String {
        return NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.userDomainMask, true)[0] + "/gastos"
    }
    

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        let obj = NSKeyedUnarchiver.unarchiveObject(withFile: self.arquivo())
        if (obj != nil){
            self.cadastro = obj as! Cadastro
        }else{
            self.cadastro = Cadastro()
        }
        return true
    }



    func applicationDidEnterBackground(_ application: UIApplication) {
       NSKeyedArchiver.archiveRootObject(self.cadastro, toFile: self.arquivo())

    }
  

}

