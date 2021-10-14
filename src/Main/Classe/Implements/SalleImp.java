package Main.Classe.Implements;

import Main.Classe.Salle;
import javax.swing.JLabel;


public class SalleImp implements Salle
{
    
    //Attributs
    public int id_salle;
    public String nom_salle;
    public int capacite;
    public int id_site;
    public String nom_site;
    
    JLabel message = new JLabel();
    
    //Constructeurs
    public SalleImp(){}
    
    public SalleImp(int id_salle, String nom_salle, int capacite, String nom_site, JLabel message)
    {
        this.id_salle = id_salle;
        this.nom_salle = nom_salle;
        this.capacite = capacite;
        this.id_site = 0;
        this.nom_site = nom_site;
        this.message = message;
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
    
    //Setters
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
    public String toString()
    {
        String str = String
        .format("Salle N°%s\n"
                + "    Nom : %s\n"
                + "    Site : %s\n",
                id_salle, nom_salle, nom_site);
        message.setText(str);
        
        return message.getText();
    }
}