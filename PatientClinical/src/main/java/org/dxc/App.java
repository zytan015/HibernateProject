package org.dxc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dxc.entity.ClinicalData;
import org.dxc.entity.Patient;
import org.dxc.factorydesign.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Patient p1 = new Patient();
        p1.setFirstName("Jimmy");
        p1.setLastname("Ko");
        p1.setAge(25);
        
        Patient p2 = new Patient();
        p2.setFirstName("Karen");
        p2.setLastname("Ho");
        p2.setAge(55);
        
        Patient p3 = new Patient();
        p3.setFirstName("Peter");
        p3.setLastname("Le");
        p3.setAge(30);
        
        Date date = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= DateFormat.format(date);
        
        ClinicalData c1 = new ClinicalData();
        c1.setComponentName("height");
        c1.setComponentValue(177);
        c1.setMeasuredDateTime(strDate);
        
        ClinicalData c2 = new ClinicalData();
        c2.setComponentName("height");
        c2.setComponentValue(163);
        c2.setMeasuredDateTime(strDate);
        
        ClinicalData c3 = new ClinicalData();
        c3.setComponentName("height");
        c3.setComponentValue(180);
        c3.setMeasuredDateTime(strDate);
        
        p1.setClinical(c1);
        p2.setClinical(c2);
        p2.setClinical(c3);
        
        c1.setPatient(p1);
        c2.setPatient(p2);
        c3.setPatient(p3);
        
        SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
				//Get Session
				sessionFactory = HibernateFactory.getSessionFactory();
				session = sessionFactory.getCurrentSession();
				System.out.println("Session created");
				
				//start transaction
				tx = session.beginTransaction();
				
				//Save the Model object
				session.persist(p1);
				session.persist(p2);
				session.persist(p3);
				session.persist(c1);
				session.persist(c2);
				session.persist(c3);
				
				//Commit transaction
				tx.commit();
				
				}catch(Exception e){
					System.out.println("Exception occured. "+e.getMessage());
					e.printStackTrace();
				}finally{
					if(sessionFactory != null && !sessionFactory.isClosed()){
						System.out.println("Closing SessionFactory");
						sessionFactory.close();
					}
				}
    }
}
