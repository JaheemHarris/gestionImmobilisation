/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import mg.gestion.immobilisation.dao.HibernateDAO;
import mg.gestion.immobilisation.model.AmmortissementImmobilisation;
import mg.gestion.immobilisation.model.Article;
import mg.gestion.immobilisation.model.DetailsAmmortissement;
import mg.gestion.immobilisation.model.DetailsImmobilisation;
import mg.gestion.immobilisation.model.Immobilisation;
import mg.gestion.immobilisation.model.TypeAmmortissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaheem
 */
@Transactional
@Service
public class ImmobilisationService {
    
    @Autowired
    private HibernateDAO hibernateDao;
    
    public List<Article> getAllArticles() throws Exception {
        List<Article> articleList = new ArrayList<Article>();
        try{
              articleList  = hibernateDao.find(new Article());
            
        }catch(Exception e){
            throw e;
        }
        return articleList;
    }
    
    public List<TypeAmmortissement> getAllTypes() throws Exception{
        List<TypeAmmortissement> typeList = new ArrayList<TypeAmmortissement>();
        try{
            typeList = hibernateDao.find(new TypeAmmortissement());
        }catch(Exception e){
            throw e;
        }
        return typeList;
    }
    
    public Immobilisation ajouterImmobilisation(Immobilisation immobilisation,String dateAchat,String dateMiseEnService) throws Exception{
        Immobilisation immoResult = null;
        try{
            immobilisation.setDateAchat(new SimpleDateFormat("yyyy-MM-dd").parse(dateAchat));
            immobilisation.setDateMiseEnService(new SimpleDateFormat("yyyy-MM-dd").parse(dateMiseEnService));
            immoResult = (Immobilisation)hibernateDao.save(immobilisation);
            this.getAmmortissement(immoResult);
        }catch(Exception e){
            throw e;
        }
        return immoResult;
    }
    
    public List<DetailsImmobilisation> getListDetailsImmobilisation(String article,String date1,String date2,int page) throws Exception{
        List<DetailsImmobilisation> immobilisationDetailsList = new ArrayList<DetailsImmobilisation>();
        try{
            int nombreElement = 3;
            DetailsImmobilisation details = new DetailsImmobilisation();
            if(article!=null){
                if(!article.isEmpty()){
                    article = "%"+article+"%";
                    details.setArticle(article);
                }
            }
            immobilisationDetailsList = hibernateDao.findBetweenDatesWithPagination(details,"dateMiseEnService",date1,date2,page,nombreElement);
        }catch(Exception e){
            throw e;
        }
        return immobilisationDetailsList;
    }
    
    public int getCountDetailsImmobilisation(String article,String date1,String date2) throws Exception{
        int nombrePage = 0;
        try{
            int nombreElement = 3;
            DetailsImmobilisation details = new DetailsImmobilisation();
            if(article!=null){
                if(!article.isEmpty()){
                    article = "%"+article+"%";
                    details.setArticle(article);
                }
            }
            int size = hibernateDao.listCountBetweenDates(details, "dateMiseEnService", date1, date2);
            nombrePage = size/nombreElement;
            if(size % nombreElement > 0)
                nombrePage = nombrePage + 1;
            if(nombrePage==0)
                nombrePage = nombrePage + 1;
        }catch(Exception e){
            throw e;
        }
        return nombrePage;
    }
    
    public Immobilisation getImmobilisation(int id) throws Exception{
        Immobilisation immobilisation = null;
        try{
            Immobilisation immo = new Immobilisation();
            immo.setId(id);
            immobilisation = (Immobilisation)hibernateDao.findById(immo);
        }catch(Exception e){
            throw e;
        }
        return immobilisation;
    }
    
    public DetailsImmobilisation getDetailsImmobilisation(int idImmobilisatino) throws Exception{
        DetailsImmobilisation immobilisation = null;
        try{
            DetailsImmobilisation immo = new DetailsImmobilisation();
            immo.setId(idImmobilisatino);
            immobilisation = (DetailsImmobilisation)hibernateDao.findById(immo);
        }catch(Exception e){
            throw e;
        }
        return immobilisation;
    }
    
    public List<AmmortissementImmobilisation> getTableau(int idImmobilisation) throws Exception{
        List<AmmortissementImmobilisation> tableau = new ArrayList<AmmortissementImmobilisation>();
        AmmortissementImmobilisation ammort = null;
        try{
            ammort = new AmmortissementImmobilisation();
            ammort.setIdImmobilisation(idImmobilisation);
            tableau = hibernateDao.find(ammort);
        }catch(Exception e){
            throw e;
        }
        return tableau;
    }
    
