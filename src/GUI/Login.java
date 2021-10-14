package GUI;

import Main.Classe.DAO.*;
import Main.Classe.*;
import Main.Classe.Implements.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;


public class Login extends JFrame{
    
    private static JLabel email_utilisateur;
    private static JTextField email_texte;
    private static JLabel mdp_utilisateur;
    private static JButton Connecte;
    private static JLabel message;
    private static JPasswordField mdp_texte;
   
    Login() 
    {  

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        UtilisateurImp utilisateur = new UtilisateurImp();
       
        this.setSize(400,200);
        this.setTitle("Connexion à l'hyperplanning :");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panneau= new JPanel();
        panneau.setLayout(null);
        email_utilisateur = new JLabel("Adresse mail :");
        email_utilisateur.setBounds(15, 20,100,30);
        panneau.add(email_utilisateur); 
        
        mdp_utilisateur = new JLabel("Mot De Passe");
        mdp_utilisateur.setBounds(15,50,100,30);
        panneau.add(mdp_utilisateur);
        
        email_texte = new JTextField(20);
        email_texte.setBounds(110,20,180,25);
        panneau.add(email_texte);
        mdp_texte = new JPasswordField(20);
        mdp_texte.setBounds(110,50,180,25);
        panneau.add(mdp_texte);
        
        Connecte = new JButton("Connexion");
        Connecte.setBounds(160,90,120,25);
        panneau.add(Connecte);
        
        message = new JLabel("");
        message.setBounds(11,110,450,25);
        panneau.add(message);
        this.add(panneau);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
  
        
        Connecte.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {     
                 try
                {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hyperplanning","root","");
            
            String sql = "SELECT * FROM utilisateur WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email_texte.getText());
            statement.setString(2, mdp_texte.getText());
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next())
            {
                utilisateur.setDroit(resultSet.getInt("droit"));
                int droit = utilisateur.getDroit();
                System.out.println(droit);
                message.setText("Connexion réussie !");
                Accès(droit);
                dispose();
            }
            else
            {
                message.setText("Connexion impossible !");
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }       
        }
     }
     );

 }
    public void Accès(int droit){
        if(droit == 1)
        {
            Administrateur();
        }
        else if(droit == 2)
        {
            Referant();
        }
        else if(droit == 3)
        {
            ProfEtudiant();
        }
        else if(droit == 4)
        {
            ProfEtudiant();
        }
    }
    
    public JFrame Administrateur() {
            JPanel pane = new JPanel();    
            //Creation de la fenêtre
            JFrame fen = new JFrame();
            fen.setTitle("Emploi du Temps");
            pane.setLayout(new GridLayout(5, 5));
          
            fen.setSize(900,650);
            fen.setLocationRelativeTo(null);
            fen.setVisible(true);    
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
            //Création des boutons 
            JButton ajouter = new JButton("AJOUTER");     
            JButton modifier = new JButton("MODIFIER");            
            JButton supprimer = new JButton("SUPPRIMER");            
            JButton rechercher = new JButton("RECHERCHER");
            JButton calendrier = new JButton("EMPLOI DU TEMPS");
            
            //Ajout des boutons dans la fenetre
            pane.add(ajouter);
            pane.add(modifier);
            pane.add(supprimer);
            pane.add(rechercher);
            pane.add(calendrier);
            fen.add(pane);
            //Fonction des boutons
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
            
            calendrier.addActionListener(new ActionListener() 
            {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new CalendrierGUI();				
            }          
            });
            return fen;
    }
    
    public JFrame Referant(){
            JPanel pane = new JPanel();    
            //Creation de la fenêtre
            JFrame fen = new JFrame();
            fen.setTitle("Emploi du Temps");
            pane.setLayout(new GridLayout(5, 5));
          
        
            fen.setSize(900,650);
            fen.setLocationRelativeTo(null);
            fen.setVisible(true);    
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            JButton rechercher2 = new JButton("RECHERCHER");
            JButton calendrier2 = new JButton("EMPLOI DU TEMPS");
            
            pane.add(rechercher2);
            pane.add(calendrier2);
            fen.add(pane);
            rechercher2.addActionListener(new ActionListener() 
            {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new RechercherGUI();				
            }          
            });
            
            calendrier2.addActionListener(new ActionListener() 
            {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new CalendrierGUI();				
            }          
            });
            return fen;
    }
    
    public JFrame ProfEtudiant(){
            
            JPanel pane = new JPanel();    
            //Creation de la fenêtre
            JFrame fen = new JFrame();
            fen.setTitle("Emploi du Temps");
            pane.setLayout(new GridLayout(5, 5));
           
            fen.setSize(900,650);
            fen.setLocationRelativeTo(null);
            fen.setVisible(true);    
            fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            JButton calendrier3 = new JButton("EMPLOI DU TEMPS");
            
            pane.add(calendrier3);
            fen.add(pane);
            calendrier3.addActionListener(new ActionListener() 
            {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new CalendrierGUI();				
            }          
            });
            return fen;
    }
    public static void main(String[] args){
        new Login();
    }
}