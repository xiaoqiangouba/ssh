package com.one.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.one.domian.Student;
import com.one.domian.leagueList;
import com.one.domian.question;
import com.one.domian.questionBankList;
import com.one.domian.teacher;
import com.one.domian.teamList;

public class importServlet {

	//导入学生信息
	@SuppressWarnings("deprecation")
	public String importInformation(MultipartFile file,String filename,String path) throws IllegalStateException, IOException{
		File targetFile = new File(path,filename);
		if (!targetFile.exists()) {
			 targetFile.mkdir();
		}
		file.transferTo(targetFile);
		String[][] b=new String[100][100];
    	int[][] a=new int[100][100];
    	Student student=new Student();
    	Configuration configuration = new Configuration().configure();		
		SessionFactory sessionfactory = configuration.buildSessionFactory();
        File f = new File(path+"/"+filename);     
        try {     
            FileInputStream is = new FileInputStream(f);     
            @SuppressWarnings("resource")
			XSSFWorkbook wbs = new XSSFWorkbook(is);     
            XSSFSheet childSheet = wbs.getSheetAt(0);        
            for (int j = 1; j <= childSheet.getLastRowNum(); j++) { 
            	Session session = sessionfactory.openSession();
        		Transaction transaction = session.beginTransaction();
                XSSFRow row = childSheet.getRow(j);            
                if (null != row) {     
                    for (int k = 0; k < row.getLastCellNum(); k++){     
                        XSSFCell cell = row.getCell(k);     
                            if (null != cell) {     
                                switch (cell.getCellType()) {     
                                  case HSSFCell.CELL_TYPE_NUMERIC:  
                                       a[j][1] = (int)cell.getNumericCellValue();
                                       break;     
                                  case HSSFCell.CELL_TYPE_STRING:    
                                	   b[j][k]= cell.getStringCellValue();
                                	   break;     
                                	}     
                            	}   
                    		} 
                		}
                student.setName( b[j][0]);
                student.setNober(a[j][1]);
                String password=String.valueOf(a[j][1]);
                teamList teamList=new teamList();
                student.setTeamlist(teamList);
                teamList.setStudent(student);
                leagueList leagueList=new leagueList();
                teamList.setLeaguelist(leagueList);
                leagueList.setTeamlist(teamList);
                questionBankList questionBankList=new questionBankList();
                student.setQuestionbanklist(questionBankList);
                questionBankList.setStudent(student);
                student.setPassword(password);
                student.setType( b[j][2]);
                session.save(student);
                
                transaction.commit();
                if (session != null) {
        			if (session.isOpen()) {
        				session.close();
        			}
        		}
            } 
        } catch (Exception e) {     
            e.printStackTrace();     
        }  
		return "信息导入成功";	
	}
	//导入题目信息
		@SuppressWarnings("deprecation")
		public String importIn(MultipartFile file,String filename,String path) throws IllegalStateException, IOException{
			File targetFile = new File(path,filename);
			if (!targetFile.exists()) {
				 targetFile.mkdir();
			}
			int k = 0 ;
			file.transferTo(targetFile);
			String[][] b=new String[100][100];
			question question=new question();
	    	Configuration configuration = new Configuration().configure();		
			SessionFactory sessionfactory = configuration.buildSessionFactory();
	        File f = new File(path+"/"+filename);     
	        try {     
	            FileInputStream is = new FileInputStream(f);     
	            @SuppressWarnings("resource")
				XSSFWorkbook wbs = new XSSFWorkbook(is);     
	            XSSFSheet childSheet = wbs.getSheetAt(0);        
	            for (int j = 1; j <= childSheet.getLastRowNum(); j++) { 
	            	Session session = sessionfactory.openSession();
	        		Transaction transaction = session.beginTransaction();
	                XSSFRow row = childSheet.getRow(j);            
	                if (null != row) {     
	                    for ( k = 0; k < row.getLastCellNum(); k++){     
	                        XSSFCell cell = row.getCell(k);     
	                            if (null != cell) {     
	                                switch (cell.getCellType()) { 
	                                  case HSSFCell.CELL_TYPE_STRING: 
	                                	b[j][k]= cell.getStringCellValue();
	                                	question.setTitle(b[j][k]);
	                   	                session.save(question);
	                   	                transaction.commit();
	                   	                if (session != null) {
	                   	        			if (session.isOpen()) {
	                   	        				session.close();
	                   	        			}
	                   	        		}
	                                	   break;     
	                                	}     
	                            	}   
	                    		} 
	                		}
	            
	                
	            } 
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        }  
			return "信息导入成功";	
		}
		
		//导入教师信息
		@SuppressWarnings("deprecation")
		public String administrator(MultipartFile file,String filename,String path) throws IllegalStateException, IOException{
			File targetFile = new File(path,filename);
			if (!targetFile.exists()) {
				 targetFile.mkdir();
			}
			String[][] b=new String[100][100];
			int[][] a=new int[100][100];
			file.transferTo(targetFile);
			int k = 0 ;
			File f = new File(path+"/"+filename);  
			teacher teacher =new teacher();
			Configuration configuration = new Configuration().configure();		
			SessionFactory sessionfactory = configuration.buildSessionFactory();
	        try {     
	            FileInputStream is = new FileInputStream(f);     
	            @SuppressWarnings("resource")
				XSSFWorkbook wbs = new XSSFWorkbook(is);     
	            XSSFSheet childSheet = wbs.getSheetAt(0);        
	            for (int j = 1; j <= childSheet.getLastRowNum(); j++) { 
	            	Session session = sessionfactory.openSession();
	        		Transaction transaction = session.beginTransaction();
	                XSSFRow row = childSheet.getRow(j);            
	                if (null != row) {     
	                    for ( k = 0; k < row.getLastCellNum(); k++){     
	                        XSSFCell cell = row.getCell(k);     
	                            if (null != cell) {     
	                                switch (cell.getCellType()) { 
	                                case HSSFCell.CELL_TYPE_NUMERIC:  
	                                      a[j][1]=(int)cell.getNumericCellValue();
	                                       break; 
	                                  case HSSFCell.CELL_TYPE_STRING: 
	                                	   b[j][k]=cell.getStringCellValue();
	                                	   break;     
	                                	}     
	                            	}   
	                    		} 
	                		}
	            String password=String.valueOf(a[j][1]);
	            teacher.setPassword(password);
	            teacher.setName(b[j][0]);
	            teacher.setType(b[j][2]);
                session.save(teacher);
                transaction.commit();
                if (session != null) {
        			if (session.isOpen()) {
        				session.close();
        			}
        		 }    
	            } 
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        }  
			return "信息导入成功";
			
		}
}
