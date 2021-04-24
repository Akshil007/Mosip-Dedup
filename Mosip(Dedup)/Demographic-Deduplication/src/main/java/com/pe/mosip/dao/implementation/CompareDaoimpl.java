package com.pe.mosip.dao.implementation;

import com.pe.mosip.bean.Compare_Record;
import com.pe.mosip.dao.CompareDao;
import com.pe.mosip.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;

public class CompareDaoimpl implements CompareDao {
    @Override
    public int insert(ArrayList<Compare_Record> compare_records) {
        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            Query query=session.createQuery("delete from Compare_Record");
            query.executeUpdate();
            for(Compare_Record c:compare_records)
            {
                session.save(c);
            }
            session.getTransaction().commit();
            session.close();
            return 200;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return 203;
        }finally {
            session.close();
        }
    }

    @Override
    public Compare_Record get_record(String id) {
        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            int ID=Integer.parseInt(id);
            Query query=session.createQuery("from Compare_Record where id=:id");
            query.setParameter("id",ID);
            ArrayList<Compare_Record> list= (ArrayList<Compare_Record>) query.getResultList();
            if(list.size()==0)
                return null;
            else
                return list.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }


}
