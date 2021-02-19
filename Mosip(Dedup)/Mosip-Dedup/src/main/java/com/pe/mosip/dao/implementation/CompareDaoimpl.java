package com.pe.mosip.dao.implementation;

import com.pe.mosip.bean.Compare_Record;
import com.pe.mosip.dao.CompareDao;
import com.pe.mosip.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CompareDaoimpl implements CompareDao {
    @Override
    public int insert(Compare_Record compare_record) {
        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            Query query=session.createQuery("delete from Compare_Record");
            query.executeUpdate();

            session.save(compare_record);
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
}
