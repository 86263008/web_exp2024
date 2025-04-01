/*
 * File name : StuCourse.java 2023-04-20
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.demo.stu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class GetPage4StuCourse
 * DeleteItems参数
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public class GetPage4StuCourse{
  private Integer pageNum;
  private Integer pageSize;
  private String id;
  private List<String> ids;

  public GetPage4StuCourse() {
    
  }

  public void setPageNum(Integer pageNum){
    this.pageNum = pageNum;
  }

  public Integer getPageNum(){
    return this.pageNum;
  }

  public void setPageSize(Integer pageSize){
    this.pageSize = pageSize;
  }

  public Integer getPageSize(){
    return this.pageSize;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getId(){
    return this.id;
  }

  public void setIds(List<String> ids){
    this.ids = ids;
  }

  public List<String> getIds(){
    return this.ids;
  }

}
