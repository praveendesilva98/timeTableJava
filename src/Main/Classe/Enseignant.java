
package Main.Classe;

import Main.Classe.Implements.CoursImp;
import Main.Classe.Implements.UtilisateurImp;
import javax.swing.JLabel;

public class Enseignant implements Cours, Utilisateur
{
    CoursImp cours = new CoursImp();
    UtilisateurImp utilisateur = new UtilisateurImp();
    
    private int id_utilisateur;
    private int id_cours;
    private String nom_cours;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int droit;
    JLabel message = new JLabel();
    
    public Enseignant(){}
    //getters
    
    public Enseignant(int id_utilisateur, String email, String password, String nom, String prenom, int droit, String nom_cours, JLabel message)
    {
        this.id_utilisateur = id_utilisateur;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
        this.id_cours = 0;
        this.nom_cours = nom_cours;
        this.message = message;
    }

    @Override
    public int getIdUtilisateur()
    {
        return utilisateur.id_utilisateur;      
    }
    
     @Override
    public String getEmail()
    {
        return email;
    }
    
    @Override
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public String getNom()
    {
        return nom;
    }
    
    @Override
    public String getPrenom()
    {
        return prenom;
    }
    
    @Override
    public int getDroit()
    {
        return droit;
    }


    @Override
    public int getIdCours()
    {
        return id_cours;
    }
    
    @Override
    public String getNomCours()
    {
        return nom_cours;
    }
    
    //setters
    
    @Override
    public void setIdUtilisateur(int id)
    {
        this.id_utilisateur = id;
    }
    
    @Override
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    @Override
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    @Override
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    
    @Override
    public void setDroit(int droit)
    {
        this.droit = droit;
    }
    
    @Override
    public void setIdCours(int idCours)
    {
        this.id_cours = idCours;
    }
 
    @Override
    public void setNomCours(String nomCours)
    {
        this.nom_cours = nomCours;
    }
    
    @Override
    public String toString()
    {
        String str = String
        .format("Utilisateur N°%s\n"
                + "    Nom : %s\n"
                + "    Prénom : %s\n"
                + "    Email : %s\n"
                + "    Mot de Passe : %s\n"
                + "    Droit : 3\n"
                + "    Cours : %s\n",
                id_utilisateur, nom, prenom, email, password, nom_cours);
        
        message.setText(str);
        return message.getText();
    }
}
