package xust.demo.stu.domain;

/**
 * Class Student
 * 学生表
 * 
 * @author XUST
 * @version 1.0, 2023-04-20
 */
public class Student {

  // --8<-- [start:no]
  /**
   * 学号
   */
  private String no;

  public String getNo() {
    return no;
  }

  public void setNo(String newValue) {
    no = newValue;
  }

  // --8<-- [end:no]
  // --8<-- [start:name]
  /**
   * 姓名
   */
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String newValue) {
    name = newValue;
  }

  // --8<-- [end:name]
  // --8<-- [start:gender]
  /**
   * 性别
   */
  private String gender;

  public String getGender() {
    return gender;
  }

  public void setGender(String newValue) {
    gender = newValue;
  }

  // --8<-- [end:gender]
  // --8<-- [start:age]
  /**
   * 年龄
   */
  private Integer age;

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer newValue) {
    age = newValue;
  }

  // --8<-- [end:age]
  // --8<-- [start:dept]
  /**
   * 所在系
   */
  private String dept;

  public String getDept() {
    return dept;
  }

  public void setDept(String newValue) {
    dept = newValue;
  }
  // --8<-- [end:dept]

  @Override
  /**
   * 将对象序列化为JSON字符串
   */
  public String toString() {
    return "{" + "\"no\": " + "\"" + no + "\"" + ", " + "\"name\": " + "\"" + name + "\"" + ", " + "\"gender\": " + "\""
        + gender + "\"" + ", " + "\"age\": " + age + ", " + "\"dept\": " + "\"" + dept + "\"" + "}";
  }
}
