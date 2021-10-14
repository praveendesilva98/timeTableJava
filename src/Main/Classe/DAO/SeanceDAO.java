
package Main.Classe.DAO;

import java.sql.*;
import Main.Classe.Implements.SeanceImp;
import Main.Classe.Implements.TypeCoursImp;
import Main.Classe.Implements.CoursImp;
import Main.Classe.SeanceEnseignant;
import Main.Classe.SeanceGroupe;
import Main.Classe.SeanceSalle;
import javax.swing.JLabel;

public class SeanceDAO implements DAO<SeanceImp>
{
    private String url;
    private String user;
    private String password;
    
    CoursImp cours = new CoursImp();
    TypeCoursImp typeCours = new TypeCoursImp();
    SeanceGroupe seanceGroupe = new SeanceGroupe();
    SeanceEnseignant seanceEnseignant = new SeanceEnseignant();
    SeanceSalle seanceSalle= new SeanceSalle();
    
    public SeanceDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(SeanceImp seance)
    {
        
    }
    
    public void addSeance(SeanceImp seance, SeanceGroupe seanceGroupe, SeanceEnseignant seanceEnseignant, SeanceSalle seanceSalle)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO seance (semaine, date, heure_debut, heure_fin, etat, id_cours, id_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, seance.getSemaine());
            statement.setString(2, seance.getDate());
            statement.setString(3, seance.getHeureDebut());
            statement.setString(4, seance.getHeureFin());
            statement.setString(5, seance.getEtat());
            statement.setInt(6, seance.getIdCours());
            statement.setInt(7, seance.getIdTypeCours());
            statement.execute();
            
            
            String sql1 = "SELECT * FROM seance WHERE semaine = ? AND date = ? AND "
                    + "heure_debut = ? AND heure_fin = ? AND etat = ? AND id_cours = ? AND id_type = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, seance.getSemaine());
            statement1.setString(2, seance.getDate());
            statement1.setString(3, seance.getHeureDebut());
            statement1.setString(4, seance.getHeureFin());
            statement1.setString(5, seance.getEtat());
            statement1.setInt(6, seance.getIdCours());
            statement1.setInt(7, seance.getIdTypeCours());
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                seance.setIdSeance(resultSet.getInt("id_seance"));
                
