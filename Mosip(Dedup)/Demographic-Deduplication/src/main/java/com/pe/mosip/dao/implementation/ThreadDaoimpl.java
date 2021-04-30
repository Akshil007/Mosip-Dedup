package com.pe.mosip.dao.implementation;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.dao.ThreadDao;
import com.pe.mosip.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ThreadDaoimpl implements ThreadDao {
    @Override
    public void createTable(String ThreadName) {

        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            String sqlQuery = "CREATE TABLE " + ThreadName + " ( " +
                    "    id int,\n" +
                    "    full_name varchar(255),\n" +
                    "    gender varchar(255),\n" +
                    "    dob varchar(255),\n" +
                    "    address varchar(255) );";

            Query query=session.createSQLQuery(sqlQuery);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }finally {
            session.close();
        }

    }

    @Override
    public int insertRecords(ArrayList<Demo_Details> records , String ThreadName) {
        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            int i=0;
            for(Demo_Details demo_details:records)
            {
                String sqlQuery = "INSERT INTO "+ ThreadName + " VALUES (" +
                        "\"" + ++i +
                        "\", \"" + demo_details.getFull_name() +
                        "\", \"" + demo_details.getGender() +
                        "\" , \"" + demo_details.getDob() +
                        "\",\"" + demo_details.getAddress() + "\")";
                Query query=session.createSQLQuery(sqlQuery);
                query.executeUpdate();
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
    public Demo_Details getRecord(String id ,String ThreadName) {
        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            int ID=Integer.parseInt(id);
            Query query=session.createSQLQuery("SELECT * FROM "+ ThreadName + " WHERE id="+ID+";");
            ArrayList<Object[]> list=(ArrayList<Object[]>) query.getResultList();
            System.out.println("name"+list.get(0)[1]+"dob:"+list.get(0)[3]);
            if(list.size()==0)
                return null;
            else
            {
                Demo_Details demo_details = new Demo_Details();
                demo_details.setId((int)list.get(0)[0]);
                demo_details.setFull_name((String) list.get(0)[1]);
                demo_details.setGender((String) list.get(0)[2]);
                demo_details.setDob((String) list.get(0)[3]);
                demo_details.setAddress((String) list.get(0)[4]);
                return demo_details;
            }
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void dropTable(String ThreadName) {

        Session session = SessionUtil.getSession();
        try {
            session.beginTransaction();
            String sqlQuery = "DROP TABLE " + ThreadName+";";

            Query query=session.createSQLQuery(sqlQuery);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }finally {
            session.close();
        }

    }
}
