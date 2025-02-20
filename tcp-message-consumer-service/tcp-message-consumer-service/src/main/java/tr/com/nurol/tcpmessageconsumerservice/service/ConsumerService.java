package tr.com.nurol.tcpmessageconsumerservice.service;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RabbitListener(queues = "nurolTech")  // This is the queue where messages are consumed from
    public void consumeMessage(String message) {
        // Log the consumed message (you can use your logger here)
        System.out.println("Consumed message: " + message);

        // Index the message into Elasticsearch
        indexMessage(message);
    }

    private void indexMessage(String message) {
        // Create the request to index the message in Elasticsearch
        IndexRequest indexRequest = new IndexRequest("messages")
                .source("message", message);

        try {
            // Execute the index request
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("Message indexed to Elasticsearch with id: " + indexResponse.getId());
        } catch (IOException e) {
            System.err.println("Error indexing message to Elasticsearch: " + e.getMessage());
        }
    }
}
