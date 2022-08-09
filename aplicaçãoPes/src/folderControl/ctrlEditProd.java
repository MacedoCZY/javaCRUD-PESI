/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package folderControl;

import folderEntity.Empacot;
import folderEntity.ICMS;
import folderEntity.Produto;
import aplicaçãopes.connectFactory;
import folderBoundery.listagemProduto;
import folderBoundery.editProd;
import static folderControl.ctrlCadProd.cad;
import static folderControl.ctrlViewProd.listagemproduto;
import static folderControl.ctrlViewProd.viewprod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ctrlEditProd {
    public static listagemProduto listagemproduto;
    public static editProd editprod;
    
   
    public int testarDad(int icms, int empacotament, String NCM, String decri, String preco, String codBar){  
        int ajuda = 0;
        ICMS icm = new ICMS(icms);
        Empacot empac = new Empacot(empacotament);
        if(preco.length() == 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione o Preço e tente novamente.");
            editprod.FieldPreco.setText(null);
            ajuda++;
        }if(icm.getValor() <= 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Escolha o tipo de ICMS e tente novamente.");
            ajuda++;
        }if(empac.getEmpac() <= 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Escolha o tipo de Empacotamento e tente novamente.");
            ajuda++;
        }if(NCM.length() == 0 || NCM.length() > 8){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione o NCM e tente novamente.");
            editprod.FieldNCM.setText(null);
            ajuda++;
        }if(decri.length() == 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione a Descrição e tente novamente.");
            editprod.FieldDesc.setText(null);
            ajuda++;
        }if(codBar.length() == 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione o Código de Barras e tente novamente.");
            editprod.FieldCodBarr.setText(null);
            ajuda++;
        }
        return ajuda;
    }
    
    public void update(int id, int icms, int empacotament, String NCM, String decri, String preco, String codBar, boolean ative){
        int idSelect = listagemproduto.jListListagem.getSelectedIndex()+1;
        ICMS icm = new ICMS(icms);
        Empacot empac = new Empacot(empacotament);
        
        if(testarDad(icms, empacotament, NCM, decri, preco, codBar) == 0){
            Produto produto = new Produto(icm, empac, NCM, id, decri, Double.valueOf(preco), codBar, ative);
            Connection conn = null;
            PreparedStatement pstm = null;
            int x = idSelect;
            String sql1 = "UPDATE Prod SET descri = ?, NCM = ?, ICMS = ?, preco = ?, empac = ?, codBar = ?, ativo = ? WHERE id = ?";
            try {
                //Cria uma conexão com o banco
                conn = connectFactory.getConnection();
                //Cria um PreparedStatment, classe usada para executar a query
                pstm = conn.prepareStatement(sql1);

                pstm.setInt(3, icm.getValor());

                pstm.setString(2, produto.getNCM());

                pstm.setInt(5, empac.getEmpac());

                pstm.setString(1, produto.getDecri());

                pstm.setDouble(4, produto.getPreco());

                pstm.setString(6, produto.getCodBar());

                pstm.setBoolean(7, produto.isAtive());

                pstm.setInt(8, x);

                pstm.executeUpdate();    

            } catch (Exception e) {

                e.printStackTrace();
                }finally{
            }
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Produto editado com sucesso!");
            editprod.dispose();
        }
    }
    
    public void show(){
        int idSelect = listagemproduto.jListListagem.getSelectedIndex()+1;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null; 
        try{ 
            conn = connectFactory.getConnection();
            pstm = conn.prepareStatement("SELECT id, descri, NCM, ICMS, preco, empac, codBar, ativo FROM Prod");
            rs = pstm.executeQuery();
            rs.next();
            while(true){
                if((Integer.valueOf(rs.getString("id")) == idSelect)){
                    editprod.FieldID.setText(rs.getString("id"));
                    editprod.FieldDesc.setText(rs.getString("descri"));
                    editprod.FieldNCM.setText(rs.getString("NCM"));
                    if(Integer.valueOf(rs.getString("ICMS"))==101){
                        editprod.combBoxICMS.setSelectedIndex(1);
                    }else{
                        editprod.combBoxICMS.setSelectedIndex(2);
                    }
                    editprod.FieldPreco.setText(rs.getString("preco"));
                    editprod.combBoxEMPAC.setSelectedIndex(Integer.valueOf(rs.getString("empac")));
                    editprod.FieldCodBarr.setText(rs.getString("codBar"));
                    boolean aj = false;
                    if(Integer.valueOf(rs.getString("ativo"))==0){
                        aj = false;
                    }else{aj = true;}
                    editprod.Ativo.setSelected(aj);
                    break;
                }else{
                    rs.next();
                }
            }
        }catch (Exception e){
            System.out.println("Erro ctrlEditProd bd");
        }
    }
    public ctrlEditProd(listagemProduto listagemproduto, editProd editprod) {
        this.listagemproduto = listagemproduto;
        this.editprod = editprod;
    }
}
