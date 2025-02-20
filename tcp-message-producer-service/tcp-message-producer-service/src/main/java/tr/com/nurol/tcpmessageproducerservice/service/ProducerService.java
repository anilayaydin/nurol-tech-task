package tr.com.nurol.tcpmessageproducerservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void startTcpServer() {
        try (ServerSocket serverSocket = new ServerSocket(9090)) { // TCP sample port 9090
            logger.info("TCP Server listening on port 9090...");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    logger.info("New connection established: " + socket.getRemoteSocketAddress());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message = reader.readLine();
                    if (message != null) {
                        logger.info("Received message: " + message);
                        sendToRabbitMQ(message);
                    }
                } catch (IOException e) {
                    logger.error("Error processing incoming TCP message", e);
                }
            }
        } catch (IOException e) {
            logger.error("Error starting TCP server", e);
        }
    }

    private void sendToRabbitMQ(String message) {
        rabbitTemplate.convertAndSend("messageQueue", message);
        logger.info("Message sent to RabbitMQ: " + message);
    }
}
