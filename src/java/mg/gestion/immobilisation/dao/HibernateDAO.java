/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mg.gestion.immobilisation.model.BaseModel;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import static sun.security.krb5.Confounder.intValue;

/**
 *
 * @author jaheem
 */
public class HibernateDAO implements InterfaceDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public BaseModel save(BaseModel baseModel) throws Exception {
        Session session = null;
        Transaction transaction = null;
        Object id = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = session.save(baseModel);
            int savedId = (int)id;
            baseModel.setId(savedId);
            transaction.commit();
        }catch(Exception e){
            if(transaction!=null)
                transaction.rollback();
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
        return baseModel;
    }
    
    @Override
    public BaseModel findById(BaseModel baseModel) throws Exception{
        Session session = null;
        Criteria criteria = null;
        Object result = baseModel.getClass().newInstance();
        try{
            session = sessionFactory.openSession();
            criteria = session.createCriteria(baseModel.getClass());
            criteria.add(Restrictions.eq("id", baseModel.getId()));
            result =  baseModel.getClass().cast(criteria.uniqueResult());
        }catch(Exception e){
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
        return baseModel.getClass().cast(result);
    }
    
    @Override
    public int listCountBetweenDates(BaseModel baseModel,String dateColumnName,String dateLower,String dateHigher) throws Exception{
        Session session = null;
        Criteria criteria = null;
        int size = 0;
        try{
            session = sessionFactory.openSession();
            Example modelExample = Example.create(baseModel).enableLike().ignoreCase().excludeZeroes().ignoreCase();
            criteria = session.createCriteria(baseModel.getClass()).add(modelExample);
            if(dateLower!=null && dateHigher!=null){
                if(!dateLower.isEmpty() && !dateHigher.isEmpty()){
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateL = format.parse(dateLower);
                    Date dateH = format.parse(dateHigher);
                    criteria.add(Restrictions.between(dateColumnName, dateL, dateH));
                }
            }
            size = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        }catch(Exception e){
            throw e;
        }
        return size;
    }
    
    @Override
    public int listCount(BaseModel baseModel) throws Exception{
        Session session = null;
        Criteria criteria = null;
        int size = 0;
        try{
            session = sessionFactory.openSession();
            Example modelExample = Example.create(baseModel).enableLike().ignoreCase().excludeZeroes().ignoreCase();
            criteria = session.createCriteria(baseModel.getClass()).add(modelExample);
            size = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        }catch(Exception e){
            throw e;
        }
        return size;
    }
    
    @Override
    public List find(BaseModel baseModel) throws Exception{
        List<BaseModel> list = new ArrayList<BaseModel>();
        Session session = null;
        Criteria criteria = null;
        List resultList = new ArrayList();
        try{
            session = sessionFactory.openSession();
            Example modelExample = Example.create(baseModel).enableLike().ignoreCase().excludeZeroes().ignoreCase();;
            criteria = session.createCriteria(baseModel.getClass()).add(modelExample);
            list = criteria.list();
            for(int i=0;i<list.size();i++){
                resultList.add(baseModel.getClass().cast(list.get(i)));
            }
        }catch(HibernateException e){
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
        return resultList;
    }

    @Override
    public List findWithPagination(BaseModel baseModel, int page, int numberOfElements) throws Exception {
        List resultList = new ArrayList();
        Session session = null;
        Criteria criteria = null;
        try{
            session = sessionFactory.openSession();
            Example modelExample = Example.create(baseModel).enableLike().excludeZeroes().ignoreCase();
            criteria = session.createCriteria(baseModel.getClass()).add(modelExample);
            int offset = numberOfElements*(page-1);
            criteria.setFirstResult(offset);
            criteria.setMaxResults(numberOfElements);
            resultList = criteria.list();
        }catch(HibernateException e){
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
        return resultList;
    }
    
    @Override
    public List findBetweenDatesWithPagination(BaseModel baseModel,String dateColumnName,String dateLower,String dateHigher ,int page, int numberOfElements) throws Exception {
        List resultList = new ArrayList();
        Session session = null;
        Criteria criteria = null;
        try{
            session = sessionFactory.openSession();
            Example modelExample = Example.create(baseModel).enableLike().excludeZeroes().ignoreCase();
            criteria = session.createCriteria(baseModel.getClass()).add(modelExample);
            if(dateLower!=null && dateHigher!=null){
                if(!dateLower.isEmpty() && !dateHigher.isEmpty()){
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateL = format.parse(dateLower);
                    Date dateH = format.parse(dateHigher);
                    criteria.add(Restrictions.between(dateColumnName, dateL, dateH));
                }
            }
            int offset = numberOfElements*(page-1);
            criteria.setFirstResult(offset);
            criteria.setMaxResults(numberOfElements);
            resultList = criteria.list();
        }catch(HibernateException e){
            throw e;
        }finally{
            if(session!=null)
                session.close();
        }
        return resultList;
    }
}