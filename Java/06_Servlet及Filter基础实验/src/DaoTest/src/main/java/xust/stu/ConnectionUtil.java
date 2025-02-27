package xust.stu;

import java.sql.*;

/**
 * 连接辅助类
 */
public class ConnectionUtil {
  //--8<-- [start:getConnection]
  /**
   * 创建连接
   * 
   * @return 连接对象
   */
  public static Connection getConnection() {
    Connection res = null;

    try {
      Class.forName("org.sqlite.JDBC");
      //在数据库文件stu.db存入在D盘下
      res = DriverManager.getConnection("jdbc:sqlite:d:/stu.db");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }

    return res;
  }
  //--8<-- [end:getConnection]

  //--8<-- [start:closeConnection]
  /**
   * 关闭连接
   * 
   * @param connection 连接对象
   */
  public static void closeConnection(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
      }
    }
  }
  //--8<-- [end:closeConnection]

  //--8<-- [start:closePstmt]
  /**
   * 关闭语句
   * 
   * @param pstmt 语句对象
   */
  public static void closePstmt(PreparedStatement pstmt) {
    if (pstmt != null) {
      try {
        pstmt.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
      }
    }
  }
  //--8<-- [end:closePstmt]

  //--8<-- [start:closeStmt]
  /**
   * 关闭语句
   * 
   * @param pstmt 语句对象
   */
  public static void closeStmt(Statement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
      }
    }
  }
  //--8<-- [end:closeStmt]
}
