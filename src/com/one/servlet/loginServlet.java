package com.one.servlet;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.one.domian.Student;
import com.one.domian.teacher;

public class loginServlet {

	//学生登录
	public String studentLogin(Student student){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Query query= session.getNamedQuery("studentLanding");
		query.setString("name", student.getName());
		query.setString("password", student.getPassword());
		@SuppressWarnings("unchecked")
		List<Object[]> list =query.list();
		  for(Object[] name : list){
			  if(name[1].equals(student.getName())&&name[2].equals( student.getPassword())){
				  if (session != null) {
						if (session.isOpen()){
							session.close();
						}
					} 
			   String id=String.valueOf(name[0]);
				   return id ;
			   }
		   }
		  if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		  
		return "用户名或密码不正确";
	}
	//老师登陆
	public String teacherLogin(teacher teacher){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Query query= session.getNamedQuery("teacherLanding");
		query.setString("name", teacher.getName());
		query.setString("password", teacher.getPassword());
		@SuppressWarnings("unchecked")
		List<Object[]> list =query.list();
		  for(Object[] name : list){
			  if(name[1].equals(teacher.getName())&&name[2].equals( teacher.getPassword())){
				  if (session != null) {
						if (session.isOpen()){
							session.close();
						}
					} 
				  String id=String.valueOf(name[0]);
				   return id ;
			   }
		   }
		  if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		  
		return "用户名或密码不正确";
		
		}
	/*//学生注册
	@SuppressWarnings("unchecked")
	public String studentRegistered(Student student){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query= session.getNamedQuery("selectUsername");
		query.setString("name",student.getName());
		List<String> list =query.list();
		   for(String name : list){
			   if(name.equals(student.getName())){
				   if (session != null) {
						if (session.isOpen()) {
							session.close();
						}
					}
				   return "用户名已存在";
			   }
		   }
		   if(student.getPassword()==null||student.getName()==null||student.getType()==null){
			   return "";
		   }
	    session.save(student);
		transaction.commit();
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
		return "用户注册成功";
	}*/
	
	//学生修改密码
	public String chagnepassword(String password, String ID){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		int id = Integer.valueOf(ID).intValue();
		Query query= session.getNamedQuery("chagnepassword").setParameter("password", password).setParameter("id", id);
		int n=query.executeUpdate();
		session.getTransaction().commit();
		if(n>0){
			return "密码修改成功";
		}else{
			return "密码修改失败";
		}
		
		
	}
	
	//老师修改密码
		public String chagneteacher(String password, String ID){
			Configuration configuration = new Configuration().configure();		
			@SuppressWarnings("deprecation")
			SessionFactory sessionfactory = configuration.buildSessionFactory();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			int id = Integer.valueOf(ID).intValue();
			Query query= session.getNamedQuery("chagne").setParameter("password", password).setParameter("id", id);
			int n=query.executeUpdate();
			session.getTransaction().commit();
			if(n>0){
				if (session != null) {
					if (session.isOpen()) {
						session.close();
					}
				}
				return "密码修改成功";
				
			}else{
				if (session != null) {
					if (session.isOpen()) {
						session.close();
					}
				}
				return "密码修改失败";
			}
			
			
		}
	//根据id查询学生信息
	@SuppressWarnings("unchecked")
	public List<Object[]> login(Integer id){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
	    String hql="select name,password,type from Student where id=:id ";
		Query query= session.createQuery(hql).setParameter("id", id);
		List<Object[]> list=query.list();
		return list;
		
	}
	
	//根据id查询老师信息
	@SuppressWarnings("unchecked")
	public List<Object[]> logintecher(Integer id){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
	    String hql="select name,password,type from teacher where id=:id ";
		Query query= session.createQuery(hql).setParameter("id", id);
		List<Object[]> list=query.list();
		return list;
		
	}
}
