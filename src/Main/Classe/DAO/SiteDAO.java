package Main.Classe.DAO;

import Main.Classe.Implements.SiteImp;
import java.sql.*;
import javax.swing.JLabel;

public class SiteDAO implements DAO<SiteImp>
{
    
    private String url;
    private String user;
    private String password;
    
    public SiteDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(SiteImp site)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO site (nom) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, site.getNomSite());
            statement.execute();

            System.out.println("Le site " + site.getNomSite() + " est enregistré avec succès dans la base de donnée Site");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter ce site");
        }
    }
    
    @Override
    public void update(SiteImp site, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM site WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE site SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("Le site n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("Le site n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }

    @Override
    public void delete(SiteImp site, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM site WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM site WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
                String sql2 = "DELETE FROM salle WHERE id_site = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id);
                statement2.execute();
                
                System.out.println("L'utilisateur n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("L'utilisateur n'existe pas dans la base de données !\n");
            }

            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
    
    @Override
    public SiteImp getById(SiteImp site, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM site WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                site.setIdSite(resultSet.getInt("id"));
                site.setNomSite(resultSet.getString("nom"));
                
                int id_site = site.getIdSite();
                String nom_site = site.getNomSite();
                
                SiteImp s = new SiteImp(id_site, nom_site, message);
                System.out.println(s);
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            
            return site;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }    
    }
    
    @Override
    public SiteImp getByString(SiteImp site, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM site WHERE "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                site.setIdSite(resultSet.getInt("id"));
                site.setNomSite(resultSet.getString("nom"));
                
                int id_site = site.getIdSite();
                String nom_site = site.getNomSite();
                
                SiteImp s = new SiteImp(id_site, nom_site, message);
                System.out.println(s);
            }
           
            
            return site;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }

}