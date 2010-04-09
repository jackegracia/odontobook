package edu.austral.lab1.odontobook.model;


import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

        //~ Methods ..............................................................................................

    /**
     * Returns the original Hibernate configuration.
     *
     * @return Configuration
     */
    public static Configuration getConfiguration()
    {
        return configuration;
    }

    public static Session getSession()
    {
        Session s = threadSession.get();

        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            threadSession.set(s);
        }

        return s;
    }

    /**
     * Start a new database transaction.
     */
    public static void beginTransaction()
        throws InfrastructureException
    {
        Transaction tx = threadTransaction.get();

        try {
            if (tx == null) {
                System.out.println("Starting new database transaction in this thread.");
                tx = getSession().beginTransaction();
                threadTransaction.set(tx);
            }
        }
        catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }

    public static void closeSession()
    {
        Session s = threadSession.get();

        if (s != null && s.isOpen()) {
            s.close();
        }

        threadSession.set(null);
        threadTransaction.set(null);
    }

    /**
     * Commit the database transaction.
     */
    public static void commitTransaction()
        throws InfrastructureException
    {
        Transaction tx = threadTransaction.get();

        try {
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                System.out.println("Committing database transaction of this thread.");
                tx.commit();
            }

            threadTransaction.set(null);
        }
        catch (HibernateException ex) {
            rollbackTransaction();
            throw new InfrastructureException(ex);
        }
    }

    public static void createSchema()
    {
        Configuration c = new Configuration().configure("/hibernate.cfg.xml");

        SchemaExport se = new SchemaExport(c);
        se.setOutputFile("resources_schema_export.sql");
        se.create(true, true);
    }

    /**
    * Disconnect and return Session from current Thread.
    *
    * @return Session the disconnected Session
    */
    public static Session disconnectSession()
        throws InfrastructureException
    {
        Session session = getSession();

        try {
            threadSession.set(null);

            if (session.isConnected() && session.isOpen()) {
                session.disconnect();
            }
        }
        catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }

        return session;
    }

    /**
     * Rebuild the SessionFactory with the static Configuration.
     *
     */
    public static void rebuildSessionFactory()
        throws InfrastructureException
    {
        synchronized (sessionFactory) {
            try {
                sessionFactory = getConfiguration().buildSessionFactory();
            }
            catch (Exception ex) {
                throw new InfrastructureException(ex);
            }
        }
    }

    /**
     * Rebuild the SessionFactory with the given Hibernate Configuration.
     *
     * @param cfg
     */
    public static void rebuildSessionFactory(Configuration cfg)
        throws InfrastructureException
    {
        synchronized (sessionFactory) {
            try {
                sessionFactory = cfg.buildSessionFactory();
                configuration = cfg;
            }
            catch (Exception ex) {
                throw new InfrastructureException(ex);
            }
        }
    }

    /**
     * Reconnects a Hibernate Session to the current Thread.
     *
     * @param session The Hibernate Session to be reconnected.
     */
    public static void reconnect(Session session)
        throws InfrastructureException
    {
        try {
            session.reconnect();
            threadSession.set(session);
        }
        catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }

    /**
     * Commit the database transaction.
     */
    public static void rollbackTransaction()
        throws InfrastructureException
    {
        Transaction tx = threadTransaction.get();

        try {
            threadTransaction.set(null);

            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                System.out.println("Tyring to rollback database transaction of this thread.");
                tx.rollback();
            }
        }
        catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
        finally {
            closeSession();
        }
    }

    //~ Static fields/initializers ...........................................................................

    //private static Log log = LogFactory.getLog(HibernateUtil.class);
    private static Configuration     configuration;
    private static SessionFactory    sessionFactory;
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();

    static {
        try {
            // Create the SessionFactory
            configuration = new Configuration().configure("/hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            //log.error("Initial SessionFactory creation failed.", ex);
            System.out.println("Initial SessionFactory creation failed.");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
}
