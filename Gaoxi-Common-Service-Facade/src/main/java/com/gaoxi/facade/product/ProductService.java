package com.gaoxi.facade.product;

import com.gaoxi.entity.product.BrandEntity;
import com.gaoxi.entity.product.CategoryEntity;
import com.gaoxi.entity.product.ProductEntity;
import com.gaoxi.req.product.*;
import com.gaoxi.rsp.Result;

import java.util.List;

/**
 *
 */
public interface ProductService {
    /**
     * 新增产品
     */
    Result createProduct(ProdInsertReq prodInsertReq);

    /**
     * 增量更新产品
     */
    Result updateProduct(ProdUpdateReq prodUpdateReq);

    /**
     * 多条件查询所有产品（支持分页）
     */
    Result<List<ProductEntity>> findProducts(ProdQueryReq prodQueryReq);

    /**
     * 新增类别
     */
    Result createCategoty(CategoryEntity categoryEntity);

    /**
     * 增量更新类别
     */
    Result modifyCategory(CategoryEntity categoryEntity);

    /**
     * 删除类别
     */
    Result deleteCategory(String categoryId);

    /**
     * 新增品牌
     */
    Result createBrand(BrandInsertReq brandInsertReq);

    /**
     * 增量更新品牌
     */
    Result modifyBrand(BrandInsertReq brandInsertReq);

    /**
     * 多条件查询所有类别（支持分页）
     */
    Result<List<CategoryEntity>> findCategorys(CategoryQueryReq categoryQueryReq);

    /**
     * 多条件查询所有品牌（支持分页）
     */
    Result<List<BrandEntity>> findBrands(BrandQueryReq brandQueryReq);
}
