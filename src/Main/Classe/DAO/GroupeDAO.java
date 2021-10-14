package Main.Classe.DAO;

import java.sql.*; 
import Main.Classe.Implements.GroupeImp;
import Main.Classe.Implements.PromotionImp;
import javax.swing.JLabel;

/**
 *
 * @author prave
 */
public class GroupeDAO implements DAO<GroupeImp>
{
    
    private String url;
    private String user;
    private String password;
    
    PromotionImp promotion = new PromotionImp();
    
    /**
     *
     */
    public GroupeDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    /**
     *
     * @param groupe
     */
    @Override
    public void add(GroupeImp groupe)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO groupe (nom, id_promo) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, groupe.getNomGroupe());
            statement.setInt(2, groupe.getIdPromo());
            statement.execute();

            System.out.println("Le groupe " + groupe.getNomGroupe() + " est enregistré avec succès dans la base de donnée Groupe");

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    /**
     *
     * @param groupe
     * @param id
     * @param type
     * @param value
     */
    @Override
    public void update(GroupeImp groupe, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM groupe WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE groupe SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("Le groupe n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("Le groupe n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
    /**
     *
     * @param groupe
     * @param id
     * @param id_promo
     */
    public void updateIdPromo(GroupeImp groupe, int id, int id_promo)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM groupe WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE groupe SET id_promo = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id_promo);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("Le groupe n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("Le groupe n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
     
    /**
     *
     * @param groupe
     * @param id
     */
    @Override
    public void delete(GroupeImp groupe, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM groupe WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM groupe WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();

                System.out.println("Le groupe n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("Le groupe n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer le groupe");
        }
    }
   
    /**
     *
     * @param groupe
     * @param id
     * @return
     */
    @Override
    public GroupeImp getById(GroupeImp groupe, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM groupe, promotion WHERE id_promotion = id_promo AND id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                groupe.setIdGroupe(resultSet.getInt("id"));
                groupe.setNomGroupe(resultSet.getString("nom"));
                groupe.setIdPromo(resultSet.getInt("id_promo"));

                int id_promo = groupe.getIdPromo();
                int id_groupe = groupe.getIdGroupe();
                String nom_groupe = groupe.getNomGroupe();
                
                String sql2 = "SELECT * FROM promotion WHERE id_promotion = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_promo);
                ResultSet resultSet2 = statement2.executeQuery();

                if(resultSet2.next())
                {
                    promotion.setNomPromo(resultSet2.getString("nom_promotion"));
                    String nom_promo = promotion.getNomPromo();
                    
                    GroupeImp g = new GroupeImp(id_groupe, nom_groupe, nom_promo, message);
                    System.out.println(g);
                }
                
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            return groupe;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    /**
     *
     * @param groupe
     * @param type
     * @param value
     * @return
     */
    @Override
    public GroupeImp getByString(GroupeImp groupe, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM groupe, promotion WHERE id_promotion = id_promo AND "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                groupe.setIdGroupe(resultSet.getInt("id"));
                groupe.setNomGroupe(resultSet.getString("nom"));
                groupe.setIdPromo(resultSet.getInt("id_promo"));
                
                int id_promo = groupe.getIdPromo();
                int id_groupe = groupe.getIdGroupe();
                String nom_groupe = groupe.getNomGroupe();
                
                String sql2 = "SELECT * FROM promotion WHERE id_promotion = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_promo);
                ResultSet resultSet2 = statement2.executeQuery();

                while(resultSet2.next())
                {
                    promotion.setNomPromo(resultSet2.getString("nom_promotion"));
                    String nom_promo = promotion.getNomPromo();
                    
                    GroupeImp g = new GroupeImp(id_groupe, nom_groupe, nom_promo, message);
                    System.out.println(g);
                }
                
            }
            return groupe;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}