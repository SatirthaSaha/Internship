package com.pack.service;

import java.util.List;

import com.pack.entity.AdminDetails;
import com.pack.entity.BatchAllocate;
import com.pack.entity.BatchAllocation;
import com.pack.entity.BatchUpdate;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.Report;
import com.pack.entity.SkillMaster;

public interface AdminService {

	public AdminDetails loginAdmin(Login login);
	public void addBatch(BatchAllocate batchAllocate);
	public void addFaculty(FacultyRegistration facultyRegistration);
	public void addAdmin(AdminDetails admin);
	public List<SkillMaster> getAllSkills();
	public List<FacultyRegistration> getAllFaculty();
	public List<BatchAllocate> getAllBatch();
	public void updateBatch(BatchUpdate batchUpdate);
	public void module(Module module); 
	public List<Module> getAllModule();
	public void addReport(Report report);
	public boolean checkEmail(String email);
	public boolean checkAdminid(String admin);
	public boolean checkBatchid(String batch);
	public String fetchDate(String date);
}
