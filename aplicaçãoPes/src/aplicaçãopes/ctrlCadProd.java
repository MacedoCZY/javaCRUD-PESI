/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicaçãopes;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
/**
 *
 * @author gusta
 */
public class ctrlCadProd {
    public static cadastroProduto cad;
    
    public int testarDad(int icms, int empacotament, String NCM, String decri, String preco, String codBar){  
        int ajuda = 0;
        ICMS icm = new ICMS(icms);
        Empacot empac = new Empacot(empacotament);
        if(preco.length() == 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione o Preço e tente novamente.");
            cad.FieldPreco.setText(null);
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
            cad.FieldNCM.setText(null);
            ajuda++;
        }if(decri.length() == 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione a Descrição e tente novamente.");
            cad.FieldDesc.setText(null);
            ajuda++;
        }if(codBar.length() == 0){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro: Adicione o Código de Barras e tente novamente.");
            cad.FieldCodBarr.setText(null);
            ajuda++;
        }
        return ajuda;
    }
    
    public void save(int id, int icms, int empacotament, String NCM, String decri, String preco, String codBar, boolean ative){
        
        ICMS icm = new ICMS(icms);
        Empacot empac = new Empacot(empacotament);
        
        if(testarDad(icms, empacotament, NCM, decri, preco, codBar) == 0){
            Produto produto = new Produto(icm, empac, NCM, id, decri, Double.valueOf(preco), codBar, ative);
            Connection conn = null;
            PreparedStatement pstm = null;
            String sql = "INSERT INTO Prod(descri, NCM, ICMS, preco, empac, codBar, ativo, id)" 
                    + " VALUES(?,?,?,?,?,?,?, ?)";

            try {
                //Cria uma conexão com o banco
                conn = connectFactory.getConnection();
                //Cria um PreparedStatment, classe usada para executar a query
                pstm = conn.prepareStatement(sql);

                pstm.setInt(3, icm.getValor());

                pstm.setString(2, produto.getNCM());

                pstm.setInt(5, empac.getEmpac());

                pstm.setString(1, produto.getDecri());

                pstm.setDouble(4, produto.getPreco());

                pstm.setString(6, produto.getCodBar());

                pstm.setBoolean(7, produto.isAtive());

                pstm.setInt(8, produto.getID());

                pstm.execute();    

            } catch (Exception e) {

                e.printStackTrace();
                }finally{
            }
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Produto adicionado com sucesso!");
            cad.FieldPreco.setText(null);
            cad.FieldNCM.setText(null);
            cad.FieldDesc.setText(null);
            cad.FieldCodBarr.setText(null);
            cad.combBoxEMPAC.setSelectedIndex(0);
            cad.combBoxICMS.setSelectedIndex(0);
            AplicaçãoPes.Menu.listagemproduto.cadastroproduto.atualizaId();
        }
    }
    public ctrlCadProd(cadastroProduto cad) {
        this.cad = cad;
    }

}