package com.one.domian;

public class teacher {
	 private Integer id;
	 private String type;
	 private String name;
	 private String password;
	// private questionBankList questionbanklist;
	 public teacher(){}
	public Integer getId() {
		return id;
	}
	
	/*public questionBankList getQuestionbanklist() {
		return questionbanklist;
	}
	public void setQuestionbanklist(questionBankList questionbanklist) {
		this.questionbanklist = questionbanklist;
	}*/
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		return "teacher [id=" + id + ", type=" + type + ", name=" + name + ", password=" + password
				+ ", questionbanklist="  + "]";
	}
	
	 
}
