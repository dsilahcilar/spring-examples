package com.saha.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BilyonerClient {
    @Autowired
    private RestTemplate restTemplate;

    public void liveScores() {
        ResponseEntity<String> canliSonuclar = restTemplate
                .getForEntity("https://www.bilyoner.com/ilive-scores", String.class);

        System.out.println(canliSonuclar.getBody());


    }

    public void gitLabClient() {
        ResponseEntity<String> result = restTemplate.getForEntity("https://api.github.com/repos/netflix/feign/contributors", String.class);
        System.out.println("result = " + result);
    }


}
