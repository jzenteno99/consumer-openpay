package com.openpay.consumer_openpay.configuracion;

import org.apache.hc.core5.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory
  implements FactoryBean<RestTemplate>, InitializingBean {
 
    private RestTemplate restTemplate;

    public RestTemplate getObject() {
        return restTemplate;
    }
    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }
    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() {
        HttpHost host = new HttpHost("localhost", "http", 8082);
        restTemplate = new RestTemplate(
          new HttpComponentsClientHttpRequestFactoryBasicAuth(host));
    }
}