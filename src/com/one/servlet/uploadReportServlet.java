package com.one.servlet;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.web.multipart.MultipartFile;



public class uploadReportServlet {

	@SuppressWarnings({ "unchecked" })
	public String uploadReport(MultipartFile file,String id,String path){
		String filename = file.getOriginalFilename();
		
		File targetFile = new File(path,filename);
		try {
			if (!targetFile.exists()) {
				 targetFile.mkdir();
			}
			file.transferTo(targetFile);
		    Configuration configuration = new Configuration().configure();		
		    @SuppressWarnings("deprecation")
			SessionFactory sessionfactory = configuration.buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction tx=session.beginTransaction();
			int ID = Integer.valueOf(id).intValue();
			String hql="select a.id from teamList as b,Student as c,leagueList as a where b.student=c.id and b.id=a.teamlist and c.id=:id ";
			String HQL="update leagueList set report=:report where id=:id ";
			Query query= session.createQuery(hql).setParameter("id", ID);
			List<Integer> ID1=query.list();
				for(Integer dd:ID1){
					 query=session.createQuery(HQL);
					 query.setParameter("report",filename);
				   	 query.setParameter("id",dd);
				   	 int n=query.executeUpdate();
				     tx.commit();
					 if (session != null) {
							if (session.isOpen()){
								session.close();
							}
						} 
					 if(n>0){
						 
						 
						 return "报告上传成功";
						
					 }					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "报告上传失败\n[1]" + e.getMessage();
		}
		return null;
		
	}
}
