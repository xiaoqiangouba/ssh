package com.one.domian;

public class Student {
    private Integer id;
    private String type;
    private int nober;
    private String name;
    private String password;
    private questionBankList questionbanklist;  // 题库表
    private teamList teamlist;   //小组表
    
    public Student(){}
	public Integer getId() {
		return id;
	}
	
	public teamList getTeamlist() {
		return teamlist;
	}
	public void setTeamlist(teamList teamlist) {
		this.teamlist = teamlist;
	}
	public questionBankList getQuestionbanklist() {
		return questionbanklist;
	}
	public void setQuestionbanklist(questionBankList questionbanklist) {
		this.questionbanklist = questionbanklist;
	}
	public int getNober() {
		return nober;
	}
	public void setNober(int nober) {
		this.nober = nober;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", type=" + type + ", nober=" + nober + ", name=" + name + ", password=" + password
				+ ", questionbanklist=" + questionbanklist + ", teamlist=" + teamlist + "]";
	}
	
	
	

      
}
