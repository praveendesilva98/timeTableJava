package Main.Classe;

import java.util.*;
import Main.Classe.Implements.PromotionImp;
import Main.Classe.Promotion;

public interface Groupe extends Promotion
{
    //Getters
    int getIdGroupe();
    String getNomGroupe();

    //Setters
    void setIdGroupe(int id);
    void setNomGroupe(String nom);
}
