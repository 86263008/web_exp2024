package xust.stu.demo.service;

import java.util.ArrayList;
import xust.stu.Result;
import xust.stu.demo.domain.Student;

public class StudentServiceTest {
  public static void main(String[] args) {
    StudentService service = new StudentServiceImpl();

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
    service.create(o2);
    Result res_create = service.create(o1);
    System.out.println("create=" + res_create.code);

    Result res_update = service.update(o1);
    System.out.println("update=" + res_update.code);

    Result res_delete = service.delete("X1");
    System.out.println("delete=" + res_delete.code);

    Result res_get = service.get("X2");

    Result res_getAll = service.getAll();
    if(res_getAll.code == 0){
      for(Student o: (ArrayList<Student>)res_getAll.data){
        System.out.println(o.toString());
      }
    }
  }
}
