package org.sned.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sned.modal.dto.LoginModal;
import org.sned.modal.dto.UserRoleModal;

import org.sned.modal.dto.MedicalCompany;
import org.sned.modal.dto.Quantity;
import org.sned.modal.dto.Stock;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		LoginModal lm=new LoginModal();
		lm.setUsername("Sned");
		lm.setPassword("12345");
		
		UserRoleModal ur=new UserRoleModal();
		ur.setRoleName("Admin");
		ur.setLoginModal(lm);
		
		UserRoleModal ur2=new UserRoleModal();
		ur2.setRoleName("Admin2");
		ur2.setLoginModal(lm);
		
		lm.getUserRoleModal().add(ur);
		lm.getUserRoleModal().add(ur2);
		
		
		
		MedicalCompany mc=new MedicalCompany();
		mc.setCompany_Name("SNED Corporation");
		mc.setLedger_Number(457);
		mc.setEntry_Date(new Date());
		
		
		Quantity qrt=new Quantity();
		qrt.setTotalQuantity(Integer.parseInt("12"));
		qrt.setAvailableQuantity(Integer.parseInt("10"));
		
		float tn=12.5f;
		Stock st=new Stock();
		st.setManufactureDate(new Date());
		st.setExpiryDate(new Date());
		st.setPrize(tn);
		st.setQuantity(qrt);
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(lm);
		session.save(mc);
		session.save(st);
		session.getTransaction().commit();
		session.close();
		
	}

}
