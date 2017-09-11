package com.sulevsky.dataconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${dataconsumer.own-message}")
    private String ownMessage;

    @Autowired
    private DataProviderClient dataProviderClient;

    @GetMapping
    public AggregatedMessage readAggregatedMessage() {
        DataProviderMessage dataProviderMessage = dataProviderClient.getDataProviderMessage();

        return new AggregatedMessage(dataProviderMessage.getId(),
                                     dataProviderMessage.getContent(),
                                     ownMessage);
    }
}
