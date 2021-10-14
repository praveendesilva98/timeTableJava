
package Main.Classe.Implements;

import javax.swing.*;
import Main.Classe.Cours;

public class CoursImp implements Cours
{
    public String nomCours;   
    public int idCours;
    
    JLabel message = new JLabel();
    
    public CoursImp(){}
        
    public CoursImp(int idCours, String nomCours, JLabel message)
    {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.message = message;
    }
    
    //getters
    @Override
    public int getIdCours()
    {
        return idCours;
    }
    
    @Override
    public String getNomCours()
    {
        return nomCours;
    }
   
    //setters
    @Override
    public void setIdCours(int idCours)
    {
        this.idCours = idCours;
    }
 
    @Override
    public void setNomCours(String nomCours)
    {
        this.nomCours = nomCours;
    }
    
    @Override
    public String toString()
    {
        String str = String
        .format("Cours N°%s\n"
                + "    Nom : %s\n",
                idCours, nomCours);
        
        message.setText(str);
        
        return message.getText();
    }
}
