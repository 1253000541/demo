package top.hkf.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="chuyun",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
    public class Article {
        //文章ID，这里必须为 id
        @Id
        @Field(type = FieldType.Integer)
        private Long id;
        //标题
        @Field(type = FieldType.Text,analyzer = "ik_Maxword")
        private String title;
        //内容
        private String content;
        //浏览量
        private Integer viewCount;
        //发布时间
        private Date createTime;
        //更新时间
        private Date updateTime;
    public Article(Long id,String title,String content){
        this.id=id;
        this.title=title;
        this.content=content;
    }
}

