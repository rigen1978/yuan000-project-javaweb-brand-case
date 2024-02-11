package com.yuan.service;

import com.yuan.pojo.Brand;

import java.util.List;

/**
 * @className: BrandService
 * @package: com.yuan.service
 * @description:
 * @author: liyuan
 * @create: 2024/02/09 1:25
 * @version: 1.0
 */
public interface BrandService {

	/**
	 * 查询所有
	 * @return
	 */
	List<Brand> selectAll();

	/**
	 * 添加数据
	 * @param brand
	 */
	void add(Brand brand);

	/**
	 * 修改
	 * @param brand
	 */
	void updateById(Brand brand);


	/**
	 * 删除指定数据
	 * @param id
	 */
	void deleteById(int id);

	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(int[] ids);

}
