package com.one.domian;

public class leagueList {
	//成绩表
   private String groupname;  //组名
   private Integer id;
   private String results;   //成绩
   private String report;    //报告书
   private String progress;  //进度
   private teamList teamlist;  //小组表

   public leagueList(){}
public String getGroupname() {
	return groupname;
}

public void setGroupname(String groupname) {
	this.groupname = groupname;
}

public teamList getTeamlist() {
	return teamlist;
}
public void setTeamlist(teamList teamlist) {
	this.teamlist = teamlist;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public String getResults() {
	return results;
}
public void setResults(String results) {
	this.results = results;
}
public String getReport() {
	return report;
}
public void setReport(String report) {
	this.report = report;
}
public String getProgress() {
	return progress;
}
public void setProgress(String progress) {
	this.progress = progress;
}
@Override
public String toString() {
	return "leagueList [groupname=" + groupname + ", id=" + id + ", results=" + results + ", report=" + report
			+ ", progress=" + progress + ", teamlist=" + teamlist + "]";
}


   
}
