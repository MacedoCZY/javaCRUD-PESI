/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

/**
 *
 * @author gusta
 */
public class Empacot {
    private int valSelect;

    public Empacot(int valSelect) {
        this.valSelect = valSelect;
    }

    public int getEmpac() {
        return this.valSelect;
    }
    
    public void setEmpac(int valSelect) {
        this.valSelect = valSelect;
    }

    public String getEmpacType() {
        switch(this.valSelect){
            case 1:
                return "KG";
            case 2:
                return "UN";
            case 3:
                return "MT";
            case 4:
                return "MT2";
            case 5:
                return "MT3";
            case 6:
                return "PÇ";
            case 7:
                return "PCT";
        }
        return null ;
    }
}