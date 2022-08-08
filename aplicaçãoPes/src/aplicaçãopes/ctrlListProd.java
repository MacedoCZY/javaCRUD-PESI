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
                String empac = rs.getString("empac");
                String codBar = rs.getString("codBar");
                String ativo = rs.getString("ativo");
                String geral;
                for(int i = id.length(); i < 8 ;i++){
                    id += " ";
                }for(int i = descri.length(); i < 40 ;i++){
                    descri += " ";
                }for(int i = NCM.length(); i < 16 ;i++){
                    NCM += " ";
                }for(int i = ICMS.length(); i < 12 ;i++){
                    ICMS += " ";
                }for(int i = preco.length(); i < 20 ;i++){
                    preco += " ";
                }for(int i = empac.length(); i < 12 ;i++){
                    empac += " ";
                }for(int i = codBar.length(); i < 60 ;i++){
                    codBar += " ";
                }
                
                geral = String.valueOf(id)+
                        String.valueOf(descri)+
                        String.valueOf(NCM)+
                        String.valueOf(ICMS)+
                        String.valueOf(preco)+
                        String.valueOf(empac)+
                        String.valueOf(codBar)+
                        String.valueOf(ativo);
                model.addElement(geral);
                listag.jListListagem.setModel(model);
            }
        }catch (Exception e){
            System.out.println("Erro 404 not a found");
        }
        
    }
    
    public ctrlListProd(listagemProduto listag) {
        this.listag = listag;
    }
}
