 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

/**
 *
 * @author gusta
 */
public class Produto {
    private ICMS icms;
    private Empacot empacotamento;
    private String NCM;
    private int ID ;
    private String decri;
    private double preco;
    private String codBar;
    private boolean ative;

    public Produto(ICMS icms, Empacot empacotamento, String NCM, int ID, String decri, double preco, String codBar, boolean ative) {
        this.icms = icms;
        this.empacotamento = empacotamento;
        this.NCM = NCM;
        this.ID = ID;
        this.decri = decri;
        this.preco = preco;
        this.codBar = codBar;
        this.ative = ative;
    }
   
    public int getID() {
        return ID;
    }
    
    public ICMS getIcms() {
        return icms;
    }

    public void setIcms(ICMS icms) {
        this.icms = icms;
    }

    public Empacot getEmpacotamento() {
        return empacotamento;
    }

    public void setEmpacotamento(Empacot empacotamento) {
        this.empacotamento = empacotamento;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public String getDecri() {
        return decri;
    }

    public void setDecri(String decri) {
        this.decri = decri;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodBar() {
        return codBar;
    }

    public void setCodBar(String codBar) {
        this.codBar = codBar;
    }

    public boolean isAtive() {
        return ative;
    }
    
    public void setAtive(boolean ative) {
        this.ative = ative;
    }
}