/*
 * File name : StuCourseController.java 2023-04-20
 * Copyright 2023 XUST. All rights reserved.
 */
package xust.demo.stu.controller;

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
import xust.demo.stu.domain.DeleteItems4StuCourse;
import xust.demo.stu.domain.GetPage4StuCourse;
import xust.demo.stu.domain.StuCourse;
import xust.demo.stu.service.StuCourseServiceImpl;

import java.util.TreeMap;

/**
 * Class StuCourseController
 * StuCourse action class.
 * @generated May 28, 2023, 9:37:49 AM
 * @author XUST
 * @version 1.0, 2023-04-20
 */
@RestController
@RequestMapping("/demo/StuCourse")
public class StuCourseController{
  private final static Logger log = LoggerFactory.getLogger(StuCourseController.class);
  
  @Autowired
  private StuCourseServiceImpl stuCourseService = null;

	@RequestMapping(value = "/list-jquery")
	public ModelAndView doListJquery(){
		ModelAndView mv = new ModelAndView("/demo/StuCourse/list-jquery");

		return mv;
	}
	@RequestMapping(value = "/list-bootstrap")
	public ModelAndView doListBootstrap(){
		ModelAndView mv = new ModelAndView("/demo/StuCourse/list-bootstrap");

		return mv;
	}

	@PostMapping(value = "/add")
	public Result<StuCourse> doAdd(@RequestBody(required=true) @Validated StuCourse o){
		Result<StuCourse> oc = stuCourseService.create(o);

		return oc;
	}

	@PostMapping(value="/delete")
	public Result<Integer> doDelete(@RequestBody(required=true) List<String> ids){
		Result<Integer> oc = stuCourseService.deleteItems(ids);

		return oc;
	}
 
	@PostMapping(value="/update")
	public Result<Integer> doUpdate(@RequestBody(required=true) @Validated StuCourse o){
		Result<Integer> oc = stuCourseService.update(o);

		return oc;
	}
 
	@PostMapping(value="/getPage")
	public Result<Result4GetPage<List<StuCourse>>> doGetPage(@RequestBody(required=true) @Validated GetPage4StuCourse p){
		Result<Result4GetPage<List<StuCourse>>> res = new Result<Result4GetPage<List<StuCourse>>>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", p.getId());
		Result<Integer> oc_size = stuCourseService.size(params);
		if(oc_size.getCode() == 0){
			Result<List<StuCourse>> oc_getPage = stuCourseService.getPage(params, p.getPageNum(), p.getPageSize());
			if(oc_getPage.getCode() == 0){
				Result4GetPage<List<StuCourse>> result = new Result4GetPage<List<StuCourse>>();
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
			String file_name = "学生选课表.xls";
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-disposition", "attachment;filename=" + file_name);
			response.flushBuffer();
			OutputStream outputStream = response.getOutputStream();
			stuCourseService.buildXLSTemplate("学生选课表", "学生选课表", outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	@PostMapping(value="/toExcel")
	public void doToExcel(HttpServletResponse response, @RequestBody(required=true) @Validated GetPage4StuCourse p){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", p.getId());
		Result<Integer> oc_size = stuCourseService.size(params);
		String title="学生选课表";
		OutputStream outputStream = null;
		if(oc_size.getCode() == 0){		
			Result<List<StuCourse>> oc_getPage = stuCourseService.getPage(params, 1, 2000);
			if(oc_getPage.getCode() == 0){
        try {
          outputStream = response.getOutputStream();
          response.setContentType("application/vnd.ms-excel;charset=utf-8");
          String fileName = URLEncoder.encode(title + ".xls", "UTF-8");
          response.setHeader("Content-disposition", "attachment;filename=" + fileName);
          response.flushBuffer();
          stuCourseService.export2XLS(oc_getPage.getData(), title, title, outputStream);
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
