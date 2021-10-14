
package Main.Classe.Implements;

import Main.Classe.TypeCours;
import javax.swing.*;

public class TypeCoursImp implements TypeCours
{
    private int id;
    private String nom;
    JLabel message = new JLabel();
    
    public TypeCoursImp(){}
    
    public TypeCoursImp(int id, String nom, JLabel message)
    {
        this.id = id;
        this.nom = nom;
        this.message = message;
    }
    
    //getters
    @Override
    public int getIdTypeCours()
    {
        return id;
    }
    
    @Override
    public String getNomTypeCours()
    {
        return nom;
    }
   
    //setters
    @Override
    public void setIdTypeCours(int id)
    {
        this.id = id;
    }

    @Override
    public void setNomTypeCours(String nom)
    {
        this.nom = nom;
    }
    
    @Override
    public String toString()
    {
        String str = String
        .format("Type N°%s\n"
                + "    Nom : %s\n",
                id, nom);
        message.setText(str);
        
        return message.getText();
    }
}
