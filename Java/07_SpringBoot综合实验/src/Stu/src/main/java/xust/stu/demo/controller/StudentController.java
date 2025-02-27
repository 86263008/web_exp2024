/*
 * File name : StudentController.java 2023-04-20
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.stu.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.io.OutputStream;
import java.util.ArrayList;
import java.net.URLEncoder;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.validation.annotation.Validated;

import xust.Result;
import xust.Result4GetPage;
import xust.stu.demo.domain.DeleteItems4Student;
import xust.stu.demo.domain.GetPage4Student;
import xust.stu.demo.domain.Student;
import xust.stu.demo.service.StudentServiceImpl;

import java.util.TreeMap;

/**
 * Class StudentController
 * Student action class.
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * @version 1.0, 2023-04-20
 */
@RestController
@RequestMapping("/demo/Student")
public class StudentController{
  private final static Logger log = LoggerFactory.getLogger(StudentController.class);
  
  @Autowired
  private StudentServiceImpl studentService = null;

	@RequestMapping(value = "/list-jquery")
	public ModelAndView doListJquery(){
		ModelAndView mv = new ModelAndView("/demo/Student/list-jquery");

		return mv;
	}
	@RequestMapping(value = "/list-bootstrap")
	public ModelAndView doListBootstrap(){
		ModelAndView mv = new ModelAndView("/demo/Student/list-bootstrap");

		return mv;
	}

	@PostMapping(value = "/add")
	public Result<Student> doAdd(@RequestBody(required=true) @Validated Student o){
		Result<Student> oc = studentService.create(o);

		return oc;
	}

	@PostMapping(value="/delete")
	public Result<Integer> doDelete(@RequestBody(required=true) List<String> ids){
		Result<Integer> oc = studentService.deleteItems(ids);

		return oc;
	}
 
	@PostMapping(value="/update")
	public Result<Integer> doUpdate(@RequestBody(required=true) @Validated Student o){
		Result<Integer> oc = studentService.update(o);

		return oc;
	}
 
	@PostMapping(value="/getPage")
	public Result<Result4GetPage<List<Student>>> doGetPage(@RequestBody(required=true) @Validated GetPage4Student p){
		Result<Result4GetPage<List<Student>>> res = new Result<Result4GetPage<List<Student>>>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", p.getId());
		Result<Integer> oc_size = studentService.size(params);
		if(oc_size.getCode() == 0){
			Result<List<Student>> oc_getPage = studentService.getPage(params, p.getPageNum(), p.getPageSize());
			if(oc_getPage.getCode() == 0){
				Result4GetPage<List<Student>> result = new Result4GetPage<List<Student>>();
				result.setTotal(oc_size.getData());
				result.setData(oc_getPage.getData());
				res.setData(result);
			}else{
				res.setCode(oc_getPage.getCode());
				res.setMessage(oc_getPage.getMessage());
			}
		}else{
			res.setCode(oc_size.getCode());
			res.setMessage(oc_size.getMessage());
		}

		return res;
	}

	@PostMapping(value="/template")
	public void doTemplate(HttpServletResponse response){
		try {
			String file_name = "学生表.xls";
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-disposition", "attachment;filename=" + file_name);
			response.flushBuffer();
			OutputStream outputStream = response.getOutputStream();
			studentService.buildXLSTemplate("学生表", "学生表", outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	@PostMapping(value="/toExcel")
	public void doToExcel(HttpServletResponse response, @RequestBody(required=true) @Validated GetPage4Student p){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", p.getId());
		Result<Integer> oc_size = studentService.size(params);
		String title="学生表";
		OutputStream outputStream = null;
		if(oc_size.getCode() == 0){		
			Result<List<Student>> oc_getPage = studentService.getPage(params, 1, 2000);
			if(oc_getPage.getCode() == 0){
        try {
          outputStream = response.getOutputStream();
          response.setContentType("application/vnd.ms-excel;charset=utf-8");
          String fileName = URLEncoder.encode(title + ".xls", "UTF-8");
          response.setHeader("Content-disposition", "attachment;filename=" + fileName);
          response.flushBuffer();
          studentService.export2XLS(oc_getPage.getData(), title, title, outputStream);
          outputStream.flush();
          outputStream.close();
        } catch (Exception e) {
          log.error("导出Excel异常", e);
        }finally {
          try {
            if(outputStream != null){
              outputStream.close();
            }
          } catch (Exception e1) {
            log.error("导出Excel关闭异常", e1);
          }
        }
			}
		}
	}
}

