package Main.Classe.DAO;

import Main.Classe.Implements.SalleImp;
import java.sql.*;
import javax.swing.JLabel;

public class SalleDAO implements DAO<SalleImp>
{
    
    private String url;
    private String user;
    private String password;
    
    public SalleDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(SalleImp salle)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO salle (nom_salle, capacite, id_site) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, salle.getNomSalle());
            statement.setInt(2, salle.getCapacite());
            statement.setInt(3, salle.getIdSite());
            statement.execute();

            System.out.println("La salle " + salle.getNomSalle() + " est enregistré avec succès dans la base de donnée Salle");

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    @Override
    public void update(SalleImp salle, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM salle WHERE id_salle = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE salle SET " + type + " = ? WHERE id_salle = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("La salle n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("L& salle n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
     
       
    @Override
    public void delete(SalleImp salle, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM salle WHERE id_salle = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM salle WHERE id_salle = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();

                System.out.println("La salle n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("La salle n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
   
    @Override
    public SalleImp getById(SalleImp salle, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM salle, site WHERE id = id_site AND id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                salle.setIdSalle(resultSet.getInt("id_salle"));
                salle.setNomSalle(resultSet.getString("nom_salle"));
                salle.setCapacite(resultSet.getInt("capacite"));
                salle.setIdSite(resultSet.getInt("id_site"));

                int id_salle = salle.getIdSalle();
                int id_site = salle.getIdSite();
                String nom_salle = salle.getNomSalle();
                int capacite = salle.getCapacite();
                
                String sql2 = "SELECT * FROM site WHERE id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_site);
                ResultSet resultSet2 = statement2.executeQuery();

                if(resultSet2.next())
                {
                    salle.setNomSite(resultSet2.getString("nom"));
                    String nom_site = salle.getNomSite();
                    SalleImp s = new SalleImp(id_salle, nom_salle, capacite, nom_site, message);
                    System.out.println(s);
                }
                
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            return salle;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    @Override
    public SalleImp getByString(SalleImp salle, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM salle, site WHERE id = id_site AND "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                salle.setIdSalle(resultSet.getInt("id_salle"));
                salle.setNomSalle(resultSet.getString("nom_salle"));
                salle.setCapacite(resultSet.getInt("capacite"));
                salle.setIdSite(resultSet.getInt("id_site"));

                int id_salle = salle.getIdSalle();
                int id_site = salle.getIdSite();
                String nom_salle = salle.getNomSalle();
                int capacite = salle.getCapacite();
                
                String sql2 = "SELECT * FROM site WHERE id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_site);
                ResultSet resultSet2 = statement2.executeQuery();

                while(resultSet2.next())
                {
                    salle.setNomSite(resultSet2.getString("nom"));
                    String nom_site = salle.getNomSite();
                    SalleImp s = new SalleImp(id_salle, nom_salle, capacite, nom_site, message);
                    System.out.println(s);
                }
                
            }

            return salle;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}