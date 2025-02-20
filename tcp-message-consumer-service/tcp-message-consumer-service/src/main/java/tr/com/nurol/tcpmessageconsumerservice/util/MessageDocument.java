package tr.com.nurol.tcpmessageconsumerservice.util;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "messages")
public class MessageDocument {

    @Id
    private String id;
    private String message;

    public MessageDocument(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
