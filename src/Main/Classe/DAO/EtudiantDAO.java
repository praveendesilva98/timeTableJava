package Main.Classe.DAO;

import java.sql.*; 
import Main.Classe.Etudiant;
import Main.Classe.Implements.UtilisateurImp;
import Main.Classe.Implements.GroupeImp;
import javax.swing.JLabel;

public class EtudiantDAO implements DAO<Etudiant> 
{
    UtilisateurImp utilisateur = new UtilisateurImp();
    //Attributs
    private String url;
    private String user;
    private String password;
    
    GroupeImp groupe = new GroupeImp();
    
    //Constructeur
    public EtudiantDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    @Override
    public void add(Etudiant etudiant)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            String sql = "INSERT INTO utilisateur (email, password, nom, prenom, droit) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, etudiant.getEmail());
            statement.setString(2, etudiant.getPassword());
            statement.setString(3, etudiant.getNom());
            statement.setString(4, etudiant.getPrenom());
            statement.setInt(5, 4);
            statement.execute();

            System.out.println("L'utilisateur " + etudiant.getNom() + " " + etudiant.getPrenom() + " est enregistré avec succès dans la base de donnée Utilisateur");

            String sql1 = "SELECT * FROM utilisateur WHERE email = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, etudiant.getEmail());
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                utilisateur.setIdUtilisateur(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                
                int id_utilisateur = utilisateur.getIdUtilisateur();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();

                String sql2 = "INSERT INTO etudiant (id_utilisateur, numero, id_groupe) VALUES (?, ?, ?)";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_utilisateur);
                statement2.setInt(2, etudiant.getNumero());
                statement2.setInt(3, etudiant.getIdGroupe());
                statement2.execute();
                System.out.println("L'étudiant " + nom + " " + prenom + " est enregistré avec succès dans la base de donnée Etudiant");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    @Override
    public void update(Etudiant etudiant, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM utilisateur WHERE id = ? AND droit = 4";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                etudiant.setIdUtilisateur(id);
                String sql = "UPDATE utilisateur SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
                
                System.out.println("L'etudiant n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("L'etudiant n'existe pas dans la base de données !\n");
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
     
    public void updateNumeroEtudiant(Etudiant etudiant, int id, int value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM etudiant WHERE id_utilisateur = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "UPDATE etudiant SET numero = ? WHERE id_utilisateur = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, value);
                statement.setInt(2, id);
                statement.execute();
                System.out.println("L'etudiant n°" + id + " est modifié avec succès");
            }
            else
            {
                System.out.println("L'etudiant n'existe pas dans la base de données !\n");
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
        
    }
       
    @Override
    public void delete(Etudiant etudiant, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql1 = "SELECT * FROM utilisateur WHERE id = ? AND droit = 4";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id);
            ResultSet resultSet = statement1.executeQuery();

            if(resultSet.next())
            {
                String sql = "DELETE FROM utilisateur WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                
                String sql2 = "DELETE FROM etudiant WHERE id_utilisateur = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id);
                statement2.execute();
                
                System.out.println("L'utilisateur n°" + id + " est supprimé de la base de données avec succès");
            }
            else
            {
                System.out.println("L'etudiant n'existe pas dans la base de données !\n");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
   
    @Override
    public Etudiant getById(Etudiant etudiant, int id, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM etudiant, utilisateur WHERE id = id_utilisateur AND id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                etudiant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                etudiant.setIdGroupe(resultSet.getInt("id_groupe"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setPassword(resultSet.getString("password"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setNumeroEtudiant(resultSet.getInt("numero"));
                    

                int id_utilisateur = etudiant.getIdUtilisateur();
                int id_groupe = etudiant.getIdGroupe();
                String email = etudiant.getEmail();
                String password = etudiant.getPassword();
                String nom = etudiant.getNom();
                String prenom = etudiant.getPrenom();
                int droit = 4;
                int numero = etudiant.getNumero();
                
                String sql2 = "SELECT * FROM groupe WHERE id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_groupe);
                ResultSet resultSet2 = statement2.executeQuery();

                if(resultSet2.next())
                {
                    etudiant.setNomGroupe(resultSet2.getString("nom"));
                    String nom_groupe = etudiant.getNomGroupe();
                    
                    Etudiant e = new Etudiant(id_utilisateur, email, password, nom, prenom, numero, nom_groupe, message);
                    System.out.println(e);
                }
                else
                {
                    System.out.println("L'élément est introuvable dans la base de donnée Groupe");
                }
                
            }
            else
            {
                System.out.println("La base de donnée est vide !");
            }
            return etudiant;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    @Override
    public Etudiant getByString(Etudiant etudiant, String type, String value, JLabel message)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM etudiant, utilisateur WHERE id = id_utilisateur AND "+ type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                etudiant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                etudiant.setIdGroupe(resultSet.getInt("id_groupe"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setPassword(resultSet.getString("password"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setNumeroEtudiant(resultSet.getInt("numero"));
                    

                int id_utilisateur = etudiant.getIdUtilisateur();
                int id_groupe = etudiant.getIdGroupe();
                String email = etudiant.getEmail();
                String password = etudiant.getPassword();
                String nom = etudiant.getNom();
                String prenom = etudiant.getPrenom();
                int droit = 4;
                int numero = etudiant.getNumero();
                
                String sql2 = "SELECT * FROM groupe WHERE id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setInt(1, id_groupe);
                ResultSet resultSet2 = statement2.executeQuery();

                while(resultSet2.next())
                {
                    etudiant.setNomGroupe(resultSet2.getString("nom"));
                    String nom_groupe = etudiant.getNomGroupe();
                    
                    Etudiant e = new Etudiant(id_utilisateur, email, password, nom, prenom, numero, nom_groupe, message);
                    System.out.println(e);
                }
                
            }

            return etudiant;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
