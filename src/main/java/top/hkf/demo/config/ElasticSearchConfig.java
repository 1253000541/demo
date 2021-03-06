package top.hkf.demo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.InetAddress;

@Configuration
public class ElasticSearchConfig {
    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
    @Bean
    public TransportClient transportClient() {
        logger.info("初始化开始。。。。。");
        TransportClient client = null;
        try {
            TransportAddress transportAddress = new InetSocketTransportAddress(InetAddress.getByName("localhost"),
                    Integer.valueOf(9300));
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name","elasticsearch")
                    .build();
            //配置信息Settings自定义
            client = new PreBuiltTransportClient(esSetting);
            client.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            logger.error("elasticsearch TransportClient create error!!!", e);
        }
        return client;
    }
}