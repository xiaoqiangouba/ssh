package com.one.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.one.domian.Student;
import com.one.domian.leagueList;
import com.one.domian.question;
import com.one.domian.questionBankList;
import com.one.domian.teacher;
import com.one.servlet.importServlet;
import com.one.servlet.loginServlet;
import com.one.servlet.selectTopicServlet;
import com.one.servlet.uploadReportServlet;
import com.one.servlet.writeServlet;

@Controller
@RequestMapping(value="/index")
public class indexController {

	@Autowired
	private HttpServletRequest request;
	@RequestMapping(value="")
	public String Init(Model model){
		selectTopicServlet selectTopicServlet=new selectTopicServlet();
		List<teacher> list=selectTopicServlet.selectter();
		model.addAttribute("list", list);
		return "administrator";
		
	}
	
	//删除教师信息
	@RequestMapping(value="/delecttea")
	public String delecttea(String name, String password,RedirectAttributes attributes){
		selectTopicServlet selectTopicServlet=new selectTopicServlet();
		String delecttea=selectTopicServlet.delecttea(name, password);
		attributes.addFlashAttribute("delecttea", delecttea);
		return "redirect:/index";
		
	}
	//管理员导入教师信息
	@RequestMapping(value="/administrator")
	public String administrator(@RequestParam(value = "file", required = false) MultipartFile file,RedirectAttributes attributes) throws IllegalStateException, IOException{
		String path = request.getSession().getServletContext().getRealPath("font");
		String filename = file.getOriginalFilename();
		importServlet importservlet=new importServlet();
		String administrator =importservlet.administrator(file,filename,path);
		attributes.addFlashAttribute("administrator", administrator);
		return "redirect:/index";
		
	}	 
	
	//教师导入学生信息
	@RequestMapping(value="/import")
	public String InitBinder(@RequestParam(value = "file", required = false) MultipartFile file,Model model, String id,RedirectAttributes attributes) throws IllegalStateException, IOException{
		String path = request.getSession().getServletContext().getRealPath("font");
		String filename = file.getOriginalFilename();
		importServlet importservlet=new importServlet();
		String viewimport =importservlet.importInformation(file,filename,path);
		loginServlet loginServlet=new loginServlet();
		Integer ID=Integer.valueOf(id).intValue();
		List<Object[]> list=loginServlet.logintecher(ID);
		loginController loginController=new loginController();
		for(Object[] teacher: list){
			String URL=loginController.studentLogin((String)teacher[0], (String)teacher[1], (String)teacher[2], attributes, model);
			model.addAttribute("viewimport", viewimport);
			
			return URL;
		}
		
		
		return "";
		
	}
	
	//老师上传题目
		@RequestMapping(value="/importss")
		public String importss(@RequestParam(value = "file", required = false) MultipartFile file,Model model, String id,RedirectAttributes attributes) throws IllegalStateException, IOException{
			String path = request.getSession().getServletContext().getRealPath("font");
			String filename = file.getOriginalFilename();
			importServlet importservlet=new importServlet();
			String viewimport =importservlet.importIn(file,filename,path);
			loginServlet loginServlet=new loginServlet();
			Integer ID=Integer.valueOf(id).intValue();
			List<Object[]> list=loginServlet.logintecher(ID);
			loginController loginController=new loginController();
			for(Object[] teacher: list){
				String URL=loginController.studentLogin((String)teacher[0], (String)teacher[1], (String)teacher[2], attributes, model);
				model.addAttribute("viewimport", viewimport);
				
				return URL;
			}
			
			
			return "";
			
		}
	//学生登陆成功后查看题库
	public List<question> studentSuccess(){
		selectTopicServlet selecttopicservlet=new selectTopicServlet();
		List<question> question=selecttopicservlet.selectTitle();
		return question;
	}
	
	//学生登录后填写进度
	@RequestMapping(value="/progress")
	public void progress(String name,String id,HttpServletResponse response) throws IOException{
		selectTopicServlet selectTopicServlet=new selectTopicServlet();
		String progress= selectTopicServlet.progress(name, id);
		response.setContentType(progress);
		response.setContentType("text/html");
		response.getWriter().print(progress);
		
	}
	
	//学生登陆成功后填写小组信息
	@RequestMapping(value="/xuanti")
		public void studentxuanti(String n,String a[],String b[],HttpServletResponse response) throws IOException{
			int N= Integer.valueOf(n).intValue();
			writeServlet writeServlet=new writeServlet();
			String vie =writeServlet.writer(N,a,b);
			response.setContentType(vie);
			response.setContentType("text/html");
			response.getWriter().print(vie);
			
		}
	//学生登陆成功后查看题目
	public List<leagueList> studentResults(Student student){
		selectTopicServlet selecttopicservlet=new selectTopicServlet();
		List<leagueList> leagueList=selecttopicservlet.studentResults(student);
		 
		return leagueList;
	}
	
