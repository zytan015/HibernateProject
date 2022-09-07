package org.dxc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        Date date = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= DateFormat.format(date);
        
        ClinicalData c1 = new ClinicalData(); //for patient 1
        c1.setComponentName("height");
        c1.setComponentValue(177);
        c1.setMeasuredDateTime(strDate);
        
        ClinicalData c2 = new ClinicalData(); //for patient 1
        c2.setComponentName("weight");
        c2.setComponentValue(65);
        c2.setMeasuredDateTime(strDate);
        
        ClinicalData c3 = new ClinicalData(); //for patient 2
        c3.setComponentName("height");
        c3.setComponentValue(163);
        c3.setMeasuredDateTime(strDate);
        
        ClinicalData c4 = new ClinicalData(); //for patient 2
        c4.setComponentName("weight");
        c4.setComponentValue(55);
        c4.setMeasuredDateTime(strDate);
        
        ArrayList<ClinicalData> list1 = new ArrayList<ClinicalData>();
    	list1.add(c1);
    	list1.add(c2);
    	
    	ArrayList<ClinicalData> list2 = new ArrayList<ClinicalData>();
    	list2.add(c3);
    	list2.add(c4);
    	
        Patient p1 = new Patient();
        p1.setFirstName("Jimmy");
        p1.setLastname("Ko");
        p1.setAge(25);
        
        p1.setClinicalData(list1);
        
        Patient p2 = new Patient();
        p2.setFirstName("Karen");
        p2.setLastname("Ho");
        p2.setAge(55);
        p2.setClinicalData(list2);
        
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
