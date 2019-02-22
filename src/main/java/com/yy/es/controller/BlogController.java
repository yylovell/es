package com.yy.es.controller;

import com.yy.es.domain.es.EsBlog;
import com.yy.es.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private EsBlogRepository esBlogRepository;

    // 数据是在测试用例中初始化
    @GetMapping
    public List<EsBlog> list(EsBlog esBlog, @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(esBlog.getTitle(), esBlog.getSummary(), esBlog.getContent(),pageable);

        return page.getContent();
    }

}