	//学生选题
	@RequestMapping(value="/xuan")
	public String xuanti(String id,String tit_name,RedirectAttributes attributes,Model model){
		writeServlet writeServlet=new writeServlet();
		int ID = Integer.valueOf(id).intValue();
		String suanti=writeServlet.xuanti(ID,tit_name);
		loginServlet loginServlet=new loginServlet();
		
		List<Object[]> list=loginServlet.login(ID);
        for(Object[] student: list){
			loginController loginController=new loginController();
			String URL=loginController.studentLogin((String)student[0],(String) student[1],(String) student[2], attributes, model);
			model.addAttribute("suanti", suanti);
			return URL;
		}
		return null;
		
	}
	
	//学生登陆成功后查看成绩
	public List<questionBankList> studentsubject(Student student){
		selectTopicServlet selecttopicservlet=new selectTopicServlet();
		List<questionBankList> studentsubject=selecttopicservlet.studentsubject(student);
		 
		return studentsubject;
	}
	//学生修改密码
	@RequestMapping(value="/change")
	public void changePassword(String password,String id,HttpServletResponse response) throws IOException{
		loginServlet loginservlet=new loginServlet();
		String viewpassword=loginservlet.chagnepassword(password,id);
		response.setContentType(viewpassword);
		response.setContentType("text/html");
		response.getWriter().print(viewpassword);
		
	}
	
	//老师修改密码
		@RequestMapping(value="/teacher")
		public void changeteacher(String password,String id,HttpServletResponse response) throws IOException{
			loginServlet loginservlet=new loginServlet();
			String viewpassword=loginservlet.chagneteacher(password,id);
			response.setContentType(viewpassword);
			response.setContentType("text/html");
			response.getWriter().print(viewpassword);
			
		}
		
	//学生上传报告书
	@RequestMapping(value="/uploadReport")
	public String uploadReport(@RequestParam(value = "file", required = false) MultipartFile file,String id,RedirectAttributes attributes,Model model){
		String path = request.getSession().getServletContext().getRealPath("font"); 
		uploadReportServlet uploadReportServlet=new uploadReportServlet();
		String vi=uploadReportServlet.uploadReport(file, id,path);
		loginServlet loginServlet=new loginServlet();
		int ID = Integer.valueOf(id).intValue();
	
		List<Object[]> list=loginServlet.login(ID);
		for(Object[] student: list){
	        
			loginController loginController=new loginController();
			String URL=loginController.studentLogin((String)student[0],(String) student[1],(String) student[2], attributes, model);
			model.addAttribute("vi", vi);
			return URL;
		}
		return "";
		
		
	}
	//教师查看学生上传的
	public List<Object[]> selectbg(){
		selectTopicServlet selectTopicServlet=new selectTopicServlet();
		List<Object[]> listt=selectTopicServlet.selectbg();
		
		return listt;
		
	}
	
	//教师打分给学生
	@RequestMapping("/score")
	public void score(String name,String id,HttpServletResponse response) throws IOException{
		selectTopicServlet selectTopicServlet=new selectTopicServlet();
		String score= selectTopicServlet.score(name,id);
		response.setContentType(score);
		response.setContentType("text/html");
		response.getWriter().print(score);
	}
	
	
	//教师下载报告
	@RequestMapping("/download")    
	public String downloadFile(@RequestParam("fileName")String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {      
	    String path = request.getSession().getServletContext().getRealPath("font/"); 
		Configuration configuration = new Configuration().configure();	
		Integer id=Integer.valueOf(fileName).intValue();
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String HQL="select report from leagueList where id= :id";
		Query query= session.createQuery(HQL);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> List=query.list();
		fileName=List.toString().substring(1,List.toString().length()-1);
		if (fileName != null) {
    		              File file = new File(path,fileName);
    		              if (file.exists()) {
    		          
    		                 response.setContentType("application/force-download");// 设置强制下载不打开
    		                 response.setHeader( "Content-Disposition","attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );  
    		                 //response.addHeader("Content-Disposition","attachment;fileName=" + fileName);// 设置文件名
    		           
    		                 byte[] buffer = new byte[1024];
    		                 FileInputStream fileinputstream = null;
    		                 BufferedInputStream bufferedinputstream = null;
    		                try {
    		                	fileinputstream = new FileInputStream(file);
    		                	bufferedinputstream = new BufferedInputStream(fileinputstream);
    		                    OutputStream outputstream = response.getOutputStream();
    		                    int i = bufferedinputstream.read(buffer);
    		                    while (i != -1) {
    		                    	outputstream.write(buffer, 0, i);
    		                        i = bufferedinputstream.read(buffer);
    		                      }
    		                   } catch (Exception e) {
    		                    
    		                       e.printStackTrace();
    		                 } finally {
    		                     if (bufferedinputstream != null) {
    		                           try {
    		                        	   bufferedinputstream.close();
    		                           } catch (IOException e) {
    		                            
    		                               e.printStackTrace();
    		                          }
    		                       }
    		                       if (fileinputstream != null) {
    		                             try {
    		                        	      fileinputstream.close();
    		                             } catch (IOException e) {
    		                            
    		                               e.printStackTrace();
    		                          }
    		                       }
    		                   }
    		               }else{
    		            	   
    		               }  
    		              
    		       }
		     
    		  return null;  
   }    

}
