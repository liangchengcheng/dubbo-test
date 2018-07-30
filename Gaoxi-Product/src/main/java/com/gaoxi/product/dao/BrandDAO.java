package com.gaoxi.product.dao;

import com.gaoxi.entity.product.BrandEntity;
import com.gaoxi.req.product.BrandInsertReq;
import com.gaoxi.req.product.BrandQueryReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDAO {

    /**
     * 新增品牌
     */
    int createBrand(BrandInsertReq brandInsertReq);

    /**
     * 增量更新品牌
     */
    int updateBrand(BrandInsertReq brandInsertReq);


    /**
     * 查询所有品牌（支持分页）
     */
    List<BrandEntity> findBrands(BrandQueryReq brandQueryReq);
}
