package xust.demo.stu.service;

import xust.demo.Result;
import xust.demo.stu.domain.Student;
import jakarta.servlet.http.HttpServletRequest;

public interface StudentService {
  Student toO(HttpServletRequest request);

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
