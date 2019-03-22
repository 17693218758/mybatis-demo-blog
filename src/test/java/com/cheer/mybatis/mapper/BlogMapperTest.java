package com.cheer.mybatis.mapper;

import static org.junit.Assert.*;

import com.cheer.mybatis.model.Blog;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class BlogMapperTest extends AbstractMapperTest {
    private BlogMapper blogMapper = null;

    @Before
    public void before(){
        blogMapper = this.session.getMapper(BlogMapper.class);
    }


    @Test
    public void findActiveBlogWithTitleLike() {
        List<Blog> blogList = blogMapper.findActiveBlogWithTitleLike("%习近平%");
        //断言可以查出一条记录
        assertEquals(1, blogList.size());
        System.out.println(blogList);


        List<Blog> blogList2 = blogMapper.findActiveBlogWithTitleLike(null);
        //断言可以查出一条记录
        assertEquals(2, blogList2.size());
        System.out.println(blogList2);
    }

    @Test
    public void findActiveBlogLike1() {
        List<Blog> blogList = blogMapper.findActiveBlogWithTitleLike1("%习近平%", "央视网", "新闻");
        assertEquals(1, blogList.size());
    }

    @Test
    public void findActiveBlogLike2() {
        List<Blog> blogList = blogMapper.findActiveBlogWithTitleLike2("%习近平%", "央视网");
        assertEquals(1, blogList.size());

        List<Blog> blogList1 = blogMapper.findActiveBlogWithTitleLike2(null, "央视网");
        assertEquals(1, blogList.size());

        List<Blog> blogList2 = blogMapper.findActiveBlogWithTitleLike2(null, null);
        assertEquals(1, blogList.size());
    }

    @Test
    public void update(){
        Blog blog = new Blog();
        blog.setId(1);
        blog.setState(null);
        blog.setAuthor(null);

        int result = this.blogMapper.update(blog);
        assertEquals(1,result);
    }

    @Test
    public void insertList(){
        Blog blog = new Blog();
        blog.setId(6);
        blog.setAuthor("6");
        blog.setTitle("6");
        blog.setState("6");
        blog.setTag("6");

        //ALT + SHIFT + INSERT 列编辑
        Blog blog1 = new Blog();
        blog1.setId(7);
        blog1.setAuthor("7");
        blog1.setTitle("7");
        blog1.setState("7");
        blog1.setTag("7");

        //List<Blog> blogList = new ArrayList<>();
        //blogList.add(blog);
        //blogList.add(blog1);

        List<Blog> blogList = Arrays.asList(blog, blog1);
        
        int result = blogMapper.insertList(blogList);
        assertEquals(2, result);




    }
}
