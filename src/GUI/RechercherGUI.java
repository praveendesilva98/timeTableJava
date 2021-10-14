
package GUI;

import java.awt.*;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;

import Main.Classe.Implements.*;
import Main.Classe.DAO.*;
import Main.Classe.*;



public class RechercherGUI extends JFrame
{
    RechercherGUI()
    {    
        //Classes
        CoursImp cours = new CoursImp();
        CoursDAO coursDAO = new CoursDAO();
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        UtilisateurImp utilisateur = new UtilisateurImp();
        
        Enseignant enseignant = new Enseignant();
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        
        TypeCoursImp type = new TypeCoursImp();
        TypeCoursDAO typeCours = new TypeCoursDAO();
        
        PromotionImp promotion = new PromotionImp();
        PromotionDAO promotionDAO = new PromotionDAO();
        
        GroupeImp groupe = new GroupeImp();
        GroupeDAO groupeDAO = new GroupeDAO();
        
        Etudiant etudiant = new Etudiant();
        EtudiantDAO etudiantDAO = new EtudiantDAO();
        
        SiteImp site = new SiteImp();
        SiteDAO siteDAO = new SiteDAO();
        
        SalleImp salle = new SalleImp();
        SalleDAO salleDAO = new SalleDAO();
        
        SeanceDAO seanceDAO = new SeanceDAO();
        SeanceImp seance = new SeanceImp();
        
        SeanceGroupe seanceGroupe = new SeanceGroupe();
        SeanceEnseignant seanceEnseignant = new SeanceEnseignant();
        SeanceSalle seanceSalle = new SeanceSalle();

        //Containers
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(11, 1));

        this.setTitle("Rechercher");
        
        //JButtons
        JButton utilisateurB = new JButton("UTILISATEUR");             
        JButton etudiantB = new JButton("ETUDIANT");           
        JButton enseignantB = new JButton("ENSEIGNANT");           
        JButton coursB = new JButton("COURS");        
        JButton type_coursB = new JButton("TYPE DE COURS");         
        JButton groupeB = new JButton("GROUPE");           
        JButton seanceB = new JButton("SEANCE");          
        JButton siteB = new JButton("SITE");          
        JButton salleB = new JButton("SALLE");           
        JButton promotionB = new JButton("PROMOTION");   
        
        //JLabels
        JLabel titre = new JLabel();		
        titre.setText("CHOISIR UNE OPTION");
        titre.setHorizontalAlignment(JLabel.CENTER);

        this.add(titre);

        pane.add(utilisateurB);
        pane.add(etudiantB);
        pane.add(enseignantB);
        pane.add(coursB);
        pane.add(type_coursB);
        pane.add(groupeB);
        pane.add(promotionB);
        pane.add(siteB);
        pane.add(salleB);
        pane.add(seanceB);

        
        this.setSize(800,600);  
        this.setLocationRelativeTo(null);
        this.setVisible(true);     

        utilisateurB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un Utilisateur");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                choix.add("PRENOM");
                choix.add("EMAIL");
                choix.add("PASSWORD");
                choix.add("DROIT");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            utilisateurDAO.getById(utilisateur, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            utilisateurDAO.getByString(utilisateur, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        etudiantB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un Etudiant");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                choix.add("PRENOM");
                choix.add("EMAIL");
                choix.add("PASSWORD");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            etudiantDAO.getById(etudiant, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            etudiantDAO.getByString(etudiant, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        enseignantB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un Enseignant");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                choix.add("PRENOM");
                choix.add("EMAIL");
                choix.add("PASSWORD");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            enseignantDAO.getById(enseignant, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            enseignantDAO.getByString(enseignant, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        coursB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un Cours");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            coursDAO.getById(cours, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            coursDAO.getByString(cours, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        type_coursB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un type de cours");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            typeCours.getById(type, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            typeCours.getByString(type, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        groupeB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un groupe");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                choix.add("ID_PROMO");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            groupeDAO.getById(groupe, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            groupeDAO.getByString(groupe, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        promotionB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher une promotion");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM_PROMOTION");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            promotionDAO.getById(promotion, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            promotionDAO.getByString(promotion, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        siteB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher un site");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID");
                choix.add("NOM");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            siteDAO.getById(site, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            siteDAO.getByString(site, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
       
        salleB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher une salle");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(30, 50, 100, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(150, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID_SALLE");
                choix.add("NOM_SALLE");
                choix.add("CAPACITE");
                choix.add("ID_SITE");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(800,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID")
                        {
                            salleDAO.getById(salle, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            salleDAO.getByString(salle, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
        seanceB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Rechercher une salle");  
                JTextField valueT; 
                JLabel message;
                
                JButton valider = new JButton("RECHERCHER");
                Choice choix = new Choice();
                choix.setBounds(20, 50, 150, 30);
                
                valueT = new JTextField();  
                valueT.setBounds(200, 50, 200,30);               

                
                message = new JLabel();
                message.setBounds(30, 150, 2600, 30);
                
                choix.add("ID_SEANCE");
                choix.add("NOM COURS");
                choix.add("SEMAINE");
                choix.add("DATE");
                choix.add("HEURE_DEBUT");
                choix.add("HEURE_FIN");
                choix.add("ETAT");
                choix.add("ID_ENSEIGNANT");
                choix.add("ID_GROUPE");
                choix.add("ID_SALLE");
                choix.add("ID_TYPE");
                
                valider.setBounds(150, 100, 100, 40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(valueT); 
                f.add(message);
                f.add(choix);
                f.add(valider);
                            
                f.setSize(1200,750);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(choix.getItem(choix.getSelectedIndex()) == "ID_SEANCE")
                        {
                            seanceDAO.getById(seance, Integer.parseInt(valueT.getText()), message);
                            message.getText();
                        }
                        else
                        {
                            seanceDAO.getByString(seance, choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText(), message);
                            message.getText(); 
                        }
                    } 
                });
            }          
        });
        
    }         


    public static void main(String[] args) 
    {    
        new RechercherGUI();    
    } 
}
