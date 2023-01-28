/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jaheem
 */
@Entity
@Table(name="view_details_ammortissement")
public class DetailsAmmortissement extends BaseModel{
    
    @Column(name="idimmobilisation")
    private int idImmobilisation;
    
    @Column(name="idarticle")
    private int idArticle;
    
    private String article;
    
    @Temporal(TemporalType.DATE)
    @Column(name="datemiseenservice")
    private Date dateMiseEnService;
    
    private String annee;
    
    @Column(name="prixacquisition")
    private double prixAcquisition;
    
    private double anterieur;
    
    private double exercice;
    
    private double cumulee;
    
    @Column(name="valeurnetcomptable")
    private double valeurNetComptable;

    public DetailsAmmortissement() {
    }

    public DetailsAmmortissement(int idImmobilisation, int idArticle, String article, Date dateMiseEnService, String annee, double prixAcquisition, double anterieur, double exercice, double cumulee, double valeurNetComptable) {
        this.idImmobilisation = idImmobilisation;
        this.idArticle = idArticle;
        this.article = article;
        this.dateMiseEnService = dateMiseEnService;
        this.annee = annee;
        this.prixAcquisition = prixAcquisition;
        this.anterieur = anterieur;
        this.exercice = exercice;
        this.cumulee = cumulee;
        this.valeurNetComptable = valeurNetComptable;
    }

    public int getIdImmobilisation() {
        return idImmobilisation;
    }

    public void setIdImmobilisation(int idImmobilisation) {
        this.idImmobilisation = idImmobilisation;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public double getPrixAcquisition() {
        return prixAcquisition;
    }

    public void setPrixAcquisition(double prixAcquisition) {
        this.prixAcquisition = prixAcquisition;
    }

    public double getAnterieur() {
        return anterieur;
    }

    public void setAnterieur(double anterieur) {
        this.anterieur = anterieur;
    }

    public double getExercice() {
        return exercice;
    }

    public void setExercice(double exercice) {
        this.exercice = exercice;
    }

    public double getCumulee() {
        return cumulee;
    }

    public void setCumulee(double cumulee) {
        this.cumulee = cumulee;
    }

    public double getValeurNetComptable() {
        return valeurNetComptable;
    }

    public void setValeurNetComptable(double valeurNetComptable) {
        this.valeurNetComptable = valeurNetComptable;
    }
}
