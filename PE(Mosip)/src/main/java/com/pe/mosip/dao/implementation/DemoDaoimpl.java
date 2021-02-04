package com.pe.mosip.dao.implementation;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DemoDaoimpl implements DemoDao {
    @Override
    public int insert(Demo_Details demo_details) {
        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            session.save(demo_details);
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
