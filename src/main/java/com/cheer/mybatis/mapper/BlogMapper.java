package com.cheer.mybatis.mapper;

import com.cheer.mybatis.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    List<Blog> findActiveBlogWithTitleLike(@Param("title") String title);

    List<Blog> findActiveBlogWithTitleLike1(@Param("title") String title, @Param("author") String author, @Param("tag") String tag);

    List<Blog> findActiveBlogWithTitleLike2(@Param("title") String title, @Param("author") String author);

    int update(Blog blog);


    int insertList(List<Blog> blogList);
}
