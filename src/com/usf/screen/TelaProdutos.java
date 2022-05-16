package com.usf.screen;

import com.usf.jdbc.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelaProdutos extends JFrame {
    private JTable tabelaProdutos;
    private JPanel produtosScreen;
    private JButton botaoVoltarTelaInicial;
    private JTextField textField1;

    public TelaProdutos(String title){

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(produtosScreen);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        carregaTabela();
        botaoVoltarTelaInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainScreen("Tela inicial");
                frame.setVisible(true);
                dispose();
            }
        });
    }

    public void carregaTabela(){

        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        modelo.setNumRows(0);

        modelo.addColumn("idProduto");
        modelo.addColumn("nome");
        modelo.addColumn("valor");

        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(35);
        tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(20);

        try{
            Connection con = ConnectionFactory.conecta();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("select * from public.Produto");
            rs = pstm.executeQuery();

            while(rs.next()){
                modelo.addRow(new Object[]{
                   rs.getInt(1),
                   rs.getString(2),
                   rs.getString(3)

                });
            }

        ConnectionFactory.closeConnection(con, pstm, rs);
        } catch(Exception ErroSql){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
