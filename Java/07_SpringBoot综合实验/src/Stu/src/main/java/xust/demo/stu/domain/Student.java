/*
 * File name : Student.java 2023-04-20
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
 * Class Student
 * 学生表
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public class Student{
  private static final long serialVersionUID = -8178158848305435288L;
  public static ObjectMapper objectMapper = new ObjectMapper();

  
  /**
   * Id
   */
  private String id;
  
  /**
   * 学号
   */
  @NotNull
  private String no;
  
  /**
   * 姓名
   */
  private String name;
  
  /**
   * 性别
   */
  private String gender;
  
  /**
   * 年龄
   */
  private Integer age;
  
  /**
   * 所在系
   */
  private String dept;
  
	
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
	 * 学号
	 */
	public String getNo(){
		return no;
	}
	
	/**
	 * 学号
	 */
	public void setNo(String newValue){
		no = newValue;
	}
	/**
	 * 姓名
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 姓名
	 */
	public void setName(String newValue){
		name = newValue;
	}
	/**
	 * 性别
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * 性别
	 */
	public void setGender(String newValue){
		gender = newValue;
	}
	/**
	 * 年龄
	 */
	public Integer getAge(){
		return age;
	}
	
	/**
	 * 年龄
	 */
	public void setAge(Integer newValue){
		age = newValue;
	}
	/**
	 * 所在系
	 */
	public String getDept(){
		return dept;
	}
	
	/**
	 * 所在系
	 */
	public void setDept(String newValue){
		dept = newValue;
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

