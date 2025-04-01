package xust.demo.stu.service;

import xust.demo.Result;
import xust.demo.stu.domain.Student;
import xust.demo.stu.dao.StudentDao;
import xust.demo.stu.dao.StudentDaoImpl;
import jakarta.servlet.http.HttpServletRequest;

public class StudentServiceImpl implements StudentService {
  private StudentDao _StudentDao;

  public StudentServiceImpl() {
    _StudentDao = new StudentDaoImpl();
    _StudentDao.init();
  }

  // --8<-- [start:toO]
  /**
   * 参数填充到对象
   */
  public Student toO(HttpServletRequest request) {
    Student res = null;

    if (request != null) {
      res = new Student();
      String p = null;
      p = request.getParameter("no");
      if (p != null) {
        res.setNo(request.getParameter("no"));
      }
      p = request.getParameter("name");
      if (p != null) {
        res.setName(request.getParameter("name"));
      }
      p = request.getParameter("gender");
      if (p != null) {
        res.setGender(request.getParameter("gender"));
      }
      p = request.getParameter("age");
      if (p != null) {
        res.setAge(Integer.parseInt(request.getParameter("age")));
      }
      p = request.getParameter("dept");
      if (p != null) {
        res.setDept(request.getParameter("dept"));
      }
    }

    return res;
  }
  // --8<-- [end:toO]

  // --8<-- [start:create]
  public Result create(Student o) {
    Result res = new Result(false);

    if (_StudentDao != null && o != null) {
      res = _StudentDao.create(o);
    }

    return res;
  }
  // --8<-- [end:create]

  // --8<-- [start:delete]
  public Result delete(String no) {
    Result res = new Result(false);

    if (_StudentDao != null) {
      res = _StudentDao.delete(no);
    }

    return res;
  }
  // --8<-- [end:delete]

  // --8<-- [start:update]
  public Result update(Student o) {
    Result res = new Result(false);

    if (_StudentDao != null && o != null) {
      res = _StudentDao.update(o);
    }

    return res;
  }
  // --8<-- [end:update]

  // --8<-- [start:get]
  public Result get(String no) {
    Result res = new Result(false);

    if (_StudentDao != null) {
      res = _StudentDao.get(no);
    }

    return res;
  }
  // --8<-- [end:get]

  // --8<-- [start:getAll]
  public Result getAll() {
    Result res = new Result(false);

    if (_StudentDao != null) {
      res = _StudentDao.getAll();
    }

    return res;
  }
  // --8<-- [end:getAll]
}
