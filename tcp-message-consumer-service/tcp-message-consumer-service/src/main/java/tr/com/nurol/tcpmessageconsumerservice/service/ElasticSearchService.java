package tr.com.nurol.tcpmessageconsumerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import tr.com.nurol.tcpmessageconsumerservice.util.MessageDocument;

@Service
public class ElasticSearchService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public void indexMessage(String message, String index) {
        // Create a document object
        MessageDocument document = new MessageDocument(message);

        // Save the document to Elasticsearch using the template
        elasticsearchRestTemplate.save(document);

        System.out.println("Message indexed to Elasticsearch");
    }
}
