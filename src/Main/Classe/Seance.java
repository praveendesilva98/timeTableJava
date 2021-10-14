
package Main.Classe;


public interface Seance extends Cours, TypeCours
{
    //Getters
    @Override
    public int getIdTypeCours();
    
    @Override
    public String getNomTypeCours();
    
    @Override
    public int getIdCours();

    @Override
    public String getNomCours();
    
    public int getIdSeance();
    
    public int getSemaine();
    
    public String getDate();
    
    public String getHeureDebut();
    
    public String getHeureFin();
    
    public String getEtat();
    
    //Setters
    @Override
    public void setIdTypeCours(int id);
    
    @Override
    public void setNomTypeCours(String nom);

    @Override
    public void setIdCours(int id);
    
    @Override
    public void setNomCours(String nomCours);
    
    public void setIdSeance(int id_seance);
    
    public void setSemaine(int semaine);
    
    public void setDate(String date);
    
    public void setHeureDebut(String heure_debut);
    
    public void setHeureFin(String heure_fin);
    
    public void setEtat(String etat);
    
}
