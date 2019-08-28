package top.hkf.demo.redistest.demo;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import top.hkf.demo.dao.ArticleRepository;
import top.hkf.demo.entity.Article;
import org.springframework.data.domain.Page;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void initRepositoryData() {
        template.createIndex(Article.class);//创建索引库
        //清除所有数据
        articleRepository.deleteAll();
        Article article = new Article();
        article.setId((long) 1);
        article.setTitle("《蝶恋花》");
        article.setContent("槛菊愁烟兰泣露，罗幕轻寒，燕子双飞去。明月不谙离恨苦，斜光到晓穿朱户。昨夜西风凋碧树，独上高楼，望尽天涯路。欲寄彩笺兼尺素，山长水阔知何处？");
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setViewCount(678);
        articleRepository.save(article);
        Article article2 = new Article();
        article2.setId((long) 2);
        article2.setTitle("《蝶恋花》");
        article2.setContent("伫倚危楼风细细，望极春愁，黯黯生天际。草色烟光残照里，无言谁会凭阑意。拟把疏狂图一醉，对酒当歌，强乐还无味。衣带渐宽终不悔，为伊消得人憔悴。");
        article2.setCreateTime(new Date());
        article2.setUpdateTime(new Date());
        article.setViewCount(367);
        articleRepository.save(article2);
        Article article3 = new Article();
        article3.setId((long) 3);
        article3.setTitle("《青玉案·元夕》");
        article3.setContent("东风夜放花千树，更吹落，星如雨。宝马雕车香满路。凤箫声动，玉壶光转，一夜鱼龙舞。蛾儿雪柳黄金缕，笑语盈盈暗香去。众里寻他千百度，蓦然回首，那人却在，灯火阑珊处。");
        article3.setCreateTime(new Date());
        article3.setUpdateTime(new Date());
        article3.setViewCount(786);
        articleRepository.save(article3);
    }

    @Test
    public void findDistinctByTitleContainingOrContentContainingTest() throws Exception {
        String title = "蝶恋花";
        List<Article> list = articleRepository.findByTitle(title);
//        List<Long> collect = list.stream().filter(article -> {
//            return article.getId() > 5;
//        }).map(Article::getId).collect(Collectors.toList());
    }

    //自定义查询，根据命名规则
    @Test
    public void findByTitleAndContent() {
        Pageable pageable = PageRequest.of(0, 2);//分页,从0开始,不分页默认没页10条
        articleRepository.findByTitleAndContent("zs", "123", pageable);
    }

    //先分词，在查询，分词之间是and关系，即所有分词都应在一段话中
    //需求是只要包含任何一个词即可查出来，即queryString,queryTerm
    @Test
    public void testNativeSearchQuery() {
        //创建查询对象
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("123").defaultField("title"))
                .withPageable(PageRequest.of(0, 3)).build();
        //执行查询
        List<Article> articles = template.queryForList(nativeSearchQuery, Article.class);
        articles.forEach(a -> System.out.println(a));
    }

    //高亮显示，字段，前缀，后缀。在执行查询之前设置高亮显示
    @Test
    public void testFilter() {
        List<Article> list=Arrays.asList(new Article(1l,"123","123"),
                new Article(5l,"123","123"),
                new Article(6l,"123","123"),
                new Article(7l,"123","123"),
                new Article(8l,"123","123"));

       list.stream().filter(article ->
           article.getId() > 5
        ).map(Article::getId).collect(Collectors.toList()).forEach(a-> System.out.println(a));
    }

}