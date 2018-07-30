package com.gaoxi.product.dao;

import com.gaoxi.entity.product.CategoryEntity;
import com.gaoxi.req.product.CategoryQueryReq;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CategoryDAO {
    /**
     * 新增类别
     */
    int createCategoty(CategoryEntity categoryEntity);

    /**
     * 修改类别,增量更新
     */
    int updateCategory(CategoryEntity categoryEntity);

    /**
     * 删除类别
     */
    int deleteCategory(String categoryId);

    /**
     * 查询所有类别（分页）
     */
    List<CategoryEntity> findCategorys(CategoryQueryReq categoryQueryReq);
}
