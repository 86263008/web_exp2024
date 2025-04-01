package xust.demo.stu.dao;

import java.sql.*;
import java.util.ArrayList;
import xust.demo.Result;
import xust.demo.ConnectionUtil;
import xust.demo.stu.domain.Student;

public class StudentDaoImpl implements StudentDao {
  // --8<-- [start:init]
  public Result init() {
    Result res = new Result(false);

    Connection con = null;
    Statement stmt = null;
    String sql = "create table Student(" +
        "no TEXT primary key," +
        "name TEXT not null," +
        "gender TEXT," +
        "age INTEGER," +
        "dept TEXT" +
        ");";

    con = ConnectionUtil.getConnection();
    if (con != null) {
      try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(String.format(
            "select count(*) from sqlite_master where type = 'table' and Upper(name) = '%s'", "Student".toUpperCase()));
        while (rs.next()) {
          int count = rs.getInt(1);

          if (count == 0 && stmt.executeUpdate(sql) > 0) {
            res.code = 0;
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
        res.message = e.getMessage();
      } finally {
        ConnectionUtil.closeStmt(stmt);
        ConnectionUtil.closeConnection(con);
      }
    }

    return res;
  }
  // --8<-- [end:init]

  // --8<-- [start:toR]
  /**
   * 对象填充到关系
   */
  private void toR(Student o, PreparedStatement stmt) throws Exception {
    if (o != null && stmt != null) {
      String no = o.getNo();
      if (no != null) {
        stmt.setString(1, no);
      }
      String name = o.getName();
      if (name != null) {
        stmt.setString(2, name);
      }
      String gender = o.getGender();
      if (gender != null) {
        stmt.setString(3, gender);
      }
      Integer age = o.getAge();
      if (age != null) {
        stmt.setInt(4, age);
      }
      String dept = o.getDept();
      if (dept != null) {
        stmt.setString(5, dept);
      }
    }
  }
  // --8<-- [end:toR]

  // --8<-- [start:toO]
  /**
   * 关系填充到对象
   */
  private Student toO(ResultSet rs) throws Exception {
    Student res = null;

    if (rs != null) {
      res = new Student();
      res.setNo(rs.getString("no"));
      res.setName(rs.getString("name"));
      res.setGender(rs.getString("gender"));
      res.setAge(rs.getInt("age"));
      res.setDept(rs.getString("dept"));
    }

    return res;
  }
  // --8<-- [end:toO]

  // --8<-- [start:create]
  public Result create(Student o) {
    Result res = new Result(false);

    Connection con = null;
    PreparedStatement stmt = null;
    String sql = "insert into Student values (?, ?, ?, ?, ?)";
    con = ConnectionUtil.getConnection();
    if (o != null && con != null) {
      try {
        stmt = con.prepareStatement(sql);
        toR(o, stmt);
        int row_effected = stmt.executeUpdate();
        if (row_effected > 0) {
          res.code = 0;
        }
        res.data = row_effected;
      } catch (Exception e) {
        res.message = e.getMessage();
        e.printStackTrace();
      } finally {
        ConnectionUtil.closePstmt(stmt);
        ConnectionUtil.closeConnection(con);
      }
    }

    return res;
  }
  // --8<-- [end:create]

  // --8<-- [start:delete]
  public Result delete(String no) {
    Result res = new Result(false);

    Connection con = null;
    PreparedStatement stmt = null;
    String sql = "delete from Student where no = ?;";
    con = ConnectionUtil.getConnection();
    if (con != null) {
      try {

        stmt = con.prepareStatement(sql);
        stmt.setString(1, no);
        int row_effected = stmt.executeUpdate();
        if (row_effected > 0) {
          res.code = 0;
        }
        res.data = row_effected;
      } catch (Exception e) {
        res.message = e.getMessage();
        e.printStackTrace();
      } finally {
        ConnectionUtil.closePstmt(stmt);
        ConnectionUtil.closeConnection(con);
      }
    }

    return res;
  }
  // --8<-- [end:delete]

  // --8<-- [start:update]
  public Result update(Student o) {
    Result res = new Result(false);

    Connection con = null;
    PreparedStatement stmt = null;
    String sql = "update Student set No = ?, Name = ?, Gender = ?, Age = ?, Dept = ? where no = ?";
    con = ConnectionUtil.getConnection();
    if (o != null && con != null) {
      try {

        stmt = con.prepareStatement(sql);
        toR(o, stmt);
        stmt.setString(6, o.getNo());
        int row_effected = stmt.executeUpdate();
        if (row_effected > 0) {
          res.code = 0;
        }
        res.data = row_effected;
      } catch (Exception e) {
        e.printStackTrace();
        res.message = e.getMessage();
      } finally {
        ConnectionUtil.closePstmt(stmt);
        ConnectionUtil.closeConnection(con);
      }
    }

    return res;
  }
  // --8<-- [end:update]

  // --8<-- [start:get]
  public Result get(String no) {
    Result res = new Result(false);

    Connection con = null;
    PreparedStatement stmt = null;
    String sql = "select * from Student where no = ?";
    con = ConnectionUtil.getConnection();
    if (con != null) {
      try {
        stmt = con.prepareStatement(sql);
        stmt.setString(1, no);
        ResultSet rs = stmt.executeQuery();
        Student last = null;
        while (rs.next()) {
          last = new Student();
          last.setNo(rs.getString("no"));
          last.setName(rs.getString("name"));
          last.setGender(rs.getString("gender"));
          last.setAge(rs.getInt("age"));
          last.setDept(rs.getString("dept"));
        }

        res.code = 0;
        res.data = last;
      } catch (Exception e) {
        res.message = e.getMessage();
        e.printStackTrace();
      } finally {
        ConnectionUtil.closePstmt(stmt);
        ConnectionUtil.closeConnection(con);
      }
    }

    return res;
  }
  // --8<-- [end:get]

  // --8<-- [start:getAll]
  public Result getAll() {
    Result res = new Result(false);

    Connection con = null;
    PreparedStatement stmt = null;
    String sql = "select * from Student";
    con = ConnectionUtil.getConnection();
    if (con != null) {
      try {
        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Student> data = new ArrayList<Student>();
        while (rs.next()) {
          Student last = toO(rs);
          data.add(last);
        }

        res.code = 0;
        res.data = data;
      } catch (Exception e) {
        res.message = e.getMessage();
        e.printStackTrace();
      } finally {
        ConnectionUtil.closePstmt(stmt);
        ConnectionUtil.closeConnection(con);
      }
    }

    return res;
  }
  // --8<-- [end:getAll]
}
