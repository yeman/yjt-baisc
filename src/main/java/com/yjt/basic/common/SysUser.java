package com.yjt.basic.common;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @Description "TODO"
 * @Author :ym
 * @Date: 2018/11/27 19:45
 **/
@Data
@SolrDocument
public class SysUser {

    @Field
    @Id
    private String id;
    @Field
    private String userCode;
    @Field
    private String userName;
    @Field
    private String desc;
}