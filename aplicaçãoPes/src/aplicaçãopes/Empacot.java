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
    public String tipo;

    public Empacot(int valSelect) {
        this.valSelect = valSelect;
        this.tipo = setEmpac(valSelect);
    }

    public String getEmpac() {
        return this.tipo;
    }

    public String setEmpac(int valSelect) {
        this.valSelect = valSelect;
        switch(valSelect){
            case 1:
                return this.tipo = "KG";
            case 2:
                return this.tipo = "UN";
            case 3:
                return this.tipo = "MT";
            case 4:
                return this.tipo = "MT2";
            case 5:
                return this.tipo= "MT3";
            case 6:
                return this.tipo = "PÇ";
            case 7:
                return this.tipo = "PCT";
        }
        return null ;
    }
}