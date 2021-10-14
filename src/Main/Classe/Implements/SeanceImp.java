
package Main.Classe.Implements;

import Main.Classe.Seance;
import javax.swing.JLabel;

public class SeanceImp implements Seance
{    
    public int id_seance;
    public int id_type_cours;
    public String nom_type_cours;
    public int id_cours;
    public String nom_cours;
    public int semaine;
    public String date;
    public String heure_debut;
    public String heure_fin;
    public String etat;
    public String nom_enseignant;
    public String prenom_enseignant;
    public String nom_groupe;
    public String nom_salle;
    
    JLabel message = new JLabel();
    
    public SeanceImp(){}
    
    public SeanceImp(int id_seance, String nom_type_cours, String nom_cours, int semaine, String date, String heure_debut, String heure_fin, String etat, String nom_enseignant, String prenom_enseignant, String nom_groupe, String nom_salle, JLabel message)
    {
        this.id_seance = id_seance;
        this.id_type_cours = 0;
        this.nom_type_cours = nom_type_cours;
        this.id_cours = 0;
        this.nom_cours = nom_cours;
        this.semaine = semaine;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.etat = etat;
        this.nom_enseignant = nom_enseignant;
        this.prenom_enseignant = prenom_enseignant;
        this.nom_groupe = nom_groupe;
        this.nom_salle = nom_salle;
        this.message = message;
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
    
    //Setters
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
    public void setNomCours(String nomCours)
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
        String str = String
        .format("Séance N°%s\n"
                + "    Type de Cours : %s\n"
                + "    Nom du Cours : %s\n"
                + "    Semaine : %s\n"
                + "    Date : %s\n"
                + "    Heure de Début : %s\n"
                + "    Heure de Fin : %s\n"
                + "    Etat : %s\n"
                + "    Enseignant : %s %s\n"
                + "    Groupe : %s\n"
                + "    Salle : %s\n",
                id_seance, nom_type_cours, nom_cours, semaine, date, heure_debut, heure_fin, etat, nom_enseignant, prenom_enseignant, nom_groupe, nom_salle);
        
        message.setText(str);
        
        return message.getText();
    }
}
