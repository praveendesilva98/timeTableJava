
package GUI;

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



public class SupprimerGUI extends JFrame
{
    SupprimerGUI()
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

        this.setTitle("Supprimer");
        
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
                JFrame f = new JFrame("Supprimer un Utilisateur");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer cet utilisateur ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                utilisateurDAO.delete(utilisateur, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        etudiantB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Etudiant");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer cet étudiant ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                etudiantDAO.delete(etudiant, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        enseignantB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Enseignant");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer cet enseignant ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                enseignantDAO.delete(enseignant, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        coursB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Cours");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer ce cours ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                coursDAO.delete(cours, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        type_coursB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Type de Cours");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer ce type de cours ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                coursDAO.delete(cours, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        groupeB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Groupe");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer ce groupe ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                groupeDAO.delete(groupe, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        promotionB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer une Promotion");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer cette promotion ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                promotionDAO.delete(promotion, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        siteB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Site");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer ce site ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                siteDAO.delete(site, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        salleB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer une Salle");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer cette salle ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                salleDAO.delete(salle, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
        seanceB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Supprimer un Séance");  
                JTextField idT; 
                JLabel idL, message;
                JButton valider = new JButton("SUPPRIMER");
                
                idT = new JTextField();  
                idT.setBounds(100, 50, 200,30);               
                
                idL = new JLabel("ID ");
                idL.setBounds(30, 50, 80, 30);
                
                valider.setBounds(150,150, 150,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(idT); 
                f.add(idL);  
                f.add(valider);
                            
                f.setSize(400,250);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);     
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        
                        JFrame confirm = new JFrame("Confirmation de la supression");
                        JLabel question;
                        JButton oui, non;
                        
                        question = new JLabel("Êtes-vous sûre de supprimer cette séance ?");
                        question.setBounds(80, 50, 300, 30);
                        
                        oui = new JButton("OUI");
                        oui.setBounds(120, 80, 80, 30);
                        
                        non = new JButton("NON");
                        non.setBounds(220, 80, 80, 30);
                        
                        confirm.add(oui);
                        confirm.add(non);
                        confirm.add(question);
                        
                        confirm.setSize(400,200);  
                        confirm.setLayout(null);  
                        confirm.setLocationRelativeTo(null);
                        confirm.setLocationRelativeTo(null);      
                        confirm.setVisible(true);

                        oui.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                seanceDAO.delete(seance, Integer.parseInt(idT.getText()));
                                confirm.dispose();
                            }
                            
                        });
                                
                        non.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                confirm.dispose();
                            }
                            
                        });
                    } 
                });
            }          
        });
        
    }         


    public static void main(String[] args) 
    {    
        new SupprimerGUI();    
    } 
}
