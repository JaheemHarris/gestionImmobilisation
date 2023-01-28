/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jaheem
 */

@Entity
@Table(name="typeammortissement")
public class TypeAmmortissement extends BaseModel{
    
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
