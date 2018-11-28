package com.yjt.basic.search.solr;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.solr.SolrProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description "TODO"
 * @Author :ym
 * @Date: 2018/11/28 9:06
 **/
@ConditionalOnExpression("${spring.data.solr.enable}")
@Configuration
public class CloudSolrClientConfig{

    @Autowired
    private SolrProperties properties;

    @ConditionalOnProperty( prefix = "spring.data.solr",  name = "zk-host")
    @Bean
    public CloudSolrClient cloudSolrClient(){
        return new CloudSolrClient.Builder(Arrays.asList(this.properties.getZkHost()), Optional.empty()).build();
    }
    @Bean
    public SolrClient solrClient() {
         return createSolrClient();
    }

    private SolrClient createSolrClient() {
        if (org.springframework.util.StringUtils.hasText(this.properties.getZkHost())) {
            return new CloudSolrClient.Builder(Arrays.asList(this.properties.getZkHost()),
                    Optional.empty()).build();
        }
        return new HttpSolrClient.Builder(this.properties.getHost()).build();
    }
}