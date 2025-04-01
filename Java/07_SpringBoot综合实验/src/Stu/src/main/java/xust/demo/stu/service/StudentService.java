/*
 * File name : StudentService.java 2023-04-20
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.demo.stu.service;

import java.io.OutputStream;
import java.util.Map;
import java.util.List;

import xust.Result;
import xust.demo.stu.domain.Student;

/**
 * Interface StudentService
 * Student service interface.
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public interface StudentService {

  /**
   * 创建对象
   * @param newValue 新对象
   * @return 影响行数，1为成功，0为失败
   */
  public Result<Student> create(Student newValue);

  /**
   * 删除所有数据
   * @return 删除行数
   */
  public Result<Integer> deleteAll();

  /*
   * 删除指定条件筛选的数据
   * @return 删除行数
   */
  public Result<Integer> delete(Map<String, Object> params);

  /**
   * 删除对象
   * @param ids id列表
   * @return 非空Integer对象
   */
  public Result<Integer> deleteItems(List<String> items);
  
  /**
   * 更新对象
   * @param newValue 新值
   * @return 非空Integer对象
   */
  public Result<Integer> update(Student newValue);

  /**
   * 获取对象数量
   * @param params 并参数
   * @return 非空新对象，非空Integer对象
   */
  public Result<Integer> size(Map<String, Object> params);

  /**
   * 获取对象分页
   * @param params 并参数
   * @param pageNum 页码(从1开始),超出范围会返回边界页
   * @param pageSize 分页大小
   * @return 非空对象列表
   */
  public Result<List<Student>> getPage(Map<String, Object> params, int pageNum, int pageSize);
    
  public Result<Boolean> export2XLS(List<Student> data, String worksheet_name, String title, OutputStream output);

}

