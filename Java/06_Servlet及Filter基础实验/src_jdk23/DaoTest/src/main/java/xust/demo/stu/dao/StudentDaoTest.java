package xust.demo.stu.dao;

import java.util.ArrayList;
import xust.stu.Result;
import xust.demo.stu.domain.Student;

public class StudentDaoTest {
  public static void main(String[] args) {
    StudentDao dao = new StudentDaoImpl();
    Result res_init = dao.init();
    System.out.println("init=" + res_init.code);

    Student o1 = new Student();
    o1.setNo("X1");
    o1.setName("X1");
    o1.setGender("X1");
    o1.setAge(1);
    o1.setDept("X1");

    Student o2 = new Student();
    o2.setNo("X2");
    o2.setName("X2");
    o2.setGender("X2");
    o2.setAge(2);
    o2.setDept("X2");
    dao.create(o2);
    Result res_create = dao.create(o1);
    System.out.println("create=" + res_create.code);

    Result res_update = dao.update(o1);
    System.out.println("update=" + res_update.code);

    Result res_delete = dao.delete("X1");
    System.out.println("delete=" + res_delete.code);

    Result res_get = dao.get("X2");

    Result res_getAll = dao.getAll();
    if (res_getAll.code == 0) {
      for (Student o : (ArrayList<Student>) res_getAll.data) {
        System.out.println(o.toString());
      }
    }
  }
}
