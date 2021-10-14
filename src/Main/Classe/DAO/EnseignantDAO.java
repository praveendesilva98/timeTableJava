
package Main.Classe.DAO;

import Main.Classe.Enseignant;
import Main.Classe.Implements.CoursImp;
import Main.Classe.Implements.UtilisateurImp;
import java.sql.*;
import javax.swing.JLabel;


public class EnseignantDAO implements DAO<Enseignant>
{
    private String url;
    private String user;
    private String password;
    
    UtilisateurImp utilisateur = new UtilisateurImp();
    
    CoursImp cours = new CoursImp();
    
    public EnseignantDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(Enseignant enseignant)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO utilisateur (email, password, nom, prenom, droit) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, enseignant.getEmail());
            statement.setString(2, enseignant.getPassword());
            statement.setString(3, enseignant.getNom());
            statement.setString(4, enseignant.getPrenom());
            statement.setInt(5, 3);
            statement.execute();

            System.out.println("L'utilisateur " + enseignant.getNom() + " " + enseignant.getPrenom() + " est enregistré avec succès dans la base de donnée Utilisateur");

            String sql1 = "SELECT * FROM utilisateur WHERE email = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, enseignant.getEmail());
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                utilisateur.setIdUtilisateur(resultSet.getInt("id"));
                int idUtilisateur = utilisateur.getIdUtilisateur();

                String sql2 = "INSERT INTO enseignant (id_utilisateur, id_cours) VALUES (?, ?)";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, idUtilisateur);
                statement2.setInt(2, enseignant.getIdCours());
                statement2.execute();
                System.out.println("L'utilisateur n°" + idUtilisateur + " qui enseigne le cours n°" + enseignant.getIdCours() + " est enregistré avec succès dans la base de donnée Enseignant");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    @Override
    public void update(Enseignant enseignant, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM utilisateur WHERE id = ? AND droit = 3";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                enseignant.setIdUtilisateur(id);
                String sql = "UPDATE utilisateur SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("L'enseignant n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("L'enseignant n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
     
       
    @Override
    public void delete(Enseignant enseignant, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM utilisateur WHERE id = ? AND droit = 3";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM utilisateur WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
                String sql2 = "DELETE FROM enseignant WHERE id_utilisateur = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id);
                statement2.execute();
                
                System.out.println("L'utilisateur n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("L'enseignant n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
   
    @Override
    public Enseignant getById(Enseignant enseignant, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM enseignant, utilisateur WHERE id = id_utilisateur AND id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                enseignant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                enseignant.setIdCours(resultSet.getInt("id_cours"));
                enseignant.setEmail(resultSet.getString("email"));
                enseignant.setPassword(resultSet.getString("password"));
                enseignant.setNom(resultSet.getString("nom"));
                enseignant.setPrenom(resultSet.getString("prenom"));

                int id_utilisateur = enseignant.getIdUtilisateur();
                int id_cours = enseignant.getIdCours();
                String email = enseignant.getEmail();
                String password = enseignant.getPassword();
                String nom = enseignant.getNom();
                String prenom = enseignant.getPrenom();
                int droit = 3;
                
                String sql2 = "SELECT * FROM cours WHERE id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_cours);
                ResultSet resultSet2 = statement2.executeQuery();

                if(resultSet2.next())
                {
                    enseignant.setNomCours(resultSet2.getString("nom"));
                    String nom_cours = enseignant.getNomCours();
                    Enseignant e = new Enseignant(id_utilisateur, email, password, nom, prenom, droit, nom_cours, message);
                    System.out.println(e);
                }
                
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            return enseignant;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    @Override
    public Enseignant getByString(Enseignant enseignant, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM enseignant, utilisateur WHERE id = id_utilisateur AND "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                enseignant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                enseignant.setIdCours(resultSet.getInt("id_cours"));
                enseignant.setEmail(resultSet.getString("email"));
                enseignant.setPassword(resultSet.getString("password"));
                enseignant.setNom(resultSet.getString("nom"));
                enseignant.setPrenom(resultSet.getString("prenom"));

                int id_utilisateur = enseignant.getIdUtilisateur();
                int id_cours = enseignant.getIdCours();
                String email = enseignant.getEmail();
                String password = enseignant.getPassword();
                String nom = enseignant.getNom();
                String prenom = enseignant.getPrenom();
                int droit = 3;
                
                String sql2 = "SELECT * FROM cours WHERE id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_cours);
                ResultSet resultSet2 = statement2.executeQuery();

                while(resultSet2.next())
                {
                    enseignant.setNomCours(resultSet2.getString("nom"));
                    String nom_cours = enseignant.getNomCours();
                    Enseignant e = new Enseignant(id_utilisateur, email, password, nom, prenom, droit, nom_cours, message);
                    System.out.println(e);
                }
                
            }
            return enseignant;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
