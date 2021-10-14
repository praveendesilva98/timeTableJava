
package Main.Classe.Implements;

import Main.Classe.Promotion;
import javax.swing.JLabel;

public class PromotionImp implements Promotion
{
    public int id_promo;
    public String nom_promo;
    JLabel message = new JLabel();
    
    public PromotionImp() {}
    
    public PromotionImp(int id_promo, String nom_promo, JLabel message)
    {
        this.id_promo = id_promo;
        this.nom_promo = nom_promo;
        this.message = message;
    }
    
    //Getters
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
    
    //Setters
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
        .format("Promotion N°%s\n"
                + "    Nom : %s\n",
                id_promo, nom_promo);
        
        message.setText(str);
        
        return message.getText();
    }
}
