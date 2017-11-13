package com.one.servlet;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class writeServlet {

	@SuppressWarnings({ "unchecked", "unused" })
	public String writer(int n,String a[],String b[]){
		String view="0";
		String sel="select id from Student where name = :name ";
		for(int i=0;i<n;i++){
			Configuration configuration = new Configuration().configure();		
			@SuppressWarnings("deprecation")
			SessionFactory sessionfactory = configuration.buildSessionFactory();
			Session session = sessionfactory.openSession();
			Query query= session.createQuery(sel);
		    query.setString("name", b[i]);
			List<Integer> id=query.list();
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
			if(id.toString().equals("[]")){
				return b[i]+"同学不存在";
			}
			for(Integer ID:id){
				Configuration configuration1 = new Configuration().configure();		
				@SuppressWarnings("deprecation")
				SessionFactory sessionfactory1 = configuration.buildSessionFactory();
				Session session1 = sessionfactory.openSession();
				Transaction tx=session1.beginTransaction();
				String HQL="update teamList id set teamleader=:teamleader,members=:members,groupname=:groupname where student=:ID";
				query= session1.createQuery(HQL);
			    query.setInteger("ID",ID);
			    query.setParameter("teamleader",b[n-1]);
			    query.setParameter("members",b[i]);
			    query.setParameter("groupname",a[i]);
			    int d=query.executeUpdate();
			    tx.commit();
			    if(d>0){
			    	if (session1 != null) {
						if (session1.isOpen()) {
							session1.close();
						}
					}
			    	view="1";
			    }else{
			    	if (session1 != null) {
						if (session1.isOpen()) {
							session1.close();
						}
					}
			    	view="0";
			    }
			    
			}
			
		
		}
		if(view.equals("1")){
			return "信息填写成功";
		}else{
			return "信息填写失败";
		}
		
		
	}
	
	//学生选题
	public String xuanti(Integer id,String tit_name){
		
		Configuration configuration = new Configuration().configure();		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		String hql="update questionBankList set title=:title where student =:id";
		Query query= session.createQuery(hql);
		query.setParameter("title",tit_name);
		query.setInteger("id", id);
		int n=query.executeUpdate();
		transaction.commit();
		if(n>0){
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
			return "选题成功";
		}else{
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
			return "选题失败";
		}
		
		
	}
}
