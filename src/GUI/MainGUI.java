
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import Main.Classe.Implements.*;
import Main.Classe.DAO.*;

public class MainGUI extends JFrame
{
    MainGUI()
    {    
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 5));

        this.setTitle("Emploi du Temps");
        
        //JButtons
        JButton ajouter = new JButton("AJOUTER");     
        JButton modifier = new JButton("MODIFIER");            
        JButton supprimer = new JButton("SUPPRIMER");            
        JButton rechercher = new JButton("RECHERCHER");    
        
        //JLabels
        JLabel titre = new JLabel();		
        titre.setText("CHOISIR UNE OPTION");
        titre.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(titre);

        pane.add(ajouter);
        pane.add(modifier);
        pane.add(supprimer);
        pane.add(rechercher);

        this.setSize(900,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        ajouter.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new AjouterGUI();				
            }          
        });
        
        modifier.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new ModifierGUI();				
            }          
        });
        
        supprimer.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new SupprimerGUI();				
            }          
        });
        
        rechercher.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new RechercherGUI();				
            }          
        });
    }         


    public static void main(String[] args) 
    {    
        new MainGUI();    
    }    
 }