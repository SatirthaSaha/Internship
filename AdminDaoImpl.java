package com.pack.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.pack.entity.AdminDetails;
import com.pack.entity.BatchAllocate;
import com.pack.entity.BatchUpdate;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.Report;
import com.pack.entity.SkillMaster;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;


	public AdminDetails loginAdmin(Login login) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		//Transaction t=s.beginTransaction();
		System.out.println(login.getUsername());
		System.out.println(login.getPassword());
		Query q=s.createQuery("from AdminDetails l where l.adminid=:username and l.password=:password");
		q.setParameter("username", login.getUsername());
		q.setParameter("password", login.getPassword());
		AdminDetails l1= null;
		try
		{
			l1=(AdminDetails)q.uniqueResult();
			System.out.println("-------------------"+l1.getAdminid());
			return l1;
		}
		catch(Exception e)
		{
			System.out.println("======================================mmmmmm");
			return null;
		}
	}


	public void addBatch(BatchAllocate batchAllocate) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(batchAllocate);
	}


	public void addFaculty(FacultyRegistration facultyRegistration) {
		// TODO Auto-generated method stub
		System.out.println("inside facultyregistration dao");
		this.sessionFactory.getCurrentSession().save(facultyRegistration);
	}

	public void addAdmin(AdminDetails admin) {
		this.sessionFactory.getCurrentSession().save(admin);
		Session s = this.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Login login=new Login();
		login.setUsername(admin.getAdminid());
		login.setPassword(admin.getPassword());
		this.sessionFactory.getCurrentSession().save(login);


	}

	public List<SkillMaster> getAllSkills() {
		// TODO Auto-generated method stub
		List<SkillMaster> l=new ArrayList();
		l=this.sessionFactory.getCurrentSession().createQuery("from SkillMaster").list();
		/*return this.sessionFactory.getCurrentSession().createQuery("from SkillMaster").list();*/
		System.out.println(l);
		return l;
	}


	public List<FacultyRegistration> getAllFaculty() {
		// TODO Auto-generated method stub
		List<FacultyRegistration> l=new ArrayList();
		l=this.sessionFactory.getCurrentSession().createQuery("from FacultyRegistration").list();
		return l;
	}



	public List<BatchAllocate> getAllBatch() {
		// TODO Auto-generated method stub
		List<BatchAllocate> l=new ArrayList();
		l=this.sessionFactory.getCurrentSession().createQuery("from BatchAllocate").list();
		return l;
	}



	public void updateBatch(BatchUpdate batchUpdate) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("update BatchAllocate b set b.closedate=:closedate where b.batchid=:batchid");
		q.setParameter("closedate", batchUpdate.getClosedate());
		q.setParameter("batchid", batchUpdate.getBatchid());
		System.out.println("---------------------------------"+batchUpdate.getBatchid());
		System.out.println("---------------------------------"+batchUpdate.getClosedate());
		q.executeUpdate();
		t.commit();
	}

	public void module(Module module) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(module);

	} 


	@Override
	public List<Module> getAllModule() {
		// TODO Auto-generated method stub
		List<Module> m=new ArrayList();
		m=this.sessionFactory.getCurrentSession().createQuery("from Module").list();
		return m;
	} 

	public void addReport(Report report) {
		// TODO Auto-generated method stub
		/*System.out.println("inside facultyregistration dao");
		Session s=this.sessionFactory.openSession();
		//Transaction t=s.beginTransaction();
		Query q=s.createQuery("from Report l where l.batchid=:batchid");
		q.setParameter("batchid", report.getBatchid());
		Report l1= null;
		try
		{
			l1=(Report)q.uniqueResult();
			if(l1!=null)
			{
				//then update
				Transaction t=s.beginTransaction();
				Query q1=s.createQuery("update Report r set r.weeklyproject=:weeklyproject, r.bhs=:bhs, r.mock=:mock, r.innovation=:innovation where r.batchid=:batchid");
				q.setParameter("weeklyproject", report.getWeeklyproject());
				q.setParameter("bhs", report.getBhs());
				q.setParameter("mock", report.getMock());
				q.setParameter("innovation", report.getInnovation());
				q.setParameter("batchid", report.getBatchid());
				q.executeUpdate();
				t.commit();
			}
			else
			{
				//then save
				this.sessionFactory.getCurrentSession().save(report);
			}
		}
		catch(Exception e)
		{
			System.out.println("inside catch");
		}*/
		
		this.sessionFactory.getCurrentSession().save(report);
		
	}
	
	public void updateReport(Report report)
	{
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("update Report r set r.weeklyproject=:weeklyproject, r.bhs=:bhs, r.mock=:mock, r.innovation=:innovation where r.batchid=:batchid");
		q.setParameter("weeklyproject", report.getWeeklyproject());
		q.setParameter("bhs", report.getBhs());
		q.setParameter("mock", report.getMock());
		q.setParameter("innovation", report.getInnovation());
		q.setParameter("batchid", report.getBatchid());
		q.executeUpdate();
		t.commit();
	}


	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		AdminDetails l=null;
		Session s=this.sessionFactory.openSession();
		//Transaction t=s.beginTransaction();
		try
		{
			Query q=s.createQuery("from AdminDetails l where l.emailid=:email");
			q.setParameter("email", email);
			l= (AdminDetails) q.uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		s.close();
		System.out.println("================================checkmail===============================");
		if(l == null)
			return true;
		return false;
	}


	
	public boolean checkAdminid(String admin) {
		// TODO Auto-generated method stub
		AdminDetails l=null;
		Session s=this.sessionFactory.openSession();
		//Transaction t=s.beginTransaction();
		try
		{
			Query q=s.createQuery("from AdminDetails l where l.adminid=:admin");
			q.setParameter("admin", admin);
			l= (AdminDetails) q.uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		s.close();
		System.out.println("==========================================checkadminid====================");
		if(l == null)
			return true;
		return false;
	}

	public boolean checkBatchid(String batch) {
		// TODO Auto-generated method stub
		BatchAllocate l=null;
		Session s=this.sessionFactory.openSession();
		//Transaction t=s.beginTransaction();
		try
		{
			Query q=s.createQuery("from BatchAllocate l where l.batchid=:batch");
			q.setParameter("batch", batch);
			l= (BatchAllocate) q.uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		s.close();
		System.out.println("==========================================checkbatchid====================");
		if(l == null)
			return true;
		return false;
	}
	
	public String fetchDate(String date) {
		// TODO Auto-generated method stub
		BatchAllocate l=null;
		Session s=this.sessionFactory.openSession();
		String str=null;
		//Transaction t=s.beginTransaction();
		try
		{
			Query q=s.createQuery("from BatchAllocate l where l.batchid=:batch");
			q.setParameter("batch", date);
			l= (BatchAllocate) q.uniqueResult();
			str=l.getStartdate();
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		s.close();
		System.out.println("==========================================checkbatchid====================");
		/*if(l == null)
			return true;*/
		return str;
	}
	
}
