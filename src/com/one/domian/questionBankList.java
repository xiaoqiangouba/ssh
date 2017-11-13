package com.one.domian;

public class questionBankList {
	// 题库表
    private Integer id;
    private String title;   //题名
    private Student student;  //学生表
  //  private teacher teacher;  //教师表
    public questionBankList(){}
	public Integer getId() {
		return id;
	}
	
	/*public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}*/
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "questionBankList [id=" + id + ", title=" + title + ", student=" + student + "]";
	}

	
    
}
