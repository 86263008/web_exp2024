package xust.demo.stu.dao;

import xust.stu.Result;
import xust.demo.stu.domain.Student;

public interface StudentDao {
  /**
   * 初始化表
   * 
   * @return
   */
  Result init();

  /**
   * 增
   * 
   * @param o
   * @return
   */
  Result create(Student o);

  /**
   * 删
   * 
   * @param id
   * @return
   */
  Result delete(String no);

  /**
   * 改
   * 
   * @param o
   * @return
   */
  Result update(Student o);

  /**
   * 查
   * 
   * @param no
   * @return
   */
  Result get(String no);

  /**
   * 查
   * 
   * @return
   */
  Result getAll();
}
