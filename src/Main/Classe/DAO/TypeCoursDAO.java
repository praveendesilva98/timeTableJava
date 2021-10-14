
package Main.Classe.DAO;

import Main.Classe.Implements.TypeCoursImp;

import java.sql.*;
import javax.swing.JLabel;


public class TypeCoursDAO implements DAO<TypeCoursImp>
{
    private String url;
    private String user;
    private String password;
        
    public TypeCoursDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(TypeCoursImp typeCours)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO type_cours (nom) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, typeCours.getNomTypeCours());
            statement.execute();

            System.out.println("Le Type de Cours " + typeCours.getNomTypeCours() + " est enregistré avec succès dans la base de donnée Type Cours");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter ce type de cours");
        }
    }
    
    @Override
    public void update(TypeCoursImp typeCours, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM type_cours WHERE id = " + id;
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE type_cours SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("Le type de cours n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("Le type de cours n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }

    @Override
    public void delete(TypeCoursImp typeCours, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM type_cours WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM type_cours WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
                System.out.println("Le type de cours n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("Le type de cours n'existe pas dans la base de données !\n");
            }

            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer le type de cours");
        }
    }
    
    @Override
    public TypeCoursImp getById(TypeCoursImp typeCours, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM type_cours WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                typeCours.setIdTypeCours(resultSet.getInt("id"));
                typeCours.setNomTypeCours(resultSet.getString("nom"));
                
                int id_typeCours = typeCours.getIdTypeCours();
                String nom = typeCours.getNomTypeCours();
                
                TypeCoursImp t = new TypeCoursImp(id_typeCours, nom, message);
                System.out.println(t);
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            
            return typeCours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }    
    }
    
    @Override
    public TypeCoursImp getByString(TypeCoursImp typeCours, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM type_cours WHERE "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                typeCours.setIdTypeCours(resultSet.getInt("id"));
                typeCours.setNomTypeCours(resultSet.getString("nom"));
                
                int id_typeCours = typeCours.getIdTypeCours();
                String nom = typeCours.getNomTypeCours();
                
                TypeCoursImp t = new TypeCoursImp(id_typeCours, nom, message);
                System.out.println(t);
            }
            
            
            return typeCours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
