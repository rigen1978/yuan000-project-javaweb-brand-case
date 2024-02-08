package com.yuan.mapper;

import com.yuan.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
	/**
	 * 查询所有
	 * @return
	 */
	@Select("select * from tb_brand_cn")
	@ResultMap("brandResultMap")
	List<Brand> selectAll();
}
