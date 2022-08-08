/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;

import static aplicaçãopes.ctrlListProd.listag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;

/**
 *
 * @author gusta
 */
public class ctrlViewProd {
        public static listagemProduto listagemproduto;
        public static viewProd viewprod;
        
        public void show(){
            listagemproduto.jListListagem.getSelectedIndex();
            Connection conn = null;
            PreparedStatement pstm = null;
            ResultSet rs = null; 
            try{ 
                conn = connectFactory.getConnection();
                pstm = conn.prepareStatement("SELECT id, descri, NCM, ICMS, preco, empac, codBar, ativo FROM Prod");
                rs = pstm.executeQuery();

                viewprod.FieldID.setText(rs.getString("id"));
                viewprod.FieldDesc.setText(rs.getString("descri"));
                viewprod.FieldNCM.setText(rs.getString("NCM"));
                viewprod.combBoxICMS.setSelectedIndex(Integer.valueOf(rs.getString("ICMS")));
                viewprod.FieldPreco.setText(rs.getString("preco"));
                viewprod.combBoxEMPAC.setSelectedIndex(Integer.valueOf(rs.getString("empac")));
                viewprod.FieldCodBarr.setText(rs.getString("codBar"));
                viewprod.Ativo.setSelected(Boolean.valueOf(rs.getString("ativo")));
            }catch (Exception e){
                System.out.println("Erro 404 not a found");
            }
        }
    public ctrlViewProd(listagemProduto listagemproduto, viewProd viewprod){
        this.listagemproduto = listagemproduto;
        this.viewprod = viewprod;
    }

}

