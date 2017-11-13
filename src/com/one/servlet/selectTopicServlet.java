package com.one.servlet;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.one.domian.Student;
import com.one.domian.leagueList;
import com.one.domian.question;
import com.one.domian.questionBankList;
import com.one.domian.teacher;

public  class selectTopicServlet {

	//查看题库所有的题目
	@SuppressWarnings({ "unchecked" })
	public List<question> selectTitle(){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Query query= session.getNamedQuery("selectTitle");
		List<question> question=query.list();
		 if (session != null) {
				if (session.isOpen()){
					session.close();
				}
			} 
		return question;
		
	}
	
	//查看自己的成绩
	public List<leagueList> studentResults(Student student){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String HQL="select a.results from leagueList as a,teamList as b,Student as c where c.id=b.student and a.teamlist=b.id and c.name=:name and c.password=:password";
		Query query= session.createQuery(HQL);
		query.setString("name", student.getName());
		query.setString("password",student.getPassword());
		@SuppressWarnings("unchecked")
		List<leagueList> leagueList=query.list();
		 if (session != null) {
				if (session.isOpen()){
					session.close();
				}
			} 
		
		return leagueList;
		
	}
	
	//删除教师信息
	@SuppressWarnings("unchecked")
	public String delecttea(String name, String password){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		String HQL=" select id from teacher where name= :name and password =:password ";
		Query query= session.createQuery(HQL);
		query.setString("name", name);
		query.setString("password", password);
		List<Integer> list=query.list();
		for(Integer id:list){
			teacher teacher=new teacher();
			teacher=(com.one.domian.teacher) session.load(teacher.class, id);
			session.delete(teacher);
			tx.commit();
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
			return "删除成功";
		}
		return null;
		
	}
	//学生填写进度
	public String progress(String name,String id){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		int ID= Integer.valueOf(id).intValue();
		String HQL="select a.id from teamList as a,Student as b where b.id=a.student and b.id=:id";
		Query query= session.createQuery(HQL);
		query.setInteger("id", ID);
		@SuppressWarnings("unchecked")
		List<Integer> list=query.list();
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
		for(Integer dd:list){
			Configuration configuration1 = new Configuration().configure();		
			@SuppressWarnings("deprecation")
			SessionFactory sessionfactory1 = configuration1.buildSessionFactory();
			Session session1 = sessionfactory1.openSession();
			Transaction tx=session1.beginTransaction();
			String hql="update leagueList set progress=:progress where teamlist=:id";
			Query query1= session1.createQuery(hql);
			query1.setParameter("progress",name);
			query1.setInteger("id",dd);
			int n=query1.executeUpdate();
			tx.commit();
			if(n>0){
				if (session1 != null) {
					if (session1.isOpen()) {
						session1.close();
					}
				}
				return "进度填写成功";
				
			}else{
				if (session1 != null) {
					if (session1.isOpen()) {
						session1.close();
					}
				}
				return "进度填写失败";
			}
		}
		
		return null;
		
	}
	
	//查看自己选的题目
	public List<questionBankList> studentsubject(Student student){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String HQL="select a.title from questionBankList as a,Student as c where a.student=c.id and c.name=:name and c.password=:password";
		Query query= session.createQuery(HQL);
		query.setString("name", student.getName());
		query.setString("password",student.getPassword());
		@SuppressWarnings("unchecked")
		List<questionBankList> studentsubject=query.list();
		 if (session != null) {
				if (session.isOpen()){
					session.close();
				}
			} 
		
		return studentsubject;
		
	}
	
	//老师查看学生报告
	@SuppressWarnings("unchecked")
	public  List<Object[]> selectbg(){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String HQL="select a.id,a.report,a.progress,c.name from leagueList as a,teamList as b, Student as c where a.teamlist=b.id and b.student=c.id and a.progress!='null'";
		Query query= session.createQuery(HQL);
		List<Object[]> listt=query.list();
		return listt;
		
	}
	
	//管理员查看教师信息
	public List<teacher> selectter(){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String HQL="from teacher";
		Query query= session.createQuery(HQL);
		@SuppressWarnings("unchecked")
		List<teacher> list=query.list();
		return list;
		
	}
	//老师打分
	
	public String score(String name,String id){
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		int ID= Integer.valueOf(id).intValue();
		String HQL="update leagueList set results=:results where id=:id";
		Query query= session.createQuery(HQL);
		query.setInteger("id", ID);
		query.setParameter("results", name);
		int n=query.executeUpdate();
		tx.commit();
		if(n>0){
			 if (session != null) {
					if (session.isOpen()){
						session.close();
					}
				} 
			 return "评分成功";
		}else{
			if (session != null) {
				if (session.isOpen()){
					session.close();
				}
			} 
		 return "评分失败";
			
		}
		
	}
}
