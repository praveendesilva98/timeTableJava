package Main.Classe.Implements;

import Main.Classe.Site;
import javax.swing.JLabel;


public class SiteImp implements Site
{
    //Attribut
    private int id;
    private String nom;
    
    JLabel message = new JLabel();
    
    //Constructeur
    public SiteImp(){}
    
    public SiteImp(int id, String nom, JLabel message)
    {
        this.id = id;
        this.nom = nom;
        this.message = message;
    }
    
    //Getters
    @Override
    public int getIdSite()
    {
        return id;
    }
    
    @Override
    public String getNomSite()
    {
        return nom;
    }
    
    //Setters
    @Override
    public void setIdSite(int id)
    {
        this.id = id;
    }
    
    @Override
    public void setNomSite(String nom)
    {
        this.nom = nom;
    }
    
    @Override
    public String toString()
    {
        String str = String
        .format("Site N°%s\n"
                + "    Nom : %s\n",
                id, nom);
        message.setText(str);
        
        return message.getText();
    }
}