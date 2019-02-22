package com.yy.es.repository.es;

import com.yy.es.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * es 资源库接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 分页查询blog（去重）
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);

}
