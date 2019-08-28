package top.hkf.demo.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.hkf.demo.entity.Article;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
   List<Article> findByTitle(String title);

   List<Article> findByTitleAndContent(String title,String content,Pageable pageable);
}