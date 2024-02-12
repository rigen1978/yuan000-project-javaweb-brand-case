package com.yuan.web.servlet;
/**
 * @className: Servlet
 * @package: com.yuan.web.servlet
 * @description:
 * @author: liyuan
 * @create: 2024/02/10 11:33
 * @version: 1.0
 */

import com.alibaba.fastjson.JSON;
import com.yuan.pojo.Brand;
import com.yuan.pojo.PageBean;
import com.yuan.service.BrandService;
import com.yuan.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
	private BrandService brandService = new BrandServiceImpl();

	/**
	 * 查询所有
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.调用service查询
		List<Brand> brands = brandService.selectAll();

		// 2.将集合装为json数据
		String jsonString = JSON.toJSONString(brands);

		// 3.写数据
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonString);
	}

	/**
	 * 添加数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	/**
	 * 修改品牌
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.接受数据
		BufferedReader br = request.getReader();
		String params = br.readLine();

		// 2.转为brand对象
		Brand brand = JSON.parseObject(params, Brand.class);

		// 3.调用serice进行添加
		brandService.updateById(brand);

		// 4.响应成功标识
		response.getWriter().write("success");
	}

	/**
	 * 删除指定品牌
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		System.out.println(id);
		// 3.调用serice进行删除
		brandService.deleteById(id);
		// 4.响应成功标识
		response.getWriter().write("success");
	}

	/**
	 * 批量删除
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 接收数据  [1,2,3]
		BufferedReader br = request.getReader();
		String params = br.readLine();//json字符串

		//转为 int[]
		int[] ids = JSON.parseObject(params, int[].class);

		//2. 调用service添加
		brandService.deleteByIds(ids);

		//3. 响应成功的标识
		response.getWriter().write("success");
	}

	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
		String _currentPage = request.getParameter("currentPage");
		String _pageSize = request.getParameter("pageSize");

		int currentPage = Integer.parseInt(_currentPage);
		int pageSize = Integer.parseInt(_pageSize);

		//2. 调用service查询
		PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

		//3. 转为JSON
		String jsonString = JSON.toJSONString(pageBean);

		//4. 写数据
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonString);

	}

	/**
	 * 分页条件查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
		String _currentPage = request.getParameter("currentPage");
		String _pageSize = request.getParameter("pageSize");

		int currentPage = Integer.parseInt(_currentPage);
		int pageSize = Integer.parseInt(_pageSize);

		// 获取查询条件对象
		BufferedReader br = request.getReader();
		String params = br.readLine();//json字符串

		//转为 Brand
		Brand brand = JSON.parseObject(params, Brand.class);


		//2. 调用service查询
		PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

		//2. 转为JSON
		String jsonString = JSON.toJSONString(pageBean);
		//3. 写数据
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonString);
	}


}
