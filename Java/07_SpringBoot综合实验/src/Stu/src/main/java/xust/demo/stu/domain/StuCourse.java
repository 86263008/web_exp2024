/*
 * File name : StuCourse.java 2023-04-20
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.demo.stu.domain;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Class StuCourse
 * 学生选课表
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public class StuCourse{
  private static final long serialVersionUID = -8178158848305435288L;
  public static ObjectMapper objectMapper = new ObjectMapper();

  
  /**
   * Id
   */
  private String id;
  
  /**
   * 课程号
   */
  private String courseNo;
  
  /**
   * 学号
   */
  private String stuNo;
  
  /**
   * 成绩
   */
  private Double grade;
  
	
	/**
	 * Id
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Id
	 */
	public void setId(String newValue){
		id = newValue;
	}
	/**
	 * 课程号
	 */
	public String getCourseNo(){
		return courseNo;
	}
	
	/**
	 * 课程号
	 */
	public void setCourseNo(String newValue){
		courseNo = newValue;
	}
	/**
	 * 学号
	 */
	public String getStuNo(){
		return stuNo;
	}
	
	/**
	 * 学号
	 */
	public void setStuNo(String newValue){
		stuNo = newValue;
	}
	/**
	 * 成绩
	 */
	public Double getGrade(){
		return grade;
	}
	
	/**
	 * 成绩
	 */
	public void setGrade(Double newValue){
		grade = newValue;
	}

  @Override
  public String toString() {
    String res = "";
    
    try {
      res = objectMapper.writeValueAsString(this);
    } catch (Exception e) {
    }  
    
    return res;
  }
}
