package Main.Classe;

import javax.swing.JLabel;


public class Etudiant implements Utilisateur, Groupe
{
    private int id_utilisateur;
    private int numero_etudiant;
    private int id_groupe;
    private String nom_groupe;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int droit;
    private int id_promo;
    private String nom_promo;
    private JLabel message = new JLabel();
    
    //Constructeur
    public Etudiant(){}

    public Etudiant(int id_utilisateur, String email, String password, String nom, String prenom, int numero, String nom_groupe, JLabel message)
    {
        this.id_utilisateur = id_utilisateur;
        this.numero_etudiant = numero;
        this.id_groupe = 0;
        this.droit = 4;
        this.email = email;
        this.id_promo = 0;
        this.nom = nom;
        this.nom_groupe = nom_groupe;
        this.nom_promo = null;
        this.password = password;
        this.prenom = prenom;
        this.message = message;
    }
    
    //getters
    @Override
    public int getIdUtilisateur(){
        
        return id_utilisateur;
    }
    
    public int getNumero(){
        
        return numero_etudiant;
    }
    
    @Override
    public int getIdGroupe(){
        
        return id_groupe;
    }
    
    @Override
    public String getNomGroupe()
    {
        return nom_groupe;
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
    public int getIdPromo()
    {
        return id_promo;
    }
    
    @Override
    public String getNomPromo()
    {
        return nom_promo;
    }
   
    
    //setters
    @Override
    public void setIdUtilisateur(int id_utilisateur)
    {
        
        this.id_utilisateur = id_utilisateur;
    }
    
    public void setNumeroEtudiant(int numero_etudiant)
    {
        
        this.numero_etudiant = numero_etudiant;
    }
    
    @Override
    public void setIdGroupe(int j){
        
        this.id_groupe = j;
    }

    @Override
    public void setNomGroupe(String nom_groupe){
        
        this.nom_groupe = nom_groupe;
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
    public void setIdPromo(int id_promo)
    {
        this.id_promo = id_promo;
    }
    
    @Override
    public void setNomPromo(String nom_promo)
    {
        this.nom_promo = nom_promo;
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
                + "    Numéro Etudiant : %s\n"
                + "    Groupe : %s\n",
                id_utilisateur, nom, prenom, email, password, numero_etudiant, nom_groupe);
        
        message.setText(str);
        return message.getText();
    }
    
    
    
    
}
