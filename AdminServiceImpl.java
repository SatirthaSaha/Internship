package com.pack.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AdminDao;
import com.pack.entity.AdminDetails;
import com.pack.entity.BatchAllocate;
import com.pack.entity.BatchUpdate;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.Report;
import com.pack.entity.SkillMaster;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private SessionFactory sessionFactory;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Transactional
	public AdminDetails loginAdmin(Login login) {
		// TODO Auto-generated method stub

		System.out.println("inside service");
		return adminDao.loginAdmin(login);

	}

	@Transactional
	public void addBatch(BatchAllocate batchAllocate) {
		// TODO Auto-generated method stub
		adminDao.addBatch(batchAllocate);
	}

	@Transactional
	public void addFaculty(FacultyRegistration facultyRegistration) {
		// TODO Auto-generated method stub
		System.out.println("inside facultyreg service");
		adminDao.addFaculty(facultyRegistration);
	}

	@Transactional
	public void addAdmin(AdminDetails admin) {
		// TODO Auto-generated method stub
		adminDao.addAdmin(admin);

	}

	@Transactional
	public List<SkillMaster> getAllSkills() {
		return adminDao.getAllSkills();
	}

	@Transactional
	public List<FacultyRegistration> getAllFaculty() {
		// TODO Auto-generated method stub
		return adminDao.getAllFaculty();
	}

	@Transactional
	public List<BatchAllocate> getAllBatch() {
		// TODO Auto-generated method stub
		return adminDao.getAllBatch();
	}

	@Transactional
	public void updateBatch(BatchUpdate batchUpdate) {
		// TODO Auto-generated method stub
		adminDao.updateBatch(batchUpdate);
	}


	@Transactional
	public void module(Module module) {
		// TODO Auto-generated method stub
		adminDao.module(module);
	} 

	@Transactional
	public List<Module> getAllModule() {
		// TODO Auto-generated method stub
		return adminDao.getAllModule();
	}

	@Transactional
	public void addReport(Report report) {
		// TODO Auto-generated method stub
		System.out.println("inside facultyregistration dao");
		Session s=this.sessionFactory.openSession();
		//Transaction t=s.beginTransaction();
		Query q=s.createQuery("from Report l where l.batchid=:batchid");
		q.setParameter("batchid", report.getBatchid());
		Report l1= null;
		try
		{
			System.out.println("===================================");
			l1=(Report)q.uniqueResult();
			if(l1!=null)
			{
				//then update
				System.out.println("====================================================");
				adminDao.updateReport(report);
			}
			else
			{
				//then save
				adminDao.addReport(report);
			}
		}
		catch(Exception e)
		{
			System.out.println("inside catch");
		}

	}

	@Transactional
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return adminDao.checkEmail(email);
	}

	@Transactional
	public boolean checkAdminid(String admin) {
		// TODO Auto-generated method stub
		return adminDao.checkAdminid(admin);
	}
	
	@Transactional
	public boolean checkBatchid(String batch) {
		// TODO Auto-generated method stub
		return adminDao.checkBatchid(batch);
	}

	@Transactional
	public String fetchDate(String date) {
		// TODO Auto-generated method stub
		return adminDao.fetchDate(date);
	}
	
	
} 





