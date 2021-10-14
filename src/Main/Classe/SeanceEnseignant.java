
package Main.Classe;

public class SeanceEnseignant extends Enseignant implements Seance
{
    private int id_seance;
    private int id_type_cours;
    private int id_cours;
    private int semaine;
    private String date;
    private String heure_debut;
    private String heure_fin;
    private String etat;
    private String nom_type_cours;
    private String nom_cours;
    private int id_utilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int droit;
    
    //Constructeur
    public SeanceEnseignant(){}

    public SeanceEnseignant(int id_seance, String nom, String prenom, int semaine, String date, String heure_debut, String heure_fin, String etat)
    {
        this.id_seance = id_seance;
        this.id_type_cours = 0;
        this.id_cours = 0;
        this.semaine = semaine;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.etat = etat;
        this.nom_type_cours = null;
        this.nom_cours = null;
        this.id_utilisateur = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.email = null;
        this.password = null;
        this.droit = 3;
  
    }
    
    //Getters
    
    @Override
    public int getIdSeance()
    {
        return id_seance;
    }
    
    @Override
    public int getIdTypeCours()
    {
        return id_type_cours;
    }
    
    @Override
    public String getNomTypeCours()
    {
        return nom_type_cours;
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
    
    @Override
    public int getSemaine()
    {
        return semaine;
    }
    
    @Override
    public String getDate()
    {
        return date;
    }
    
    @Override
    public String getHeureDebut()
    {
        return heure_debut;
    }
    
    @Override
    public String getHeureFin()
    {
        return heure_fin;
    }
    
    @Override
    public String getEtat()
    {
        return etat;
    }
    
    @Override
    public void setIdSeance(int id_seance)
    {
        this.id_seance = id_seance;
    }
    
    @Override
    public void setIdTypeCours(int id_type_cours)
    {
        this.id_type_cours = id_type_cours;
    }
    
    @Override
    public void setNomTypeCours(String nom_type_cours)
    {
        this.nom_type_cours = nom_type_cours;
    }

    @Override
    public void setIdCours(int id_cours)
    {
        this.id_cours = id_cours;
    }
    
    @Override
    public void setNomCours(String nom_cours)
    {
        this.nom_cours = nom_cours;
    }
    
    @Override
    public void setSemaine(int semaine)
    {
        this.semaine = semaine;
    }
    
    @Override
    public void setDate(String date)
    {
        this.date = date;
    }
    
    @Override
    public void setHeureDebut(String heure_debut)
    {
        this.heure_debut = heure_debut;
    }
    
    @Override
    public void setHeureFin(String heure_fin)
    {
        this.heure_fin = heure_fin;
    }
    
    @Override
    public void setEtat(String etat)
    {
        this.etat = etat;
    }
    
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
        return String
        .format("Séance N°%s\n"
                + "    Nom de l'enseignant : %s\n"
                + "    Prénom de l'enseignant : %s\n"
                + "    Semaine : %s\n"
                + "    Date : %s\n"
                + "    Heure de Début : 3\n"
                + "    Heure de Fin : %s\n"
                + "    Etat : %s\n",
                id_seance, nom, prenom, semaine, date, heure_debut, heure_fin, etat);
    }

}
