package GUI;


import java.awt.*;
import javax.swing.*;
import Main.Classe.DAO.*;
import Main.Classe.Implements.*;
import Main.Classe.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;

public class CalendrierGUI extends JFrame
{
    private ArrayList<String> nom_jour = new ArrayList<String>(7);
    private ArrayList<String> heure_debut_cours = new ArrayList<String>(7);
    
    private JLabel premier_case;
    
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
    
    private JPanel pan = new JPanel();      
    
    JButton button = new JButton();
    JLabel nomCours, nomProf, nomSalle;
     
    CalendrierGUI() 
    {
        this.setTitle("Emploi du temps");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan.setLayout(new GridBagLayout());
        GridBagConstraints grille = new GridBagConstraints();
       
        nom_jour.add("2020-06-08");
        nom_jour.add("2020-06-09");
        nom_jour.add("2020-06-10");
        nom_jour.add("2020-06-11");
        nom_jour.add("2020-06-12");
        nom_jour.add("2020-06-13");
        nom_jour.add("2020-06-14");
        
        heure_debut_cours.add("08h30");
        heure_debut_cours.add("10h15");
        heure_debut_cours.add("12h00");
        heure_debut_cours.add("13h45");
        heure_debut_cours.add("15h30");
        heure_debut_cours.add("17h15");
        heure_debut_cours.add("19h00");
         
        
        premier_case = new JLabel("SEMAINE 24");
        premier_case.setPreferredSize(new Dimension(150, 90));
        grille.weightx = 0.5;
        grille.weighty = 0.5;
        grille.gridx = 0;
        grille.gridy = 0;
        pan.add(premier_case, grille);

        for(int i=1; i<nom_jour.size(); i++)
        {
            JLabel jour = new JLabel(nom_jour.get(i-1), JLabel.CENTER);
            jour.setPreferredSize(new Dimension(150, 90));
            grille.weightx = 0.5;
            grille.weighty = 0.5;
            grille.gridx = i;
            grille.gridy = 0;
            pan.add(jour, grille);

        }   

        for(int i=1; i<heure_debut_cours.size(); i++)
        {
            JLabel jour = new JLabel(heure_debut_cours.get(i-1), JLabel.CENTER);
            jour.setPreferredSize(new Dimension(150, 90));
            grille.weightx = 0.5;
            grille.weighty = 0.5;
            grille.gridx = 0;
            grille.gridy = i;
            pan.add(jour, grille);

        } 
        
        for(int i=1; i<8; i++)
        {
            for(int j=1; j<7; j++)
            {
                try
                {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hyperplanning","root","");

                    String sql = "SELECT * FROM seance WHERE id_seance = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, 9);
                    ResultSet resultSet = statement.executeQuery();

                    while(resultSet.next())
                    {
                        seance.setIdSeance(resultSet.getInt("id_seance"));
                        seance.setIdCours(resultSet.getInt("id_cours"));
                        seance.setIdTypeCours(resultSet.getInt("id_type"));
                        seance.setSemaine(resultSet.getInt("semaine"));
                        seance.setDate(resultSet.getString("date"));
                        seance.setHeureDebut(resultSet.getString("heure_debut"));
                        seance.setHeureFin(resultSet.getString("heure_fin"));
                        seance.setEtat(resultSet.getString("etat"));

                        int id_seance = seance.getIdSeance();
                        int id_cours = seance.getIdCours();
                        int id_type = seance.getIdTypeCours();
                        int semaine = seance.getSemaine();
                        String date = seance.getDate();
                        String heure_debut = seance.getHeureDebut();
                        String heure_fin = seance.getHeureFin();
                        String etat = seance.getEtat();

                        String sql2 = "SELECT * FROM cours WHERE id = ?";
                        PreparedStatement statement2 = connection.prepareStatement(sql2);
                        statement2.setInt(1, id_cours);
                        ResultSet resultSet2 = statement2.executeQuery();

                        while(resultSet2.next())
                        {
                            cours.setNomCours(resultSet2.getString("nom"));
                            String nom_cours = cours.getNomCours();

                            String sql3 = "SELECT * FROM type_cours WHERE id = ?";
                            PreparedStatement statement3 = connection.prepareStatement(sql3);
                            statement3.setInt(1, id_type);
                            ResultSet resultSet3 = statement3.executeQuery();

                            while(resultSet3.next())
                            {
                                seance.setNomTypeCours(resultSet3.getString("nom"));
                                String nom_type = seance.getNomTypeCours();

                                String sql4 = "SELECT * FROM seance_enseignant WHERE id_seance = ?";
                                PreparedStatement statement4 = connection.prepareStatement(sql4);
                                statement4.setInt(1, id_seance);
                                ResultSet resultSet4 = statement4.executeQuery();

                                while(resultSet4.next())
                                {
                                    seanceEnseignant.setIdUtilisateur(resultSet4.getInt("id_enseignant"));
                                    int id_enseignant = seanceEnseignant.getIdUtilisateur();

                                    String sql5 = "SELECT * FROM seance_groupe WHERE id_seance = ?";
                                    PreparedStatement statement5 = connection.prepareStatement(sql5);
                                    statement5.setInt(1, id_seance);
                                    ResultSet resultSet5 = statement5.executeQuery();

                                    while(resultSet5.next())
                                    {
                                        seanceGroupe.setIdGroupe(resultSet5.getInt("id_groupe"));
                                        int id_groupe = seanceGroupe.getIdGroupe();

                                        String sql6 = "SELECT * FROM seance_salle WHERE id_seance = ?";
                                        PreparedStatement statement6 = connection.prepareStatement(sql6);
                                        statement6.setInt(1, id_seance);
                                        ResultSet resultSet6 = statement6.executeQuery();

                                        while(resultSet6.next())
                                        {
                                            seanceSalle.setIdSalle(resultSet6.getInt("id_salle"));
                                            int id_salle = seanceSalle.getIdSalle();

                                            String sql7 = "SELECT * FROM utilisateur WHERE id = ?";
                                            PreparedStatement statement7 = connection.prepareStatement(sql7);
                                            statement7.setInt(1, id_enseignant);
                                            ResultSet resultSet7 = statement7.executeQuery();

                                            while(resultSet7.next())
                                            {
                                                seanceEnseignant.setNom(resultSet7.getString("nom"));
                                                seanceEnseignant.setPrenom(resultSet7.getString("prenom"));
                                                String nom_enseignant = seanceEnseignant.getNom();
                                                String prenom_enseignant = seanceEnseignant.getPrenom();

                                                String sql8 = "SELECT * FROM groupe WHERE id = ?";
                                                PreparedStatement statement8 = connection.prepareStatement(sql8);
                                                statement8.setInt(1, id_groupe);
                                                ResultSet resultSet8 = statement8.executeQuery();

                                                while(resultSet8.next())
                                                {
                                                    seanceGroupe.setNomGroupe(resultSet8.getString("nom"));
                                                    String nom_groupe = seanceGroupe.getNomGroupe();

                                                    String sql9 = "SELECT * FROM salle WHERE id_salle = ?";
                                                    PreparedStatement statement9 = connection.prepareStatement(sql9);
                                                    statement9.setInt(1, id_salle);
                                                    ResultSet resultSet9 = statement9.executeQuery();

                                                    while(resultSet9.next())
                                                    {
                                                        seanceSalle.setNomSalle(resultSet9.getString("nom_salle"));
                                                        String nom_salle = seanceSalle.getNomSalle();

                                                        
                                                        String sql1 = "SELECT COUNT(*) FROM seance WHERE semaine = ?";
                                                        PreparedStatement statement1 = connection.prepareStatement(sql1);
                                                        statement1.setInt(1, 24);
                                                        ResultSet resultSet1 = statement1.executeQuery();                

                                                        while(resultSet1.next())
                                                        {
                                                            int l = 0;
                                                            int m = 0;
                                                            int count = resultSet1.getInt(1);

                                                            if(heure_debut_cours.contains("12h00") && nom_jour.contains("2020-06-08"))
                                                            {
                                                                l = 1;
                                                                m = 3;
                                                            }

                                                            if(heure_debut_cours.contains("13h45") && nom_jour.contains("2020-06-09"))
                                                            {
                                                                l = 2;
                                                                m = 4;
 
                                                            } 

                                                            if(heure_debut_cours.contains("08h30") && nom_jour.contains("2020-06-10"))
                                                            {
                                                                l = 3;
                                                                m = 1;
                                                                
                                                            }
                                                            
                                                            nomCours = new JLabel(nom_cours, JLabel.CENTER);
                                                            nomProf = new JLabel(nom_enseignant, JLabel.CENTER);
                                                            nomSalle = new JLabel(nom_salle, JLabel.CENTER);

                                                            String str ="<html>" + nom_cours + "<br>" + nom_enseignant +" "+ prenom_enseignant+"<br>"+nom_salle+"</html>";
                                                            button.setBackground(Color.yellow);
                                                            button = new JButton(str);
                                                            button.setPreferredSize(new Dimension(150, 90));
                                                            grille.weightx = 0.5;
                                                            grille.weighty = 0.5;
                                                            grille.gridx = l;
                                                            grille.gridy = m;
                                                            pan.add(button, grille);

                                                        }   
                                                    }
                                                }

                                            }


                                        }
                                    }

                                }
                            } 

                        }
                    }

                }
                catch(SQLException e)
                {
                    e.printStackTrace();

                }

                
            }
            

        }

         
        for(int i=1; i<nom_jour.size(); i++)
        {
            JLabel jour = new JLabel(nom_jour.get(i-1), JLabel.CENTER);
            jour.setPreferredSize(new Dimension(150, 90));
            grille.weightx = 0.5;
            grille.weighty = 0.5;
            grille.gridx = i;
            grille.gridy = 0;
            pan.add(jour, grille);

        }       
        
        this.add(pan);
     
        this.setVisible(true);
    }

    public static void main(String[] args) 
    {
        new CalendrierGUI();
    }
    

   
}
