package com.pack.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pack.entity.AdminDetails;
import com.pack.entity.BatchAllocate;
import com.pack.entity.BatchAllocation;
import com.pack.entity.BatchUpdate;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.Report;
import com.pack.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	//--------------------------OPENS LOGIN PAGE----------------------------------------
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		return "login";
	}

	//-------------------------VALIDATES USERNAME AND PASSWORD--------------------------
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute(value = "login") Login login, ModelMap model, HttpSession session) {
		String r = "denied";

		System.out.println("Inside admin controller");
		AdminDetails l = null;
		l = adminService.loginAdmin(login);
		if (l != null) {
			r = "redirect:/home";
			//model.addAttribute("adminDetails", l);
			session.setAttribute("adminDetails", l);
		}
		return r;
	}

	//-------------------------OPENS BATCH ALLOCATION PAGE------------------------------
	
	@RequestMapping(value = "/BatchAllocation", method = RequestMethod.GET)
	public String batchAllocation(ModelMap model) {
		System.err.println("Inside batchAllocation controller");
		model.addAttribute("batchAllocate", new BatchAllocate());
		model.addAttribute("faculty", adminService.getAllFaculty());
		return "BatchAllocation";
	}

	//-------------------------ADDS A NEW BATCH------------------------------------------
	
	@RequestMapping(value = "/addBatch", method = RequestMethod.POST)
	public String addBatch(@ModelAttribute(value = "batchAllocate")BatchAllocate batchAllocate,ModelMap model){
		System.out.println("Inside addBatch controller");
		
		/*String startDatestr = request.getParameter("nday");
		String endDatestr = request.getParameter("eday");
		String closeDatestr = request.getParameter("cday");

		System.out.println(startDatestr);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH24:MI:SS");

		Date startDate = sdf.parse(startDatestr);
		Date endDate = sdf.parse(endDatestr);
		Date closeDate = sdf.parse(closeDatestr);

		java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
		java.sql.Date sqlCloseDate = new java.sql.Date(closeDate.getTime());
		
		batchAllocation.setStart_date(sqlStartDate);
		batchAllocation.setEnd_date(sqlEndDate);
		batchAllocation.setClose_date(sqlCloseDate);*/
		
		/*model.addAttribute("batchAllocation", new BatchAllocation());*/
		model.addAttribute("batchAllocate", new BatchAllocate());
		adminService.addBatch(batchAllocate);
		
		/*model.addAttribute("addFaculty", new FacultyRegistration());
		adminService.addFaculty(facultyRegistration);*/
		
		return "redirect:/home";
	}

	//---------------------------OPENS BATCH UPDATE PAGE--------------------------------
	
	@RequestMapping(value = "/BatchUpdation", method = RequestMethod.GET)
	public String batchUpdation(ModelMap model) {
		System.err.println("Inside batchUpdation controller");
		model.addAttribute("batchAllocate", new BatchAllocate());
		model.addAttribute("batchUpdate", new BatchUpdate());
		List<BatchAllocate> l=adminService.getAllBatch();
		model.addAttribute("batch", l);
		System.out.println("----------------------------------------------"+l.get(0));
		return "BatchUpdate";
	}

	//--------------------------OPENS HOME PAGE------------------------------------------
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		System.err.println("Inside home controller");
		model.addAttribute("batchAllocation", new BatchAllocation());
		return "Home";
	}
	
	//-------------------------OPENS LOG OPTIONS PAGE-------------------------------------
	
	@RequestMapping(value = "/logOption", method = RequestMethod.GET)
	public String logOption(ModelMap model) {
		System.err.println("Inside logOption controller");
		model.addAttribute("login", new Login());
		return "LogOption";
	}

	//-------------------------OPENS SIGN UP PAGE----------------------------------------
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		model.addAttribute("addadmin",new AdminDetails());
		return "SignUp";
	}

	//-------------------------OPENS FACULTY REGISTRATION PAGE---------------------------
	
	@RequestMapping(value = "/addFaculty", method = RequestMethod.GET)
	public String addFaculty(ModelMap model) {
		System.err.println("Inside add faculty controller");
		model.addAttribute("addFaculty", new FacultyRegistration());
		model.addAttribute("skillMaster", adminService.getAllSkills());
		return "AddFaculty";
	}

	//-------------------------ADDS NEW FACULTY-------------------------------------------
	
	@RequestMapping(value = "/facultyRegistration", method = RequestMethod.POST)
	public String facultyRegistration(@ModelAttribute(value = "addFaculty") FacultyRegistration facultyRegistration,
			ModelMap model) {
		System.err.println("Inside faculty registration controller");
		model.addAttribute("addFaculty", new FacultyRegistration());
		Random r=new Random();
    	int num=r.nextInt(900000)+100000;
    	String str=Integer.toString(num);
    	str="T-"+str;
    	facultyRegistration.setFacultyid(str);
    	/*System.out.println(facultyRegistration.getFacultyid()+"---------------------------------------------------");*/
		adminService.addFaculty(facultyRegistration);
		return "FacultyAddedConfirmation";
	}
	
	//--------------------------ADDS NEW ADMIN-------------------------------------------------
	
	@RequestMapping(value="/addadmin", method= RequestMethod.POST)
	public String addAdmin(	@ModelAttribute(value = "addadmin") AdminDetails admin1, ModelMap model)
	{
		System.out.println("inside ADD ADMIN");
		model.addAttribute("addadmin", new AdminDetails());
		adminService.addAdmin(admin1);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "AdminAddedConfirmation";
		
	}
	
	@RequestMapping(value="/checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam String email)
	{
		System.out.println("=========================check email controller=====================");
		if(adminService.checkEmail(email))
		{
			return "Email is Available";
		}
		else
			return "Email id is taken";
	}
	
	//-------------------------------------------------------------
	
	@RequestMapping(value="/checkAdminid")
	@ResponseBody
	public String checkAdminid(@RequestParam String admin)
	{
		System.out.println("=========================check email controller=====================");

		if(adminService.checkAdminid(admin))
		{
			return "Admin Id is Available";
		}
		else
			return "Admin Id is taken";
	}
	
	//---------------------------------------------------------------
	
	@RequestMapping(value="/checkBatchid")
	@ResponseBody
	public String checkBatchid(@RequestParam String batch)
	{
		System.out.println("=========================check batch controller=====================");

		if(adminService.checkBatchid(batch))
		{
			return "Batch Id is Available";
		}
		else
			return "Batch Id is taken";
	}
	
	//-------------------------------------------------------------------
	
	@RequestMapping(value="/fetchDate")
	@ResponseBody
	public String fetchDate(@RequestParam String date)
	{
		System.out.println("=========================fetch date controller=====================");

		return adminService.fetchDate(date);
	}
	
	//-------------------------UPDATE BATCH -----------------------------------------------------
	
	@RequestMapping(value="/updateBatch", method=RequestMethod.POST)
	public String updateBatch( @ModelAttribute(value="batchUpdate")BatchUpdate batchUpdate,BatchAllocate batchAllocate, ModelMap model)
	{
		model.addAttribute("batchAllocate", new BatchAllocate());
		model.addAttribute("batchUpdate", new BatchUpdate());
		
		adminService.updateBatch(batchUpdate);
		System.out.println(batchAllocate.getBatchid());
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/module", method = RequestMethod.GET)
	public String moduleopen(ModelMap model) {
	
		System.err.println("Inside module controller");
		model.addAttribute("login", new Login());
		model.addAttribute("module", new Module());
		model.addAttribute("skillMaster", adminService.getAllSkills());
		return "Module";
	} 
	
	@RequestMapping(value="/module1", method= RequestMethod.POST)
	public String module(	@ModelAttribute(value = "module") Module m,ModelMap model)
	{
		//model.addAttribute("addFaculty", new FacultyRegistration());
		Random r=new Random();
		int num=r.nextInt(90000)+10000;
		String str=Integer.toString(num);
		str="B-"+str;
		m.setModuleid(str);
		adminService.module(m);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "ModuleAddedConfirmation";
		
	} 
	
	@RequestMapping(value = "/viewfaculty", method = RequestMethod.GET)
	public String viewfaculty(ModelMap model) {
	
		System.err.println("Inside viewfaculty controller");
		model.addAttribute("listUsers", adminService.getAllFaculty());
		model.addAttribute("faculty", new FacultyRegistration());
		return "ViewFaculty";
	}
	@RequestMapping(value = "/viewmodule", method = RequestMethod.GET)
	public String viewmodule(ModelMap model) {
	
		System.err.println("Inside viewfaculty controller");
		model.addAttribute("listModules", adminService.getAllModule());
		model.addAttribute("module", new Module());
		return "ViewModule";
	} 
	
	//----------------------Logout page-------------------------
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(HttpSession session) {
		session.invalidate();
		return "redirect:/logOption";
	}
	
	/*----------------------OPENS REPORT PAGE------------------------------*/
	
	@RequestMapping(value="/report", method= RequestMethod.GET)
	public String report(ModelMap model)
	{
		System.out.println("Inside Report");
		model.addAttribute("reportcalc1", new Report());
		model.addAttribute("batchAllocate",new BatchAllocate());
		model.addAttribute("batch", adminService.getAllBatch());
		return "ReportGen";
	}
	
	/*----------------------CALCULATES REPORT------------------------------*/
	
	@RequestMapping(value="/reportcalc", method= RequestMethod.POST)
	public String addAdmin(	@ModelAttribute(value="reportcalc1")Report report, ModelMap model, BatchAllocate batchAllocate)
	{
		System.out.println("inside ADD report");
		model.addAttribute("batchAllocate",new BatchAllocate());
		model.addAttribute("reportcalc1", new Report());
		int n=0;
		if(report.getWeeklyproject()==0)
			n=0;
		if((report.getWeeklyproject()==1)||(report.getWeeklyproject()==2))
			n=5;
		if((report.getWeeklyproject()==3)||(report.getWeeklyproject()==4))
			n=10;
		report.setWeeklyproject(n);
		if(report.getMock()==0)
			n=0;
		if(report.getMock()==1)
			n=5;
		if(report.getMock()==2)
			n=8;
		if(report.getMock()==3)
			n=10;
		report.setMock(n);
		adminService.addReport(report);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "redirect:/home";
		
	}
	
	
	
}
