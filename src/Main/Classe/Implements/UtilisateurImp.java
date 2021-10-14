
package Main.Classe.Implements;

import Main.Classe.Utilisateur;
import javax.swing.*;

public class UtilisateurImp implements Utilisateur
{
    public int id_utilisateur;
    public String email;
    public String password;
    public String nom;
    public String prenom;
    public int droit;
    public JLabel message;
    
    public UtilisateurImp(){}
    
    public UtilisateurImp(int id, String email, String password, String nom, String prenom, int droit, JLabel message)
    {
        this.id_utilisateur = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
        this.message = message;
    }
    
    //getters
    @Override
    public int getIdUtilisateur()
    {
        return id_utilisateur;
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
    public String toString()
    {
        String str = String
        .format("Utilisateur N°%s\n"
                + "    Nom : %s\n"
                + "    Prénom : %s\n"
                + "    Email : %s\n"
                + "    Mot de Passe : %s\n"
                + "    Droit : %s\n", 
                id_utilisateur, nom, prenom, email, password, droit);
        
        message.setText(str);
        
        return message.getText();
    }

}

   
