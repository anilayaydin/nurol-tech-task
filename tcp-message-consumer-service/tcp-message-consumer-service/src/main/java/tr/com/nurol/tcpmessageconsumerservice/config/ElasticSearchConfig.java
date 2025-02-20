package tr.com.nurol.tcpmessageconsumerservice.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RequestConfigCallback;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        // Create the low-level REST client for Elasticsearch
        RestClient lowLevelRestClient = RestClient.builder(
                        new HttpHost("elasticsearch", 9200, "http")) // Adjust the host/port if necessary
                .setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "Basic " + encodeCredentials())})
                .build();

        // Create the high-level client using the low-level client
        return new RestHighLevelClient(lowLevelRestClient);
    }

    private String encodeCredentials() {
        // Encode your username and password for basic authentication if needed (Base64 encoding)
        String credentials = "username:password";
        return Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
    }
}
