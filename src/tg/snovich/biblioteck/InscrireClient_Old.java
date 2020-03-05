/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.snovich.biblioteck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar.Separator;
import tg.snovich.classes.Biblioteck;
import tg.snovich.modeles_tables.ModeleClient;

/**
 *
 * @author Spartanovich_117
 */
public class InscrireClient_Old extends JFrame {
    InscrireClient_Old() {
        JPanel main_panel = new JPanel();
        JPanel middle_panel = new JPanel();
        JPanel first_panel = new JPanel();
        JPanel left_panel = new JPanel();
        JPanel right_panel = new JPanel();  
        JLabel nom_label = new JLabel("Nom");
        JLabel prenom_label = new JLabel("Prénom");
        JLabel telephone_label = new JLabel("Téléphone");
        JLabel numero_compte_label = new JLabel("N° Client");
        JLabel mot_de_passe_label = new JLabel("Mot de passe");
        JButton ajouter_btn = new JButton("Ajouter");
        JButton modifier_btn = new JButton("Modifier");
        JButton supprimer_btn = new JButton("Supprimer");
        JTextField nom_tf = new JTextField();
        JTextField prenom_tf = new JTextField();
        JTextField telephone_tf = new JTextField();
        JPasswordField mot_de_passe_pf = new JPasswordField();
        JTextField numero_compte_tf = new JTextField();
        Separator separateur = new Separator();
        JScrollPane scroll_pane = new JScrollPane();
        JLabel empty_label_1 = new JLabel();
        JLabel empty_label_2 = new JLabel();
        JLabel empty_label_3 = new JLabel();
        JLabel empty_label_4 = new JLabel();
        JLabel empty_label_5 = new JLabel();
        JLabel main_title_label = new JLabel("BIBLIOTECK");
        JTable tableau_clients = new JTable(new ModeleClient()); 
        
        initFrame();
        
        feed_First_Panel(first_panel, main_title_label);
        feed_Left_Panel(left_panel, nom_label, empty_label_1, nom_tf, prenom_label, empty_label_2, prenom_tf, telephone_label, empty_label_3, telephone_tf, numero_compte_label, empty_label_4, numero_compte_tf, mot_de_passe_label, empty_label_5, mot_de_passe_pf, ajouter_btn, modifier_btn, supprimer_btn);     
        feed_Right_Panel(right_panel, tableau_clients); 
        feed_Middle_Panel(middle_panel, left_panel, right_panel);        
        feed_Main_Panel(main_panel, first_panel, middle_panel); 
        
        this.getContentPane().add(main_panel);
        
        ajouter_btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                right_panel.removeAll();
                right_panel.validate();
                String return_message = Biblioteck.inscrireClient(nom_tf.getText(), prenom_tf.getText(), telephone_tf.getText(), numero_compte_tf.getText(), mot_de_passe_pf.getText());
                if(return_message != "N/A")
                    JOptionPane.showMessageDialog(rootPane, return_message);
                else
                    JOptionPane.showMessageDialog(rootPane, "Client enregistré !!!");
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
    }
    
    public void mouseClicked(MouseEvent event) {
        System.out.println("Spartan_117");
    }

    private void feed_Main_Panel(JPanel main_panel, JPanel first_panel, JPanel middle_panel) {
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.PAGE_AXIS));
        main_panel.add(first_panel);
        main_panel.add(middle_panel);
    }

    private void feed_First_Panel(JPanel first_panel, JLabel main_title_label) {
        first_panel.setLayout(new BoxLayout(first_panel, BoxLayout.LINE_AXIS));
        first_panel.add(main_title_label);
    }

    private void feed_Middle_Panel(JPanel middle_panel, JPanel left_panel, JPanel right_panel) {
        middle_panel.setLayout(new BoxLayout(middle_panel, BoxLayout.LINE_AXIS));
        middle_panel.add(left_panel);
        middle_panel.add(right_panel);
    }

    private void feed_Right_Panel(JPanel right_panel, JTable tableau_clients) {
        right_panel.setLayout(new BoxLayout(right_panel, BoxLayout.LINE_AXIS));
        right_panel.add(new JScrollPane(tableau_clients), BorderLayout.CENTER);
    }

    private void feed_Left_Panel(JPanel left_panel, JLabel nom_label, JLabel empty_label_1, JTextField nom_tf, JLabel prenom_label, JLabel empty_label_2, JTextField prenom_tf, JLabel telephone_label, JLabel empty_label_3, JTextField telephone_tf, JLabel numero_compte_label, JLabel empty_label_4, JTextField numero_compte_tf, JLabel mot_de_passe_label, JLabel empty_label_5, JPasswordField mot_de_passe_pf, JButton ajouter_btn, JButton modifier_btn, JButton supprimer_btn) {
        left_panel.setLayout(new GridLayout(6, 3));
        left_panel.add(nom_label);
        left_panel.add(empty_label_1);
        left_panel.add(nom_tf);
        
        left_panel.add(prenom_label);
        left_panel.add(empty_label_2);
        left_panel.add(prenom_tf);
        
        left_panel.add(telephone_label);
        left_panel.add(empty_label_3);
        left_panel.add(telephone_tf);
        
        left_panel.add(numero_compte_label);
        left_panel.add(empty_label_4);
        left_panel.add(numero_compte_tf);
        
        left_panel.add(mot_de_passe_label);
        left_panel.add(empty_label_5);
        left_panel.add(mot_de_passe_pf);
        
        left_panel.add(ajouter_btn);
        left_panel.add(modifier_btn);
        left_panel.add(supprimer_btn);
    }

    private void initFrame() {
        this.setTitle("Inscrire Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 250);
        this.setLocationRelativeTo(null);
    }
    
    
    

    
    public static void main(String[] args) {
        new InscrireClient_Old().setVisible(true);
    }
}
