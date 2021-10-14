
package Main.Classe;


public class SeanceSalle implements Salle, Seance
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
    public int id_salle;
    public String nom_salle;
    public int capacite;
    public int id_site;
    public String nom_site;
    
    //Constructeur
    public SeanceSalle(){}

    public SeanceSalle(int id_seance, String nom_site, String nom_salle, int capacite, int semaine, String date, String heure_debut, String heure_fin, String etat)
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
        this.capacite = capacite;
        this.nom_salle = nom_salle;
        this.nom_site = nom_site;
        this.id_site = 0;
    }
    
    //Getters
    
    @Override
    public int getIdSalle()
    {
        
        return id_salle;
    }
    
    @Override
    public String getNomSalle()
    {
        return nom_salle;
    }
    
    @Override
    public int getCapacite()
    {      
        return capacite;
    }
    
    @Override
    public int getIdSite()
    {     
        return id_site;
    }
    
    @Override
    public String getNomSite()
    {     
        return nom_site;
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
    public void setIdSalle(int id_salle)
    {
        this.id_salle = id_salle;
    }
    
    @Override
    public void setNomSalle(String nom_salle)
    {    
        this.nom_salle = nom_salle;
    }
    
    @Override
    public void setCapacite(int capacite)
    {
        
        this.capacite = capacite;
    }
    
    @Override
    public void setIdSite(int id_site)
    {
        
        this.id_site = id_site;
    }
    
    @Override
    public void setNomSite(String nom_site)
    {
        
        this.nom_site = nom_site;
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
    public String toString()
    {
        return String
        .format("Séance N°%s\n"
                + "    Site : %s\n"
                + "    Salle : %s\n"
                + "    Capacité : %s\n"
                + "    Semaine : %s\n"
                + "    Date : %s\n"
                + "    Heure de Début : 3\n"
                + "    Heure de Fin : %s\n"
                + "    Etat : %s\n",
                id_seance, nom_site, nom_salle, capacite, semaine, date, heure_debut, heure_fin, etat);
    }

}
