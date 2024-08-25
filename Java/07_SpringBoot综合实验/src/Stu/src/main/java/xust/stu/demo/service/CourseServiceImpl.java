package xust.stu.demo.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xust.Result;
import xust.ErrEnum;
import xust.stu.demo.dao.CourseDao;
import xust.stu.demo.domain.Course;

/**
 * Class CourseServiceImpl
 * CourseService interface implementation.
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * @version 1.0, 2023-04-20
 */
@Service
public class CourseServiceImpl implements CourseService{
  private final static Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
  
  @Autowired
  private CourseDao courseDao;

  @Override
  public Result<Course> create(Course newValue) {
    Result<Course> oc = new Result<Course>();
    
    try{
      //newValue.setSys_create_date(new Date());
      newValue.setId(UUID.randomUUID().toString());
      int effected = courseDao.create(newValue);
      if(effected > 0){
        oc.setData(newValue);
      }else{
        oc.setErr(ErrEnum.DB_CREATE_FAIL);
      }
    }catch(Exception e){
      oc.setErr(ErrEnum.DB_CREATE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }
  
  @Override
  public Result<Integer> deleteAll() {
    Result<Integer> oc = new Result<Integer>();
    
    try{
      oc.setData(courseDao.deleteAll());
    }catch(Exception e){
      oc.setErr(ErrEnum.DB_DELETE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }
  
  @Override
  public Result<Integer> deleteItems(List<String> items) {
    Result<Integer> oc = new Result<Integer>();
    
    try{
      oc.setData(courseDao.deleteItems(items));
    }catch(Exception e){
      oc.setErr(ErrEnum.DB_DELETE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }
  
  @Override
  public Result<Integer> delete(Map<String, Object> params) {
    Result<Integer> oc = new Result<Integer>();

    try {
      oc.setData(courseDao.delete(params));
    }catch(Exception e) {
      oc.setErr(ErrEnum.DB_DELETE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }

  @Override
  public Result<Integer> update(Course newValue) {
    Result<Integer> oc = new Result<Integer>();
    try{
      //newValue.setSys_last_update_date(new Date());
      oc.setData(courseDao.update(newValue));
    }catch(Exception e){
      oc.setErr(ErrEnum.DB_UPDATE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }
    return oc;
  }
  
  @Override
  public Result<Integer> size(Map<String, Object> params) {
    Result<Integer> oc = new Result<Integer>();

    try {
      oc.setData(courseDao.size(params));
    }catch(Exception e) {
      oc.setErr(ErrEnum.DB_SIZE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }
  
  @Override
  public Result<List<Course>> getPage(Map<String, Object> params, int pageNum, int pageSize) {
    Result<List<Course>> oc = new Result<List<Course>>();
    oc.setData(new ArrayList<Course>());
    
    try {
      oc.setData(courseDao.getPage(params, pageNum, pageSize));
    }catch(Exception e) {
      oc.setErr(ErrEnum.DB_PAGE_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }
    return oc;
  }
  
  public Result<Boolean> buildXLSTemplate(String worksheet_name, String title, OutputStream output) {
    Result<Boolean> oc = new Result<Boolean>();

    try {
      HSSFWorkbook wb = new HSSFWorkbook();
      HSSFSheet sheet = wb.createSheet(worksheet_name);

      // Header title
      HSSFRow row1 = sheet.createRow(0);
      HSSFCell cell = row1.createCell(0);
      cell.setCellValue(title);
      sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

      // Header
      HSSFRow row2 = sheet.createRow(1);
      // 设置列标题
      row2.createCell(0).setCellValue("编号");
      row2.createCell(1).setCellValue("课程名");
      row2.createCell(2).setCellValue("先修课");
      row2.createCell(3).setCellValue("学分");

      wb.write(output);
      //wb.close();
    } catch (Exception e) {
      oc.setErr(ErrEnum.EXPORT_EXCEL_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }

  @Override
  public Result<Boolean> export2XLS(List<Course> data, String worksheet_name, String title, OutputStream output) {
    Result<Boolean> oc = new Result<Boolean>();

    try {
      HSSFWorkbook wb = new HSSFWorkbook();
      HSSFSheet sheet = wb.createSheet(worksheet_name);

      // Header title
      HSSFRow row1 = sheet.createRow(0);
      HSSFCell cell = row1.createCell(0);
      cell.setCellValue(title);
      sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

      // Header
      HSSFRow row2 = sheet.createRow(1);
      // 设置列标题
      row2.createCell(0).setCellValue("Id");
      row2.createCell(1).setCellValue("编号");
      row2.createCell(2).setCellValue("课程名");
      row2.createCell(3).setCellValue("先修课");
      row2.createCell(4).setCellValue("学分");

      // 填充数据
      int row_number = 2;
      for (Course item : data) {
        HSSFRow row_new = sheet.createRow(row_number++);
        row_new.createCell(0).setCellValue(NullValue(item.getId()));
        row_new.createCell(1).setCellValue(NullValue(item.getNo()));
        row_new.createCell(2).setCellValue(NullValue(item.getName()));
        row_new.createCell(3).setCellValue(NullValue(item.getPreNo()));
        row_new.createCell(4).setCellValue(NullValue(item.getCredit()));
      }
      wb.write(output);
      //wb.close();
    } catch (Exception e) {
      oc.setErr(ErrEnum.EXPORT_EXCEL_FAIL);
      oc.setDetail(e.getLocalizedMessage());
      log.error(e.getMessage());
    }

    return oc;
  }
    
  private String NullValue(Object o) {
    return null == o ? "" : o.toString();
  }
}

