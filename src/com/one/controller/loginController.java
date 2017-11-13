package com.one.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.one.domian.Student;
import com.one.domian.leagueList;
import com.one.domian.question;
import com.one.domian.questionBankList;
import com.one.domian.teacher;
import com.one.servlet.loginServlet;

@Controller
@RequestMapping(value="/login")
public class loginController {

	@RequestMapping(value="")	
	public String Init(){
	 
		return "login";
		
	}
	//用户登录
	@RequestMapping(value="/login")	
	public String studentLogin(String name,String password, String type,RedirectAttributes attributes,Model model){
		if(type.equals("学生")){
			Student student=new Student();
			student.setName(name);
			student.setPassword(password);
			student.setType(type);
			loginServlet loginservlet=new loginServlet();
			String id=loginservlet.studentLogin(student);
			if(!id.equals("用户名或密码不正确")){
				//进入主页控制器查看题库
				String viewLogin="欢迎"+student.getName()+"同学登录";
				indexController indexcontroller=new indexController();
				List<question> question=indexcontroller.studentSuccess();
				//进入主页控制器查看成绩
				indexController indexcontroller1=new indexController();
				indexController indexcontroller2=new indexController();
				List<leagueList> leagueList=indexcontroller2.studentResults(student);
				List<questionBankList> studentsubject=indexcontroller1.studentsubject(student);
				model.addAttribute("studentsubject",studentsubject);
				model.addAttribute("leagueList", leagueList);
				model.addAttribute("question",question);
				model.addAttribute("viewLogin", viewLogin);
				model.addAttribute("password", student.getPassword());
				model.addAttribute("id", id);
				return "index";
			}else{
				attributes.addFlashAttribute("viewLogin", id);
				return "redirect:/login";
			}
			
		}else if(type.equals("教师")){
			teacher teacher=new teacher();
			teacher.setName(name);
			teacher.setPassword(password);
			teacher.setType(type);
			loginServlet loginservlet=new loginServlet();
			String id=loginservlet.teacherLogin(teacher);
			if(!id.equals("用户名或密码不正确")){
				String viewLogin="欢迎"+teacher.getName()+"教师登录";
				model.addAttribute("viewLogin", viewLogin);
				model.addAttribute("id", id);
				model.addAttribute("password", teacher.getPassword());
				indexController indexController=new indexController();
				List<Object[]> listt=indexController.selectbg();
				model.addAttribute("listt",listt);
				return "index";
			}else{
				
				attributes.addFlashAttribute("viewLogin", id);
				return "redirect:/login";
			}
			
		}else {
			
			
			
			return "login";
		}
	
	}
	
	/*//用户注册
		@RequestMapping(value="/Registered")	
		public void studentRegistered(Student student,HttpServletResponse response) throws IOException{
			    student.setType("学生");
				loginServlet loginservlet=new loginServlet();
				String viewRegistered=loginservlet.studentRegistered(student);
				response.setContentType(viewRegistered);
				response.setContentType("text/html");
				response.getWriter().print(viewRegistered);
			
		}*/
	
}
