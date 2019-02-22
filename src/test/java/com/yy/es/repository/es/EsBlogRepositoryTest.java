package com.yy.es.repository.es;

import com.yy.es.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        // 清除所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("登鹳鹤楼1", "王之涣1", "白日依山尽1"));
        esBlogRepository.save(new EsBlog("哈哈", "哈罗", "哈哈"));
        esBlogRepository.save(new EsBlog("嘻嘻", "啧啧", "嘻嘻"));
    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
        Pageable pageable = new PageRequest(0, 20);
        String title = "哈";
        String summary = "哈罗";
        String content = "哈";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary,content,pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);
        System.out.println("--start--");
        for (EsBlog blog : page.getContent()){
            System.out.println(blog.toString());
        }
        System.out.println("--end--");
    }
}