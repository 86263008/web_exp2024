/*
 * File name : Course.java 2023-04-20
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
 * Class Course
 * 课程表
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public class Course{
  private static final long serialVersionUID = -8178158848305435288L;
  public static ObjectMapper objectMapper = new ObjectMapper();

  
  /**
   * Id
   */
  private String id;
  
  /**
   * 编号
   */
  private String no;
  
  /**
   * 课程名
   */
  private String name;
  
  /**
   * 先修课
   */
  private String preNo;
  
  /**
   * 学分
   */
  private Double credit;
  
	
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
	 * 编号
	 */
	public String getNo(){
		return no;
	}
	
	/**
	 * 编号
	 */
	public void setNo(String newValue){
		no = newValue;
	}
	/**
	 * 课程名
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 课程名
	 */
	public void setName(String newValue){
		name = newValue;
	}
	/**
	 * 先修课
	 */
	public String getPreNo(){
		return preNo;
	}
	
	/**
	 * 先修课
	 */
	public void setPreNo(String newValue){
		preNo = newValue;
	}
	/**
	 * 学分
	 */
	public Double getCredit(){
		return credit;
	}
	
	/**
	 * 学分
	 */
	public void setCredit(Double newValue){
		credit = newValue;
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