    public List<DetailsAmmortissement> getDetailsAmmortissement(String annee,int page) throws Exception{
        List<DetailsAmmortissement> detailsList = new ArrayList<DetailsAmmortissement>();
        try{
            DetailsAmmortissement detailsAmmort = new DetailsAmmortissement();
            detailsAmmort.setAnnee(annee);
            detailsList = hibernateDao.findWithPagination(detailsAmmort, page, 5);
        }catch(Exception e){
            throw e;
        }
        return detailsList;
    }
    
    public int getCountDetailsAmmortissement(String annee) throws Exception{
        int nombrePage = 0;
        try{
            int nombreElement = 5;
            DetailsAmmortissement detailsAmmort = new DetailsAmmortissement();
            detailsAmmort.setAnnee(annee);
            int size = hibernateDao.listCount(detailsAmmort);
            nombrePage = size/nombreElement;
            if(size % nombreElement > 0)
                nombrePage = nombrePage + 1;
            if(nombrePage==0)
                nombrePage = nombrePage + 1;
        }catch(Exception e){
            throw e;
        }
        return nombrePage;
    }
    
    public double getSommePrixAcquisiton(List<DetailsImmobilisation> liste) {
        double somme = 0;
        for(DetailsImmobilisation details : liste){
            somme = somme+details.getPrixAcquisition();
        }
        return somme;
    }
    
    public double getSommeExercice(List<DetailsAmmortissement> liste) {
        double somme = 0;
        for(DetailsAmmortissement details : liste){
            somme = somme+details.getExercice();
        }
        return somme;
    }
    
    public void getAmmortissement(Immobilisation immobilisation) throws Exception{
        try{
            int duree = immobilisation.getDureeAmmortissement();
            Date dateMiseEnService = immobilisation.getDateMiseEnService();
            int debutAnnee = dateMiseEnService.getYear()+1900;
            int finAnnee = debutAnnee + duree;
            AmmortissementImmobilisation ammort = null;
            double prixAcquisition = immobilisation.getPrixAcquisition();
            double anterieur = 0;
//            double taux = 100/duree;
            double exercice = 0;
            double vnc = 0;
            double cumulee = 0;
            double jourAnnee = 360;
//            double taux = ((double)1)/((double)duree);
            double nbrJourService = (double)calculNbrJourService(dateMiseEnService);
            double prorataDebut = nbrJourService/jourAnnee;
            exercice = (prixAcquisition*prorataDebut)/((double)duree);
            double prorataFin = ((double)calculFinNbrJourService(dateMiseEnService))/jourAnnee;
            cumulee = anterieur+exercice;
            vnc = prixAcquisition - cumulee;
            DecimalFormat format = new DecimalFormat("0.00");
            for(int annee = debutAnnee;annee<=finAnnee;annee++){
                ammort = new AmmortissementImmobilisation();
                ammort.setIdImmobilisation(immobilisation.getId());
                ammort.setAnnee(String.valueOf(annee));
                ammort.setPrixAcquisition(prixAcquisition);
                ammort.setAnterieur(anterieur);
                ammort.setExercice(exercice);
                ammort.setCumulee(cumulee);
                ammort.setValeurNetComptable(vnc);
                ammort = (AmmortissementImmobilisation)hibernateDao.save(ammort);
                
                anterieur = cumulee;
                exercice = prixAcquisition/((double)duree);
                if(annee==finAnnee-1)
                    exercice = (prixAcquisition*prorataFin)/((double)duree);
                cumulee = anterieur+exercice;
                vnc = prixAcquisition-cumulee;
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public int calculNbrJourService(Date dateMiseEnService){
        int jour = dateMiseEnService.getDate();
        int mois = dateMiseEnService.getMonth();
        int moisService = 12-mois;
//        int jourService = (moisService*30)-jour+1;
        int jourService = (moisService*30);
        return jourService;
    }
    
    public int calculFinNbrJourService(Date dateMiseEnService){
        int jour = dateMiseEnService.getDate();
        int mois = dateMiseEnService.getMonth();
        int moisService = mois;
//        int jourService = (moisService*30)+jour-1;
        int jourService = (moisService*30);
        return jourService;
    }
}