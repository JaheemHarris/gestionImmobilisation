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

/**
 *
 * @author jaheem
 */
@Entity
@Table(name="view_details_immobilisation")
public class DetailsImmobilisation extends BaseModel{
    
    @Column(name="idarticle")
    private int idArticle;
    
    private String article;
    
    @Column(name="idtypeammortissement")
    private int idTypeAmmortissement;
    
    private String type;
    
    @Column(name="prixacquisition")
    private double prixAcquisition;
    
    @Column(name="dateachat")
    private Date dateAchat;
    
    @Column(name="datemiseenservice")
    private Date dateMiseEnService;
    
    @Column(name="dureeammortissement")
    private int dureeAmmortissement;

    public DetailsImmobilisation() {
    }

    public DetailsImmobilisation(int idArticle, String article, int idTypeAmmortissement, String type, double prixAcquisition, Date dateAchat, Date dateMiseEnService, int dureeAmmortissement) {
        this.idArticle = idArticle;
        this.article = article;
        this.idTypeAmmortissement = idTypeAmmortissement;
        this.type = type;
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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getIdTypeAmmortissement() {
        return idTypeAmmortissement;
    }

    public void setIdTypeAmmortissement(int idTypeAmmortissement) {
        this.idTypeAmmortissement = idTypeAmmortissement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
