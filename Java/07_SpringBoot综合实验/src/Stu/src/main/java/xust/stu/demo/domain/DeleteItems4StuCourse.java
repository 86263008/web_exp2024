/*
 * File name : StuCourse.java 2023-04-20
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.stu.demo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class DeleteItems4StuCourse
 * DeleteItems参数
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public class DeleteItems4StuCourse{

  private List<String> ids = new ArrayList<String>();

  public DeleteItems4StuCourse() {
    
  }

  public void setIds(List<String> ids){
    this.ids = ids;
  }

  public List<String> getIds(){
    return this.ids;
  }
}