                String sql2 = "INSERT INTO seance_groupe (id_seance, id_groupe) VALUES (?, ?)";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, seance.getIdSeance());
                statement2.setInt(2, seanceGroupe.getIdGroupe());
                statement2.execute();

                String sql3 = "INSERT INTO seance_enseignant (id_seance, id_enseignant) VALUES (?, ?)";
                PreparedStatement statement3 = connection.prepareStatement(sql3);
                statement3.setInt(1, seance.getIdSeance());
                statement3.setInt(2, seanceEnseignant.getIdUtilisateur());
                statement3.execute();

                String sql4 = "INSERT INTO seance_salle (id_seance, id_salle) VALUES (?, ?)";
                PreparedStatement statement4 = connection.prepareStatement(sql4);
                statement4.setInt(1, seance.getIdSeance());
                statement4.setInt(2, seanceSalle.getIdSalle());
                statement4.execute();

            System.out.println("La séance du cours n°" + seance.getIdCours() + " a lieu le " + seance.getDate() + " à " + seance.getHeureDebut());
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    @Override
    public void update(SeanceImp seance, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM seance WHERE id_seance = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE seance SET " + type + " = ? WHERE id_seance = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("La seance n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("La seance n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
    public void updateGroupe(SeanceImp seance, int id, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM seance_groupe WHERE id_seance = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE seance_groupe SET id_groupe = ? WHERE id_seance = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("La seance n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("La seance n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
    public void updateEnseignant(SeanceImp seance, int id, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM seance_enseignant WHERE id_seance = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE seance_enseignant SET id_enseignant = ? WHERE id_seance = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("La seance n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("La seance n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
    public void updateSalle(SeanceImp seance, int id, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM seance_salle WHERE id_seance = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE seance_salle SET id_salle = ? WHERE id_seance = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("La seance n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("La seance n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
       
    @Override
    public void delete(SeanceImp seance, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM seance WHERE id_seance = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM seance WHERE id_seance = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
                String sql2 = "DELETE FROM seance_groupe WHERE id_seance = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id);
                statement2.execute();
                
                String sql3 = "DELETE FROM seance_salle WHERE id_seance = ?";
                PreparedStatement statement3 = connection.prepareStatement(sql3);
                statement3.setInt(1, id);
                statement3.execute();
                
                String sql4 = "DELETE FROM seance_enseignant WHERE id_seance = ?";
                PreparedStatement statement4 = connection.prepareStatement(sql4);
                statement4.setInt(1, id);
                statement4.execute();

                System.out.println("La séance n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("La seance n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer la séance");
        }
    }
   
    @Override
    public SeanceImp getById(SeanceImp seance, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM seance WHERE id_seance = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
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

                if(resultSet2.next())
                {
                    cours.setNomCours(resultSet2.getString("nom"));
                    String nom_cours = cours.getNomCours();
                    
                    String sql3 = "SELECT * FROM type_cours WHERE id = ?";
                    PreparedStatement statement3 = connection.prepareStatement(sql3);
                    statement3.setInt(1, id_type);
                    ResultSet resultSet3 = statement3.executeQuery();
                    
                    if(resultSet3.next())
                    {
                        seance.setNomTypeCours(resultSet3.getString("nom"));
                        String nom_type = seance.getNomTypeCours();
                        
                        String sql4 = "SELECT * FROM seance_enseignant WHERE id_seance = ?";
                        PreparedStatement statement4 = connection.prepareStatement(sql4);
                        statement4.setInt(1, id_seance);
                        ResultSet resultSet4 = statement4.executeQuery();

                        if(resultSet4.next())
                        {
                            seanceEnseignant.setIdUtilisateur(resultSet4.getInt("id_enseignant"));
                            int id_enseignant = seanceEnseignant.getIdUtilisateur();
                            
                            String sql5 = "SELECT * FROM seance_groupe WHERE id_seance = ?";
                            PreparedStatement statement5 = connection.prepareStatement(sql5);
                            statement5.setInt(1, id_seance);
                            ResultSet resultSet5 = statement5.executeQuery();
                            
                            if(resultSet5.next())
                            {
                                seanceGroupe.setIdGroupe(resultSet5.getInt("id_groupe"));
                                int id_groupe = seanceGroupe.getIdGroupe();

                                String sql6 = "SELECT * FROM seance_salle WHERE id_seance = ?";
                                PreparedStatement statement6 = connection.prepareStatement(sql6);
                                statement6.setInt(1, id_seance);
                                ResultSet resultSet6 = statement6.executeQuery();
                                
                                if(resultSet6.next())
                                {
                                    seanceSalle.setIdSalle(resultSet6.getInt("id_salle"));
                                    int id_salle = seanceSalle.getIdSalle();
                                    
                                    String sql7 = "SELECT * FROM utilisateur WHERE id = ?";
                                    PreparedStatement statement7 = connection.prepareStatement(sql7);
                                    statement7.setInt(1, id_enseignant);
                                    ResultSet resultSet7 = statement7.executeQuery();

                                    if(resultSet7.next())
                                    {
                                        seanceEnseignant.setNom(resultSet7.getString("nom"));
                                        seanceEnseignant.setPrenom(resultSet7.getString("prenom"));
                                        String nom_enseignant = seanceEnseignant.getNom();
                                        String prenom_enseignant = seanceEnseignant.getPrenom();
                                        
                                        String sql8 = "SELECT * FROM groupe WHERE id = ?";
                                        PreparedStatement statement8 = connection.prepareStatement(sql8);
                                        statement8.setInt(1, id_groupe);
                                        ResultSet resultSet8 = statement8.executeQuery();

                                        if(resultSet8.next())
                                        {
                                            seanceGroupe.setNomGroupe(resultSet8.getString("nom"));
                                            String nom_groupe = seanceGroupe.getNomGroupe();
                                            
                                            String sql9 = "SELECT * FROM salle WHERE id_salle = ?";
                                            PreparedStatement statement9 = connection.prepareStatement(sql9);
                                            statement9.setInt(1, id_salle);
                                            ResultSet resultSet9 = statement9.executeQuery();

                                            if(resultSet9.next())
                                            {
                                                seanceSalle.setNomSalle(resultSet9.getString("nom_salle"));
                                                String nom_salle = seanceSalle.getNomSalle();
                                                
                                                SeanceImp s = new SeanceImp(id_seance, nom_type, nom_cours, semaine, 
                                                        date, heure_debut, heure_fin, etat, nom_enseignant, prenom_enseignant, nom_groupe, nom_salle, message);
                                                System.out.println(s);
                                            }
                                        }

                                    }

                                    
                                }
                            }
                            
                        }
                    } 
                    else
                    {
                        System.out.println("La base de donnée est vide");
                    }
                    
                }
                else
                {
                    System.out.println("La base de donnée est vide");
                }
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            return seance;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
        
    
    @Override
    public SeanceImp getByString(SeanceImp seance, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM seance WHERE "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
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
                                                
                                                SeanceImp s = new SeanceImp(id_seance, nom_type, nom_cours, semaine, 
                                                        date, heure_debut, heure_fin, etat, nom_enseignant, prenom_enseignant, nom_groupe, nom_salle, message);
                                                System.out.println(s);
                                            }
                                        }

                                    }

                                    
                                }
                            }
                            
                        }
                    } 
                    
                }
            }
            return seance;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
}
