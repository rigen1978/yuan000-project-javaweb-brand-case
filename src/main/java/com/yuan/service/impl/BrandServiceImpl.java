package com.yuan.service.impl;

import com.yuan.mapper.BrandMapper;
import com.yuan.pojo.Brand;
import com.yuan.service.BrandService;
import com.yuan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @className: BrandServiceImpl
 * @package: com.yuan.service.impl
 * @description:
 * @author: liyuan
 * @create: 2024/02/09 1:26
 * @version: 1.0
 */
public class BrandServiceImpl implements BrandService {
	// 1.创建SqlSessionFactory 工厂对象
	SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

	@Override
	public List<Brand> selectAll() {
		// 2.获取SqlSession对象
		SqlSession sqlSession = factory.openSession();

		// 3.获取mapper对象
		BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

		// 4.调用方法
		List<Brand> brands = brandMapper.selectAll();

		// 5.释放资源
		sqlSession.close();

		return brands;
	}
}