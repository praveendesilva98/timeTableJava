
package Main.Classe.DAO;

import java.sql.*;
import javax.swing.*;
import Main.Classe.Implements.CoursImp;

public class CoursDAO implements DAO<CoursImp> 
{
    private String url;
    private String user;
    private String password;
    
    JLabel message = new JLabel();
    
    public CoursDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }

    @Override
    public void add(CoursImp cours)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO cours(nom) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cours.getNomCours());
            statement.execute();
            
            System.out.println("Le cours " + cours.getNomCours() + " est enregistré dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter ce cours");
        }
    }
    
    
    @Override
    public void update(CoursImp cours, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM cours WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE cours SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("Le cours n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("Le cours n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
   
    @Override
    public void delete(CoursImp cours, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM cours WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                cours.setIdCours(id);
                String sql = "DELETE FROM cours WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();

                System.out.println("Le cours n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("Le cours n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
    
    @Override
    public CoursImp getById(CoursImp cours, int id, JLabel message)
    {
        
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM cours WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                cours.setIdCours(resultSet.getInt("id"));
                cours.setNomCours(resultSet.getString("nom"));
                
                int id_cours = cours.getIdCours();
                String nom_cours = cours.getNomCours();                
                
                CoursImp c = new CoursImp(id_cours, nom_cours, message);
                System.out.println(c);
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            return cours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    @Override
    public CoursImp getByString(CoursImp cours, String type, String nom, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM cours WHERE " + type + " = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                cours.setIdCours(resultSet.getInt("id"));
                cours.setNomCours(resultSet.getString("nom"));
                
                int id_cours = cours.getIdCours();
                String nom_cours = cours.getNomCours();
                
                CoursImp c = new CoursImp(id_cours, nom_cours, message);
                System.out.println(c);
            }
            return cours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
}
