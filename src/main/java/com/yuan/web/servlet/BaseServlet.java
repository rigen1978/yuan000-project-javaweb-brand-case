package com.yuan.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @className: BaseServlet
 * @package: com.yuan.web.servlet
 * @description:
 * @author: liyuan
 * @create: 2024/02/10 11:29
 * @version: 1.0
 */
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取请求路径
		String uri = req.getRequestURI();

		// 2.获取最后一段路径
		int index = uri.lastIndexOf("/");
		String methodName = uri.substring(index + 1);

		// 3.执行方法
		Class<? extends BaseServlet> cls = this.getClass();

		// 4.获取当前执行的方法
		try {
			Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}


	}
}
