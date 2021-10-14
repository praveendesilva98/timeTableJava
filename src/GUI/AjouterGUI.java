
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



public class AjouterGUI extends JFrame
{
    AjouterGUI()
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

        this.setTitle("Ajouter");
        
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
                JFrame f = new JFrame("Ajouter un Utilisateur");  
                JTextField nomT, prenomT, emailT, passwordT, droitT; 
                JLabel nomL, prenomL, emailL, passwordL, droitL, message;
                JButton valider = new JButton("AJOUTER");
                
                nomT = new JTextField();  
                nomT.setBounds(150,100, 200,30);               
                prenomT = new JTextField();  
                prenomT.setBounds(150,150, 200,30);                 
                emailT = new JTextField();  
                emailT.setBounds(150,200, 200,30); 
                passwordT = new JTextField();  
                passwordT.setBounds(150,250, 200,30);                 
                droitT = new JTextField();  
                droitT.setBounds(150,300, 200,30); 
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nomL = new JLabel("Nom ");
                nomL.setBounds(30, 100, 80, 30);
                prenomL = new JLabel("Prenom ");
                prenomL.setBounds(30, 150, 80, 30);
                emailL = new JLabel("Email ");
                emailL.setBounds(30, 200, 80, 30);
                passwordL = new JLabel("Mot de Passe ");
                passwordL.setBounds(30, 250, 100, 30);
                droitL = new JLabel("Droit ");
                droitL.setBounds(30, 300, 80, 30);
                
                
                valider.setBounds(150,350, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nomT); 
                f.add(prenomT);  
                f.add(emailT);
                f.add(passwordT);
                f.add(droitT);
                
