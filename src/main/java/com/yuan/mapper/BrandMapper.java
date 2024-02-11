package com.yuan.mapper;

import com.yuan.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
	/**
	 * 查询所有
	 * @return
	 */
	@Select("select * from tb_brand_cn")
	@ResultMap("brandResultMap")
	List<Brand> selectAll();

	/**
	 * 添加数据
	 * @param brand
	 */
	@Insert("insert into tb_brand_cn values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
	void add(Brand brand);

	/**
	 * 修改
	 * @param brand
	 */
	@Update("update tb_brand_cn set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
	void updateById(Brand brand);

	/**
	 * 删除指定数据
	 * @param id
	 */
	@Delete("delete from tb_brand_cn where id = #{id}")
	void deleteById(int id);

	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(@Param("ids") int[] ids);
}
