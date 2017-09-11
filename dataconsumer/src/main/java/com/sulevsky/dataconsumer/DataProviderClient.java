package com.sulevsky.dataconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dataProvider", url = "${dataProvider.url}")
public interface DataProviderClient {
    @GetMapping("/message")
    DataProviderMessage getDataProviderMessage();
}