                f.add(nomL);
                f.add(prenomL);
                f.add(emailL);
                f.add(passwordL);
                f.add(droitL);
                f.add(message);
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);      
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        utilisateur.setNom(nomT.getText());
                        utilisateur.setPrenom(prenomT.getText());
                        utilisateur.setEmail(emailT.getText());
                        utilisateur.setPassword(passwordT.getText());
                        utilisateur.setDroit(Integer.parseInt(droitT.getText()));
                        
                        utilisateurDAO.add(utilisateur);
                        
                        message.setText("L'utilisateur est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        etudiantB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter un Etudiant");  
                JTextField nomT, prenomT, emailT, passwordT, numeroT, id_groupeT; 
                JLabel nomL, prenomL, emailL, passwordL, numeroL, id_groupeL, message;
                JButton valider = new JButton("AJOUTER");
                
                nomT = new JTextField();  
                nomT.setBounds(150,100, 200,30);               
                prenomT = new JTextField();  
                prenomT.setBounds(150,150, 200,30);                 
                emailT = new JTextField();  
                emailT.setBounds(150,200, 200,30); 
                passwordT = new JTextField();  
                passwordT.setBounds(150,250, 200,30);    
                numeroT = new JTextField();  
                numeroT.setBounds(150,300, 200,30); 
                id_groupeT = new JTextField();  
                id_groupeT.setBounds(150,350, 200,30); 
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nomL = new JLabel("Nom ");
                nomL.setBounds(30, 100, 80, 30);
                prenomL = new JLabel("Prenom ");
                prenomL.setBounds(30, 150, 80, 30);
                emailL = new JLabel("Email ");
                emailL.setBounds(30, 200, 80, 30);
                passwordL = new JLabel("Mot de Passe ");
                passwordL.setBounds(30, 250, 100, 30);
                numeroL = new JLabel("Numéro ");
                numeroL.setBounds(30, 300, 80, 30);
                id_groupeL = new JLabel("ID Groupe ");
                id_groupeL.setBounds(30, 350, 100, 30);

                
                valider.setBounds(150,400, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nomT); 
                f.add(prenomT);  
                f.add(emailT);
                f.add(passwordT);
                f.add(numeroT);
                f.add(id_groupeT);
                
                f.add(nomL);
                f.add(prenomL);
                f.add(emailL);
                f.add(passwordL);
                f.add(numeroL);
                f.add(id_groupeL);
                f.add(message);
                f.add(valider);
                            
                f.setSize(400,500);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        etudiant.setNom(nomT.getText());
                        etudiant.setPrenom(prenomT.getText());
                        etudiant.setEmail(emailT.getText());
                        etudiant.setPassword(passwordT.getText());
                        etudiant.setNumeroEtudiant(Integer.parseInt(numeroT.getText()));
                        etudiant.setIdGroupe(Integer.parseInt(id_groupeT.getText()));
                        
                        etudiantDAO.add(etudiant);
                        
                        message.setText("L'étudiant est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        enseignantB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter un Enseignant");  
                JTextField nomT, prenomT, emailT, passwordT, id_coursT; 
                JLabel nomL, prenomL, emailL, passwordL, id_coursL, message;
                JButton valider = new JButton("AJOUTER");
                
                nomT = new JTextField();  
                nomT.setBounds(150,100, 200,30);               
                prenomT = new JTextField();  
                prenomT.setBounds(150,150, 200,30);                 
                emailT = new JTextField();  
                emailT.setBounds(150,200, 200,30); 
                passwordT = new JTextField();  
                passwordT.setBounds(150,250, 200,30);                 
                id_coursT = new JTextField();  
                id_coursT.setBounds(150,300, 200,30); 
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nomL = new JLabel("Nom ");
                nomL.setBounds(30, 100, 80, 30);
                prenomL = new JLabel("Prenom ");
                prenomL.setBounds(30, 150, 80, 30);
                emailL = new JLabel("Email ");
                emailL.setBounds(30, 200, 80, 30);
                passwordL = new JLabel("Mot de Passe ");
                passwordL.setBounds(30, 250, 100, 30);
                id_coursL = new JLabel("ID Cours ");
                id_coursL.setBounds(30, 300, 80, 30);
                
                valider.setBounds(150,350, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nomT); 
                f.add(prenomT);  
                f.add(emailT);
                f.add(passwordT);
                f.add(id_coursT);
                
                f.add(nomL);
                f.add(prenomL);
                f.add(emailL);
                f.add(passwordL);
                f.add(id_coursL);
                f.add(message);
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        enseignant.setNom(nomT.getText());
                        enseignant.setPrenom(prenomT.getText());
                        enseignant.setEmail(emailT.getText());
                        enseignant.setPassword(passwordT.getText());
                        enseignant.setIdCours(Integer.parseInt(id_coursT.getText()));
                        
                        enseignantDAO.add(enseignant);
                        
                        message.setText("L'enseignant est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        coursB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter un Cours");  
                JTextField nom_coursT; 
                JLabel nom_coursL, message;
                JButton valider = new JButton("AJOUTER");
                
                nom_coursT = new JTextField();  
                nom_coursT.setBounds(150,100, 200,30);               
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nom_coursL = new JLabel("Nom Cours ");
                nom_coursL.setBounds(30, 100, 80, 30);
                
                valider.setBounds(150, 150, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nom_coursT);                 
                f.add(nom_coursL);
                f.add(message);
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null); 
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        cours.setNomCours(nom_coursT.getText());                        
                        coursDAO.add(cours);
                        
                        message.setText("Le cours est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        type_coursB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter un Type de Cours");  
                JTextField nom_type_coursT; 
                JLabel nom_type_coursL, message;
                JButton valider = new JButton("AJOUTER");
                
                nom_type_coursT = new JTextField();  
                nom_type_coursT.setBounds(150,100, 200,30);               
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nom_type_coursL = new JLabel("Nom Type Cours ");
                nom_type_coursL.setBounds(30, 100, 120, 30);
                
                valider.setBounds(150,150, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nom_type_coursT);                 
                f.add(nom_type_coursL);
                f.add(message);
                
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null); 
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        type.setNomTypeCours(nom_type_coursT.getText());                        
                        typeCours.add(type);
                        
                        message.setText("Le type de cours est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        
        groupeB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter un Groupe");  
                JTextField nom_groupeT, id_promoT; 
                JLabel nom_groupeL, id_promoL, message;
                JButton valider = new JButton("AJOUTER");
                
                nom_groupeT = new JTextField();  
                nom_groupeT.setBounds(150,100, 200,30);               
                id_promoT = new JTextField();  
                id_promoT.setBounds(150,150, 200,30);                 
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nom_groupeL = new JLabel("Nom Groupe ");
                nom_groupeL.setBounds(30, 100, 80, 30);
                id_promoL = new JLabel("ID Promo ");
                id_promoL.setBounds(30, 150, 80, 30);

                valider.setBounds(150,200, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nom_groupeT); 
                f.add(id_promoT);  
                
                f.add(nom_groupeL);
                f.add(id_promoL);
                f.add(message); 
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        groupe.setNomGroupe(nom_groupeT.getText());
                        groupe.setIdPromo(Integer.parseInt(id_promoT.getText()));
                        
                        groupeDAO.add(groupe);
                        
                        message.setText("Le groupe est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        promotionB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter une Promotion");  
                JTextField nom_promoT; 
                JLabel nom_promoL, message;
                JButton valider = new JButton("AJOUTER");
                
                nom_promoT = new JTextField();  
                nom_promoT.setBounds(150,100, 200,30);               
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nom_promoL = new JLabel("Nom Promotion ");
                nom_promoL.setBounds(30, 100, 120, 30);
                
                valider.setBounds(150,150, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(nom_promoT);                 
                f.add(nom_promoL);
                f.add(message);
                
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);  
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        promotion.setNomPromo(nom_promoT.getText());                        
                        promotionDAO.add(promotion);
                        
                        message.setText("La promotion est enregistré dans la base de donnée");
                    } 
                });
            }          
        });     
        
        siteB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter un Site");  
                JTextField nom_siteT; 
                JLabel nom_siteL, message;
                JButton valider = new JButton("AJOUTER");
                
                nom_siteT = new JTextField();  
                nom_siteT.setBounds(150,100, 200,30);               
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nom_siteL = new JLabel("Nom Site ");
                nom_siteL.setBounds(30, 100, 80, 30);
                
                valider.setBounds(150,150, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                f.add(message);
                f.add(nom_siteT);                 
                f.add(nom_siteL);

                
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null); 
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        site.setNomSite(nom_siteT.getText());                        
                        siteDAO.add(site);
                        
                        message.setText("Le site est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        salleB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter une Salle");  
                JTextField nom_salleT, capaciteT, id_siteT; 
                JLabel nom_salleL, capaciteL, id_siteL, message;
                JButton valider = new JButton("AJOUTER");
                
                nom_salleT = new JTextField();  
                nom_salleT.setBounds(150,100, 200,30);    
                capaciteT = new JTextField();  
                capaciteT.setBounds(150,150, 200,30);
                id_siteT = new JTextField();  
                id_siteT.setBounds(150,200, 200,30);
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                nom_salleL = new JLabel("Nom Salle ");
                nom_salleL.setBounds(30, 100, 80, 30);
                capaciteL = new JLabel("Capacite ");
                capaciteL.setBounds(30, 150, 80, 30);
                id_siteL = new JLabel("ID Site ");
                id_siteL.setBounds(30, 200, 80, 30);
                
                valider.setBounds(150,250, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(message);
                f.add(nom_salleT);                 
                f.add(capaciteL);
                f.add(id_siteT);                 
                f.add(nom_salleL);
                f.add(capaciteT);                 
                f.add(id_siteL);
                
                f.add(valider);
                            
                f.setSize(400,450);  
                f.setLayout(null);  
                f.setLocationRelativeTo(null);  
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        salle.setNomSalle(nom_salleT.getText());  
                        salle.setCapacite(Integer.parseInt(capaciteT.getText()));
                        salle.setIdSite(Integer.parseInt(id_siteT.getText()));
                        salleDAO.add(salle);
                                                
                        message.setText("La salle est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
        
        seanceB.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame f = new JFrame("Ajouter une Séance");  
                JTextField semaineT, dateT, heure_debutT, heure_finT, etatT, id_coursT, id_type_coursT, id_enseignantT, id_salleT, id_groupeT; 
                JLabel semaineL, dateL, heure_debutL, heure_finL, etatL, id_coursL, id_type_coursL, id_enseignantL, id_salleL, id_groupeL, message; 
                JButton valider = new JButton("AJOUTER");
                
                semaineT = new JTextField();  
                semaineT.setBounds(150,100, 200,30);               
                dateT = new JTextField();  
                dateT.setBounds(150,150, 200,30);                                
                etatT = new JTextField();  
                etatT.setBounds(150,300, 200,30); 
                id_coursT = new JTextField();  
                id_coursT.setBounds(150,350, 200,30); 
                id_type_coursT = new JTextField();  
                id_type_coursT.setBounds(150,400, 200,30); 
                id_enseignantT = new JTextField();  
                id_enseignantT.setBounds(150,450, 200,30); 
                id_groupeT = new JTextField();  
                id_groupeT.setBounds(150,500, 200,30); 
                id_salleT = new JTextField();  
                id_salleT.setBounds(150,550, 200,30); 
                
                message = new JLabel();
                message.setBounds(20, 50, 300, 30);
                semaineL = new JLabel("Semaine ");
                semaineL.setBounds(30, 100, 80, 30);
                dateL = new JLabel("Date ");
                dateL.setBounds(30, 150, 80, 30);
                heure_debutL = new JLabel("Heure Début ");
                heure_debutL.setBounds(30, 200, 80, 30);
                heure_finL = new JLabel("Heure Fin ");
                heure_finL.setBounds(30, 250, 100, 30);
                etatL = new JLabel("Etat ");
                etatL.setBounds(30, 300, 80, 30);
                id_coursL = new JLabel("ID Cours ");
                id_coursL.setBounds(30, 350, 120, 30);
                id_type_coursL = new JLabel("ID Type Cours ");
                id_type_coursL.setBounds(30, 400, 120, 30);
                id_enseignantL = new JLabel("ID Enseignant ");
                id_enseignantL.setBounds(30, 450, 120, 30);
                id_groupeL = new JLabel("ID Groupe ");
                id_groupeL.setBounds(30, 500, 120, 30);
                id_salleL = new JLabel("ID Salle ");
                id_salleL.setBounds(30, 550, 80, 30);
                
                Choice choixHeureDebut = new Choice();
                choixHeureDebut.setBounds(150,200, 200,30);
                choixHeureDebut.add("8h30");
                choixHeureDebut.add("10h15");
                choixHeureDebut.add("12h00");
                choixHeureDebut.add("13h45");
                choixHeureDebut.add("15h30");
                choixHeureDebut.add("17h15");
                choixHeureDebut.add("19h00");


                Choice choixHeureFin = new Choice();
                choixHeureFin.setBounds(150,250, 200,30);
                choixHeureFin.add("10h00");
                choixHeureFin.add("11h45");
                choixHeureFin.add("13h30");
                choixHeureFin.add("15h15");
                choixHeureFin.add("17h00");
                choixHeureFin.add("18h45");
                choixHeureFin.add("20h30");
                
                valider.setBounds(150,600, 100,40);
                valider.setHorizontalAlignment(JLabel.CENTER);
                
                f.add(semaineT); 
                f.add(dateT);  
                f.add(choixHeureDebut);
                f.add(choixHeureFin);
                f.add(etatT);
                f.add(id_coursT); 
                f.add(id_type_coursT);  
                f.add(id_enseignantT);
                f.add(id_groupeT);
                f.add(id_salleT);
                
                f.add(message);
                f.add(semaineL); 
                f.add(dateL);  
                f.add(heure_debutL);
                f.add(heure_finL);
                f.add(etatL);
                f.add(id_coursL); 
                f.add(id_type_coursL);  
                f.add(id_enseignantL);
                f.add(id_groupeL);
                f.add(id_salleL);
                
                f.add(valider);
                            
                f.setSize(500,800);  
                f.setLayout(null);                
                f.setLocationRelativeTo(null);
                f.setLocationRelativeTo(null);  
                f.setVisible(true);
                
                valider.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        seance.setSemaine(Integer.parseInt(semaineT.getText()));
                        seance.setDate(dateT.getText());
                        seance.setHeureDebut(choixHeureDebut.getItem(choixHeureDebut.getSelectedIndex()));
                        seance.setHeureFin(choixHeureFin.getItem(choixHeureFin.getSelectedIndex()));
                        seance.setEtat(etatT.getText());
                        seance.setIdCours(Integer.parseInt(id_coursT.getText()));
                        seance.setIdTypeCours(Integer.parseInt(id_type_coursT.getText()));
                        seanceGroupe.setIdGroupe(Integer.parseInt(id_groupeT.getText()));
                        seanceEnseignant.setIdUtilisateur(Integer.parseInt(id_enseignantT.getText()));
                        seanceSalle.setIdSalle(Integer.parseInt(id_salleT.getText()));
                        
                        seanceDAO.addSeance(seance, seanceGroupe, seanceEnseignant, seanceSalle);
                        
                        message.setText("La séance est enregistré dans la base de donnée");
                    } 
                });
            }          
        });
    }         


    public static void main(String[] args) 
    {    
        new AjouterGUI();    
    } 
}
