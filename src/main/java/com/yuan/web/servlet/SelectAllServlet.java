package com.yuan.web.servlet;
/**
 * @className: Servlet
 * @package: com.yuan.web.servlet
 * @description:
 * @author: liyuan
 * @create: 2024/02/09 1:31
 * @version: 1.0
 */

import com.alibaba.fastjson.JSON;
import com.yuan.pojo.Brand;
import com.yuan.service.BrandService;
import com.yuan.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.调用service查询
		List<Brand> brands = brandService.selectAll();

		// 2.将集合装为json数据
		String jsonString = JSON.toJSONString(brands);

		// 3.写数据
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonString);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
