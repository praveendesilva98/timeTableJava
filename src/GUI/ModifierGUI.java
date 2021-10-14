
package GUI;

import java.awt.event.*;
import java.awt.*;   
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;

import Main.Classe.Implements.*;
import Main.Classe.DAO.*;
import Main.Classe.*;



public class ModifierGUI extends JFrame
{
    ModifierGUI()
    {    
        //Classes
        CoursImp cours = new CoursImp();
        CoursDAO coursDAO = new CoursDAO();
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        UtilisateurImp utilisateur = new UtilisateurImp();
        
        Enseignant enseignant = new Enseignant();
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        
        TypeCoursImp typeCours = new TypeCoursImp();
        TypeCoursDAO typeCoursDAO = new TypeCoursDAO();
        
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
        
        //Variables

        //Containers
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(11, 1));

        this.setTitle("Modifier");
        
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
                JFrame f = new JFrame("Modifier un Utilisateur");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                choix.add("PRENOM");  
                choix.add("EMAIL");  
                choix.add("PASSWORD");  
                choix.add("DROIT");
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            utilisateurDAO.update(utilisateur, Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                            message.setText("L'utilisateur est modifié avec succèes");
                            
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
                JFrame f = new JFrame("Modifier un Etudiant");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                choix.add("PRENOM");  
                choix.add("EMAIL");  
                choix.add("PASSWORD");  
                choix.add("NUMERO");
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            if(choix.getItem(choix.getSelectedIndex()) == "NUMERO")
                            {
                                etudiantDAO.updateNumeroEtudiant(etudiant,Integer.parseInt(idT.getText()), Integer.parseInt(valueT.getText()));
                                message.setText("L'étudiant est modifié avec succès");
                            }
                            else
                            {
                                etudiantDAO.update(etudiant,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                                message.setText("L'étudiant est modifié avec succèes");
                            }
                            
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
                JFrame f = new JFrame("Modifier un Enseignant");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                choix.add("PRENOM");  
                choix.add("EMAIL");  
                choix.add("PASSWORD");  
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            enseignantDAO.update(enseignant,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                            message.setText("L'enseignant est modifié avec succèes");
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
                JFrame f = new JFrame("Modifier un Cours");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            coursDAO.update(cours,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                            message.setText("Le cours est modifié avec succèes");
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
                JFrame f = new JFrame("Modifier un Utilisateur");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            utilisateurDAO.update(utilisateur,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                            message.setText("Le type de cours est modifié avec succèes");
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
                JFrame f = new JFrame("Modifier un Utilisateur");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                choix.add("ID PROMO");
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            if(choix.getItem(choix.getSelectedIndex()) == "ID PROMO")
                            {
                                groupeDAO.update(groupe,Integer.parseInt(idT.getText()) , "id_promo", valueT.getText());
                                message.setText("Le groupe est modifié avec succèes");
                            }
                            else
                            {
                                groupeDAO.update(groupe,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                                message.setText("Le groupe est modifié avec succèes");
                            }
                            
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
                JFrame f = new JFrame("Modifier une Promotion");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            promotionDAO.update(promotion,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                            message.setText("La promotion est modifiée avec succèes");
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
                JFrame f = new JFrame("Modifier un Site");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            siteDAO.update(site, Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                            message.setText("Le site est modifié avec succèes");
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
                JFrame f = new JFrame("Modifier une Salle");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 75,75);  
                choix.add("NOM");  
                choix.add("CAPACITE"); 
                choix.add("ID SITE"); 
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            if(choix.getItem(choix.getSelectedIndex()) == "NOM")
                            {
                                utilisateurDAO.update(utilisateur,Integer.parseInt(idT.getText()) , "nom_salle", valueT.getText());
                                message.setText("La salle est modifié avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "ID SITE")
                            {
                                utilisateurDAO.update(utilisateur,Integer.parseInt(idT.getText()) , "id_site", valueT.getText());
                                message.setText("La salle est modifié avec succèes"); 
                            }
                            else
                            {
                                utilisateurDAO.update(utilisateur,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                                message.setText("La salle est modifié avec succèes"); 
                            }
                            
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
                JFrame f = new JFrame("Modifier un Utilisateur");  
                JButton valider = new JButton("MODIFIER");
                JTextField idT, valueT;
                JLabel message, idL;

                message = new JLabel();
                message.setBounds(50, 50, 300, 30);
                
                Choice choix = new Choice();  
                choix.setBounds(50,150, 95, 75);  
                choix.add("SEMAINE");  
                choix.add("DATE");  
                choix.add("HEURE DEBUT");  
                choix.add("HEURE FIN");  
                choix.add("ETAT");
                choix.add("ID COURS");  
                choix.add("ID TYPE");  
                choix.add("ID ENSEIGNANT");  
                choix.add("ID GROUPE");  
                choix.add("ID SALLE");
                
                idT = new JTextField();
                idT.setBounds(150, 100, 300, 30);
                valueT = new JTextField();
                valueT.setBounds(150, 150, 300, 30);
                
                idL = new JLabel("ID ");
                idL.setBounds(50, 100, 80, 30);
                
                valider.setBounds(180, 200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT);
                f.add(choix);
                f.add(valueT);
                f.add(valider);
                f.add(message);
                f.add(idL);
                            
                f.setSize(550,300);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {  
                        if(Integer.parseInt(idT.getText()) == 0)
                        {
                            message.setText("Veuillez insérer la valeur d'ID");
                        }
                        else
                        {
                            if(choix.getItem(choix.getSelectedIndex()) == "HEURE DEBUT")
                            {
                                seanceDAO.update(seance,Integer.parseInt(idT.getText()) , "heure_debut", valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "HEURE FIN")
                            {
                                seanceDAO.update(seance,Integer.parseInt(idT.getText()) , "heure_fin", valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "ID COURS")
                            {
                                seanceDAO.update(seance,Integer.parseInt(idT.getText()) , "id_cours", valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "ID TYPE")
                            {
                                seanceDAO.update(seance,Integer.parseInt(idT.getText()) , "id_type", valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "ID ENSEIGNANT")
                            {
                                seanceDAO.updateEnseignant(seance,Integer.parseInt(idT.getText()) , valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "ID GROUPE")
                            {
                                seanceDAO.updateGroupe(seance, Integer.parseInt(idT.getText()) , valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else if(choix.getItem(choix.getSelectedIndex()) == "ID SALLE")
                            {
                                seanceDAO.updateSalle(seance,Integer.parseInt(idT.getText()) , valueT.getText());
                                message.setText("La séance est modifiée avec succèes"); 
                            }
                            else
                            {
                                seanceDAO.update(seance,Integer.parseInt(idT.getText()) , choix.getItem(choix.getSelectedIndex()).toLowerCase(), valueT.getText());
                                message.setText("L'utilisateur est modifié avec succèes");
                            }
                            
                        }    
                        
                    } 
                });
            }          
        });
    }         


    public static void main(String[] args) 
    {    
        new ModifierGUI();    
    } 
}
