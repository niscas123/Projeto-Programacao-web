package DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DAOManager {

    private static final SessionFactory sessionFactory;
    private static Session s;

    static {

        try {

            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            s = sessionFactory.openSession();

        } catch (Throwable th) {

            System.err.println("Enitial SessionFactory creation failed" + th);

            throw new ExceptionInInitializerError(th);

        }

    }

    public static void persist(Object o) {

        s = sessionFactory.openSession();

        Transaction tr = s.beginTransaction();

        s.save(o);

        tr.commit();

        s.flush();
    }

    public static List recover(String hql) {

        s = sessionFactory.openSession();

        Transaction tr = s.beginTransaction();

        Query query = s.createQuery(hql);

        s.flush();

        return query.list();
    }

    public static List recover(Object o) {

        Criteria c = s.createCriteria(o.getClass());

        c.add(Example.create(o).enableLike(MatchMode.ANYWHERE).ignoreCase().excludeProperty("Codigo"));

        List l = c.list();
        s.flush();

        return l;
    }

    public static void update(Object o) {

        s = sessionFactory.openSession();

        Transaction tr = s.beginTransaction();

        s.update(o);

        tr.commit();

        s.flush();
    }

    public static void delete(Object o) {

        s = sessionFactory.openSession();

        Transaction tr = s.beginTransaction();

        s.delete(o);

        tr.commit();

        s.flush();
    }

    public static void main(String args[]) {
        SchemaExport se = new SchemaExport(new AnnotationConfiguration().configure());
        se.create(true, true);
    }

}
