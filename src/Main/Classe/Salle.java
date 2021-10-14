package Main.Classe;

public interface Salle extends Site
{
    
    //Getters
    int getIdSalle();
    String getNomSalle();
    int getCapacite();
    @Override
    int getIdSite();
    
    //Setters
    void setIdSalle(int id_salle);
    void setNomSalle(String nom);
    void setCapacite(int capacite);
    @Override
    void setIdSite(int id_site);
    
}