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

}
