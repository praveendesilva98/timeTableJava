package Main.Classe.Implements;

import Main.Classe.Groupe;
import javax.swing.JLabel;

public class GroupeImp implements Groupe
{
    private int id_groupe;
    private String nom_groupe;
    private int id_promo;
    private String nom_promo;
    JLabel message = new JLabel();
    
    //Constructeurs
    public GroupeImp(){}
    
    public GroupeImp(int id, String nom_groupe, String nom_promo, JLabel message)
    {
        this.id_groupe = id;
        this.nom_groupe = nom_groupe;
        this.id_promo = 0;
        this.nom_promo = nom_promo;
        this.message = message;
    }
    
    //getters
    @Override
    public int getIdGroupe()
    {
        return id_groupe;
    }
    
    @Override
    public String getNomGroupe()
    {
        return nom_groupe;
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
    public void setIdGroupe(int id_groupe)
    {
        this.id_groupe = id_groupe;
    }
    
    @Override
    public void setNomGroupe(String nom_groupe)
    {
        this.nom_groupe = nom_groupe;
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
        .format("Groupe N°%s\n"
                + "    Nom Groupe: %s\n"
                + "    Nom Promotion: %S\n",
                id_groupe, nom_groupe, nom_promo);
        message.setText(str);
        
        return message.getText();
    }
 
}