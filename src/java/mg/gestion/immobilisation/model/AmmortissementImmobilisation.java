/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jaheem
 */

@Entity
@Table(name="ammortissementimmobilisation")
public class AmmortissementImmobilisation extends BaseModel{
    
    @Column(name="idimmobilisation")
    private int idImmobilisation;
    
    private String annee;
    
    @Column(name="prixacquisition")
    private double prixAcquisition;
    
    private double anterieur;
    
    private double exercice;
    
    private double cumulee;
    
    @Column(name="valeurnetcomptable")
    private double valeurNetComptable;

    public AmmortissementImmobilisation() {
    }

    public AmmortissementImmobilisation(int idImmobilisation, String annee, double prixAcquisition, double anterieur, double exercice, double cumulee, double valeurNetComptable) {
        this.idImmobilisation = idImmobilisation;
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
