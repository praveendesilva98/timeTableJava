package Main.Classe.DAO;

import java.sql.*;
import Main.Classe.Implements.PromotionImp;
import javax.swing.JLabel;

public class PromotionDAO implements DAO<PromotionImp>
{
    
    //Attributs
    private String url;
    private String user;
    private String password;
    
    public PromotionDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(PromotionImp promotion)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO promotion (nom_promotion) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, promotion.getNomPromo());
            statement.execute();

            System.out.println("La promo " + promotion.getNomPromo() + " est enregistré avec succès dans la base de donnée Promotion");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    @Override
    public void update(PromotionImp promotion, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM promotion WHERE id_promotion = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE promotion SET " + type + " = ? WHERE id_promotion = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("La promotion n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("La promotion n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }

    @Override
    public void delete(PromotionImp promotion, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM promotion WHERE id_promotion = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM promotion WHERE id_promotion = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
                String sql2 = "DELETE FROM groupe WHERE id_promo = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id);
                statement2.execute();
                
                System.out.println("La promotion n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("La promotion n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
    
    @Override
    public PromotionImp getById(PromotionImp promotion, int value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM promotion WHERE id_promotion = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, value);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                promotion.setIdPromo(resultSet.getInt("id_promotion"));
                promotion.setNomPromo(resultSet.getString("nom_promotion"));
                
                int id_promo = promotion.getIdPromo();
                String nom_promo = promotion.getNomPromo();

                PromotionImp p = new PromotionImp(id_promo, nom_promo, message);
                System.out.println(p);
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            
            return promotion;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }    
    }
    
    @Override
    public PromotionImp getByString(PromotionImp promotion, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM promotion WHERE "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                promotion.setIdPromo(resultSet.getInt("id_promotion"));
                promotion.setNomPromo(resultSet.getString("nom_promotion"));
                
                int id_promo = promotion.getIdPromo();
                String nom_promo = promotion.getNomPromo();

                PromotionImp p = new PromotionImp(id_promo, nom_promo, message);
                System.out.println(p);
            }
            return promotion;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
}