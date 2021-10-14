
package Main.Classe;

public interface Utilisateur 
{
    //getters
    public int getIdUtilisateur();
    public String getEmail();
    public String getPassword();
    public String getNom();
    public String getPrenom();
    public int getDroit();

    //setters
    public void setIdUtilisateur(int id);
    public void setEmail(String email);
    public void setPassword(String password);
    public void setNom(String nom);
    public void setPrenom(String prenom);
    public void setDroit(int droit);


}
