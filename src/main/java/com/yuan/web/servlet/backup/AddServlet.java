package com.yuan.web.servlet.backup;
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
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.接受数据
		BufferedReader br = request.getReader();
		String params = br.readLine();

		// 2.转为brand对象
		Brand brand = JSON.parseObject(params, Brand.class);

		// 3.调用serice进行添加
		brandService.add(brand);

		// 4.响应成功标识
		response.getWriter().write("success");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
