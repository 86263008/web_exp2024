/*
 * File name : Course.java 2023-04-20
 * @generated May 28, 2023, 9:37:50 AM
 * @author XUST
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.stu.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import xust.stu.demo.domain.Course;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 使用真实的数据库，这里我们使用H2内存数据库
// @Rollback(value = false)    // 默认为true，数据库操作会回滚。改为false后，不会回滚
@ActiveProfiles("test")     // 使用appplication-test.yml作为配置文件
public class CourseDaoTest {
  @Autowired
  private CourseDao courseDao;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void setUpAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetPage() {
    Map<String, Object> params = new HashMap<String, Object>();
    
    List<Course> courses =   courseDao.getPage(params, 1, 5);
    assertEquals(5, courses.size());
    
    courses =   courseDao.getPage(params, 0, 5);
    assertEquals(5, courses.size());
    courses =   courseDao.getPage(params, 6, 5);
    assertEquals(3, courses.size());
  }
  
  @Test
  public void testSize() {
    //Just for H2 database.
    Map<String, Object> params = new HashMap<String, Object>();
    assertEquals(13,   courseDao.size(params));
  }

  @Test
  @Transactional
  @Rollback
  public void testDeleteItems() {
    List<Integer> items = new ArrayList<Integer>();
    items.add(3);
    items.add(7);
    items.add(14);
    
    assertEquals(2,   courseDao.deleteItems(items));
  }
  
  @Test
  @Transactional
  @Rollback
  public void testInsert() {
    Course newValue = new Course();
    newValue.setId("X0");
    newValue.setNo("X1");
    newValue.setName("X2");
    newValue.setPreNo("X3");
    newValue.setCredit(3.3);
    newValue.setId(7);
    
    assertEquals((Integer)7, newValue.getId());
    assertEquals(1,   courseDao.create(newValue));
    assertEquals((Integer)13, newValue.getId());
    assertEquals(14,   courseDao.size(new HashMap<String, Object>()));
  }
  
  @Test
  @Transactional
  @Rollback
  public void testUpdate() {
    //Just for H2 database.
    Course newValue = new Course();
    newValue.setId("X0");
    newValue.setNo("X1");
    newValue.setName("X2");
    newValue.setPreNo("X3");
    newValue.setCredit(3.3);
    
    assertEquals(1,   courseDao.update(newValue));
    
    newValue.setId(-1);
    assertEquals(0,   courseDao.update(newValue));
  }
}

