package com.gaoxi.facade.user;

import com.gaoxi.entity.user.ArticleEntity;

import java.util.List;

public interface ExampleService {

    String hello();

    /**
     * 查询指定作者的所有文章
     *
     * @param userId 作者id
     * @return 该作者的所有文章
     */
    List<ArticleEntity> findArticlesByUserId(String userId);

}