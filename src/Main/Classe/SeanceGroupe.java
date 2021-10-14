
package Main.Classe;


public class SeanceGroupe implements Groupe, Seance
{
    private int id_seance;
    private int id_type_cours;
    private int id_cours;
    private int semaine;
    private String date;
    private String heure_debut;
    private String heure_fin;
    private String etat;
    private String nom_groupe;
    private int id_promo;
    private String nom_type_cours;
    private String nom_cours;
    private int id_groupe;
    private String nom_promo;
    
    //Constructeur
    public SeanceGroupe(){}

    public SeanceGroupe(int id_seance, String nom_groupe, String nom_promo, int semaine, String date, String heure_debut, String heure_fin, String etat)
    {
        this.id_seance = id_seance;
        this.id_type_cours = 0;
        this.id_cours = 0;
        this.semaine = semaine;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.etat = etat;
        this.id_promo = 0;
        this.nom_groupe = nom_groupe;
        this.nom_type_cours = null;
        this.nom_cours = null;
        this.id_groupe = 0;
        this.nom_promo = nom_promo;
    }
    
    //Getters
    @Override
    public int getIdGroupe()
    {
        return id_groupe;
    }
    
    @Override
    public int getIdPromo()
    {
        return id_promo;
    }
    
    @Override
    public String getNomGroupe()
    {
        return nom_groupe;
    }
    
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
    public String getNomPromo()
    {
        return nom_promo;
    }
    
    //Setters
    @Override
    public void setIdGroupe(int id_groupe)
    {
        this.id_groupe = id_groupe;
    }
    
    @Override
    public void setIdPromo(int id_promo)
    {
        this.id_promo = id_promo;
    }
    
    @Override
    public void setNomGroupe(String nom_groupe)
    {
        this.nom_groupe = nom_groupe;
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
    public void setNomPromo(String nom_promo)
    {
        this.nom_promo = nom_promo;
    }
    
    @Override
    public String toString()
    {
        return String
        .format("Séance N°%s\n"
                + "    Groupe : %s\n"
                + "    Semaine : %s\n"
                + "    Date : %s\n"
                + "    Heure de Début : 3\n"
                + "    Heure de Fin : %s\n"
                + "    Etat : %s\n",
                id_seance, nom_groupe, semaine, date, heure_debut, heure_fin, etat);
    }

}
