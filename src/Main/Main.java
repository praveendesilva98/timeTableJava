
package Main;

import Main.Classe.*;
import Main.Classe.DAO.*;
import Main.Classe.Implements.*;
import javax.swing.JLabel;

public class Main 
{

    public static void main(String[] args)
    {   
        CoursImp coursImp = new CoursImp();
        CoursDAO cours = new CoursDAO();
        
        UtilisateurDAO utilisateur = new UtilisateurDAO();
        UtilisateurImp utilisateurImp = new UtilisateurImp();
        Enseignant enseignant = new Enseignant();
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        
        TypeCoursImp type = new TypeCoursImp();
        TypeCoursDAO typeCours = new TypeCoursDAO();
        
        PromotionImp promotion = new PromotionImp();
        PromotionDAO promotionDAO = new PromotionDAO();
        
        GroupeImp groupe = new GroupeImp();
        GroupeDAO groupeDAO = new GroupeDAO();
        
        Etudiant etudiant = new Etudiant();
        EtudiantDAO etudiantDAO = new EtudiantDAO();
        
        SiteImp site = new SiteImp();
        SiteDAO siteDAO = new SiteDAO();
        
        SalleImp salle = new SalleImp();
        SalleDAO salleDAO = new SalleDAO();
        
        SeanceDAO seanceDAO = new SeanceDAO();
        SeanceImp seance = new SeanceImp();
        
        SeanceGroupe seanceGroupe = new SeanceGroupe();
        SeanceEnseignant seanceEnseignant = new SeanceEnseignant();
        SeanceSalle seanceSalle = new SeanceSalle();

        enseignant.setNom("ROGERS");
        enseignant.setPrenom("Steve");
        enseignant.setEmail("cap@email.com");
        enseignant.setPassword("123456");
        enseignant.setIdCours(1);
        
        JLabel message = new JLabel();
        //coursImp.setNomCours("Anglais");
        etudiant.setNom("Parker");
        etudiant.setPrenom("Peter");
        etudiant.setEmail("spider@email.com");
        etudiant.setPassword("123421");
        etudiant.setNumeroEtudiant(1234523475);
        etudiant.setIdGroupe(4);
        //utilisateurImp.setDroit(1);
        //type.setNomTypeCours("MOOC");

        //typeCours.update(type, 5, "nom", "Soutien");
        //typeCours.delete(type, 2);
        //typeCours.getById(type, 2);
        //typeCours.getByString(type, "nom", "MOOC");
        
        //cours.delete(coursImp, "cours", 4);
        //cours.getByString(coursImp, "nom", "informatique");
        cours.update(coursImp, 3, "nom", "Physique");
        
        //promotion.setNomPromo("2023");
        //promotionDAO.add(promotion);
        //promotionDAO.update(promotion, 1, "nom", "2020");
        //promotionDAO.delete(promotion, 6);
        //promotionDAO.getById(promotion, 2);
        //promotionDAO.getByString(promotion, "nom", "2020");
        
        //groupe.setNomGroupe("TD 2");
        //groupe.setIdPromo(2);
        //groupeDAO.add(groupe);
        //groupeDAO.update(groupe, 2, "nom", "TD 9");
        //groupeDAO.updateIdPromo(groupe, 2, 1);
        //groupeDAO.delete(groupe, 3);
        //groupeDAO.getById(groupe, 1, message);
        //groupeDAO.getByString(groupe, "nom", "TD 5");
        
        //etudiantDAO.add(etudiant);
        //etudiantDAO.update(etudiant, 61, "numero", "123");
        //etudiantDAO.delete(etudiant, 63);
        //etudiantDAO.getById(etudiant, 64);
        //etudiantDAO.getByString(etudiant, "prenom", "Steve");
        
        //site.setNomSite("Eiffel 1");
        //siteDAO.add(site);
        //siteDAO.update(site, 3, "nom", "Eiffel 4");
        //siteDAO.delete(site, 1);
        //siteDAO.getById(site, 1);
        //siteDAO.getByString(site, "nom", "Eiffel 2");
        
        //salle.setNomSalle("G017");
        //salle.setCapacite(40);
        //salle.setIdSite(4);
        //salleDAO.add(salle);
        //salleDAO.update(salle, 1, "capacite", "50");
        //salleDAO.getById(salle, 1);
        //salleDAO.getByString(salle, "id_site", "4");
        
        //utilisateur.add(utilisateurImp);
        //enseignantDAO.add(enseignant);
        //utilisateur.getById(utilisateurImp, 59);
        //utilisateur.getByString(utilisateurImp, "prenom", "Steve");
        //utilisateur.deleteUtilisateur(utilisateurImp, utilisateurImp.getId());
        //enseignantDAO.getEnseignantByIdUtilisateur(enseignant, 2);
        //enseignantDAO.getById(enseignant, "id_utilisateur", 59);
        //enseignantDAO.update(enseignant, 65, "nom", "Hina");
        //utilisateur.update(utilisateurImp, 60, "nom", "Romanoff");
        //utilisateur.delete(utilisateurImp, "utilisateur", 2);
        
        seance.setDate("10/06/2020");
        seance.setEtat("Pas encore commencé");
        seance.setHeureDebut("15h00");
        seance.setHeureFin("16h30");
        seance.setIdCours(3);
        seance.setIdTypeCours(2);
        seance.setSemaine(31);
        
        seanceGroupe.setIdGroupe(1);
        seanceEnseignant.setIdUtilisateur(59);
        seanceSalle.setIdSalle(6);
        //seanceDAO.addSeance(seance, seanceGroupe, seanceEnseignant, seanceSalle);
        //seanceDAO.update(seance, 1, "etat", "En cours");
        //seanceDAO.delete(seance, 2);
        //seanceDAO.getById(seance, 15);
        //seanceDAO.getByString(seance, "semaine", "31");
        //seanceDAO.add(seance);
        
        
    }
    
    
}



