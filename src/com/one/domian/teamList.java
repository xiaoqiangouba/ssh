package com.one.domian;

public class teamList {
   //小组信息表
	private Integer id;
	private String teamleader; //组长
	private String members;   //成员
	private String groupname; //班级名
	private Student student;  //学生表
	private leagueList leaguelist;   //成绩表
	public teamList(){}
	
	public String getTeamleader() {
		return teamleader;
	}

	public void setTeamleader(String teamleader) {
		this.teamleader = teamleader;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getGroupname() {
		return groupname;
	}
	
	public leagueList getLeaguelist() {
		return leaguelist;
	}
	public void setLeaguelist(leagueList leaguelist) {
		this.leaguelist = leaguelist;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "teamList [id=" + id + ", teamleader=" + teamleader + ", members=" + members + ", groupname=" + groupname
				+ ", student=" + student + ", leaguelist=" + leaguelist + "]";
	}
	
	
}
