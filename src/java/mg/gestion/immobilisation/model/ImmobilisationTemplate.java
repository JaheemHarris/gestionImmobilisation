/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.model;

/**
 *
 * @author jaheem
 */
public class ImmobilisationTemplate {
    private int idArticle;
    private int idTypeAmmortissement;
    private double prixAcquisition;
    private String dateAchat;
    private String dateMiseEnService;
    private int dureeAmmortissement;

    public ImmobilisationTemplate() {
    }
    
    

    public ImmobilisationTemplate(int idArticle, int idTypeAmmortissement, double prixAcquisition, String dateAchat, String dateMiseEnService, int dureeAmmortissement) {
        this.idArticle = idArticle;
        this.idTypeAmmortissement = idTypeAmmortissement;
        this.prixAcquisition = prixAcquisition;
        this.dateAchat = dateAchat;
        this.dateMiseEnService = dateMiseEnService;
        this.dureeAmmortissement = dureeAmmortissement;
    }
    
    

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdTypeAmmortissement() {
        return idTypeAmmortissement;
    }

    public void setIdTypeAmmortissement(int idTypeAmmortissement) {
        this.idTypeAmmortissement = idTypeAmmortissement;
    }

    public double getPrixAcquisition() {
        return prixAcquisition;
    }

    public void setPrixAcquisition(double prixAcquisition) {
        this.prixAcquisition = prixAcquisition;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(String dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public int getDureeAmmortissement() {
        return dureeAmmortissement;
    }

    public void setDureeAmmortissement(int dureeAmmortissement) {
        this.dureeAmmortissement = dureeAmmortissement;
    }
}
