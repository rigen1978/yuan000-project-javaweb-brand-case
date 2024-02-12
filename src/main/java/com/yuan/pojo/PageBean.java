package com.yuan.pojo;

import java.util.List;

/**
 * @className: PageBean
 * @package: com.yuan.pojo
 * @description:
 * @author: liyuan
 * @create: 2024/02/11 16:21
 * @version: 1.0
 */
public class PageBean<T> {
	// 总记录数
	private int totalCount;
	// 当前页数据
	private List<T> rows;

	public PageBean() {
	}

	public PageBean(int totalCount, List<T> rows) {
		this.totalCount = totalCount;
		this.rows = rows;
	}

	/**
	 * 获取
	 * @return totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 获取
	 * @return rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * 设置
	 * @param rows
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String toString() {
		return "PageBean{totalCount = " + totalCount + ", rows = " + rows + "}";
	}
}
