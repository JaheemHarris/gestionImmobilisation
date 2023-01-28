/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.dao;

import java.util.Date;
import java.util.List;
import mg.gestion.immobilisation.model.BaseModel;

/**
 *
 * @author jaheem
 */
public interface InterfaceDAO {
    
    public BaseModel save(BaseModel baseModel) throws Exception;
    public BaseModel findById(BaseModel baseModel) throws Exception;
    public int listCount(BaseModel baseModel) throws Exception;
    public int listCountBetweenDates(BaseModel baseModel,String dateColumnName,String dateLower,String dateHigher) throws Exception;
    public List find(BaseModel baseModel) throws Exception;
    public List findWithPagination(BaseModel baseModel,int page,int numberOfElements) throws Exception;
    public List findBetweenDatesWithPagination(BaseModel baseModel,String dateColumnName,String dateLower,String dateHigher ,int page, int numberOfElements) throws Exception;
}