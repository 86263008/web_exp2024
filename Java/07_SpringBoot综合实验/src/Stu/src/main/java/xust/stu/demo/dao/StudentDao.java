/*
 * File name : Student.java 2023-04-20
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.stu.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;
import xust.stu.demo.domain.Student;

/**
 * StudentDao
 * @author XUST
 * @version 1.0, 2023-04-20
 */
@Mapper
public interface StudentDao {
  
  ///////////////////// Create
  /**
   * 创建对象
   * @param newValue 新对象
   * @return 影响行数，1为成功，0为失败
   */
  public int create(Student newValue);
  
  ///////////////////// Retrie

  /**
   * 获取对象数量
   * @param params 并参数
   * @return 非空新对象，非空Integer对象
   */
  public int size(@Param("params")Map<String, Object> params);

  /**
   * 获取对象分页
   * @param params 并参数
   * @return 非空对象列表
   */
  public List<Student> getPage(@Param("params")Map<String, Object> params, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
  
  /**
   * 获取对象列表
   * @param items id列表
   * @return 非空对象列表
   */
  public List<Student> getItems(List<String> items);

  ///////////////////// Update
  /**
   * 更新对象
   * @param newValue 新值
   * @return 非空Integer对象
   */
  public int update(Student newValue);
  
  ///////////////////// Delete
  /**
   * 删除对象
   * @param ids id列表
   * @return 非空Integer对象
   */
  public int deleteItems(List<String> ids);
  
  /**
   * 删除对象
   * @return 非空Integer对象
   */
  public int deleteAll();

  public int delete(@Param("params")Map<String, Object> params);
}

