/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author gusta
 */
public class ctrlListProd {
    public static listagemProduto listag;
    public static Empacot emp;
    public void listar(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{ 
            conn = connectFactory.getConnection();
            pstm = conn.prepareStatement("SELECT id, descri, NCM, ICMS, preco, empac, codBar, ativo FROM Prod");
            rs = pstm.executeQuery();
            DefaultListModel<String> model = new  DefaultListModel<String>();
            while (rs.next()) {
                String id = rs.getString("id");
                String descri = rs.getString("descri");
                String NCM = rs.getString("NCM");
                String ICMS = rs.getString("ICMS");
                String preco = rs.getString("preco");
                emp = new Empacot(Integer.valueOf(rs.getString("empac")));
                String empac = emp.getEmpacType();
                String codBar = rs.getString("codBar");
                String ativo = rs.getString("ativo");

                for(int i = id.length()+4; i <= 12 ;i++){
                    id += " ";
                }for(int i = descri.length()+8; i <= 32 ;i++){
                    descri += " ";
                }for(int i = NCM.length(); i <= 21 ;i++){
                    NCM += " ";
                }for(int i = ICMS.length()+6; i <= 14 ;i++){
                    ICMS += " ";
                }for(int i = preco.length()+7; i <= 23 ;i++){
                    preco += " ";
                }for(int i = empac.length()+9; i <= 17 ;i++){
                    empac += " ";
                }for(int i = codBar.length()+12; i <= 44 ;i++){
                    codBar += " ";
                }
                
                String geral = "ID: "+id+
                        "Descri: "+descri+
                        "NCM: "+NCM+
                        "ICMS: "+ICMS+
                        "Preço: "+preco+
                        "Empacot: "+empac+
                        "Codigo Bar: "+codBar+
                        "Ativo: "+ativo;
                model.addElement(geral);
                listag.jListListagem.setModel(model);
            }
        }catch (Exception e){
            System.out.println("Erro ctrlListProd BD");
        }
        
    }
    
    public ctrlListProd(listagemProduto listag) {
        this.listag = listag;
    }
}
