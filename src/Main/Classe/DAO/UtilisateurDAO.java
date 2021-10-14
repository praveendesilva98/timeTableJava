
package Main.Classe.DAO;

import java.sql.*; 

import Main.Classe.Implements.UtilisateurImp;
import Main.Classe.Enseignant;
import Main.Classe.Etudiant;
import javax.swing.JLabel;

public class UtilisateurDAO implements DAO<UtilisateurImp>
{
    private String url;
    private String user;
    private String password;
    
    Enseignant enseignant = new Enseignant();
    EnseignantDAO enseignantDAO = new EnseignantDAO();
    
    Etudiant etudiant = new Etudiant();
    EtudiantDAO etudiantDAO = new EtudiantDAO();
        
    public UtilisateurDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(UtilisateurImp utilisateur)
    {
        try
        {
            int droit = utilisateur.getDroit();
            
            if(droit == 1 || droit == 2)
            {
                Connection connection = DriverManager.getConnection(url,user,password);
            
                String sql = "INSERT INTO utilisateur (email, password, nom, prenom, droit) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, utilisateur.getEmail());
                statement.setString(2, utilisateur.getPassword());
                statement.setString(3, utilisateur.getNom());
                statement.setString(4, utilisateur.getPrenom());
                statement.setInt(5, utilisateur.getDroit());
                statement.execute();

                System.out.println("L'utilisateur " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " est enregistré avec succès dans la base de donnée Utilisateur");
            }
            else
            {
                System.out.println("Le droit peut prendre les valeurs 1 et 2 seulement.\n"
                        + "Si vous voulez ajouter un enseignant, utilisez la methode enseignant.add(enseignant)\n"
                        + "Si vous voulez ajouter un étudiant, utilisez la methode etudiant.add(etudiant)");
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    @Override
    public void update(UtilisateurImp utilisateur, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM utilisateur WHERE id = ? AND (droit = 1 OR droit = 2)";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE utilisateur SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("L'utilisateur n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("L'utilisateur n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }

    @Override
    public void delete(UtilisateurImp utilisateur, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM utilisateur WHERE id = ? AND (droit = 1 OR droit = 2)";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM utilisateur WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
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
    public UtilisateurImp getById(UtilisateurImp utilisateur, int value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM utilisateur WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                utilisateur.setIdUtilisateur(resultSet.getInt("id"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setDroit(resultSet.getInt("droit"));
                
                int id_utilisateur = utilisateur.getIdUtilisateur();
                String email = utilisateur.getEmail();
                String password = utilisateur.getPassword();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();
                int droit = utilisateur.getDroit();
                
                UtilisateurImp u = new UtilisateurImp(id_utilisateur, email, password, nom, prenom, droit, message);
                System.out.println(u);
            }
            
            return utilisateur;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }    
    }
    
    @Override
    public UtilisateurImp getByString(UtilisateurImp utilisateur, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM utilisateur WHERE "+type+" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                utilisateur.setIdUtilisateur(resultSet.getInt("id"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setDroit(resultSet.getInt("droit"));
                
                int id_utilisateur = utilisateur.getIdUtilisateur();
                String email = utilisateur.getEmail();
                String password = utilisateur.getPassword();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();
                int droit = utilisateur.getDroit();
                

                UtilisateurImp u = new UtilisateurImp(id_utilisateur, email, password, nom, prenom, droit, message);
                System.out.println(u);
            }
            
            return utilisateur;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }        
}
