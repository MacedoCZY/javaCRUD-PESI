/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

/**
 *
 * @author gusta
 */
public class ICMS {
    private int valor;

    public ICMS(int valor) {
        setValor(valor);
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if(valor == 1){
            this.valor = 101;
        }else if(valor == 2){
            this.valor = 500;
        }
    }
    
}
