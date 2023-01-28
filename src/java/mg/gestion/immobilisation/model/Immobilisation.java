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
@Table(name="immobilisation")
public class Immobilisation extends BaseModel{
    
    @Column(name="idarticle")
    private int idArticle;
    
    @Column(name="idtypeammortissement")
    private int idTypeAmmortissement;
    
    @Column(name="prixacquisition")
    private double prixAcquisition;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dateachat")
    private Date dateAchat;
    
    @Temporal(TemporalType.DATE)
    @Column(name="datemiseenservice")
    private Date dateMiseEnService;
    
    @Column(name="dureeammortissement")
    private int dureeAmmortissement;

    public Immobilisation() {
    }
    
    

    public Immobilisation(int idArticle, int idTypeAmmortissement, double prixAcquisition, Date dateAchat, Date dateMiseEnService, int dureeAmmortissement) {
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

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public int getDureeAmmortissement() {
        return dureeAmmortissement;
    }

    public void setDureeAmmortissement(int dureeAmmortissement) {
        this.dureeAmmortissement = dureeAmmortissement;
    }

    
}
