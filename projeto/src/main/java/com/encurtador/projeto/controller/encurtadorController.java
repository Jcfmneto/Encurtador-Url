package com.encurtador.projeto.controller;


import com.encurtador.projeto.dto.UrlDto;
import com.encurtador.projeto.enetity.Url;
import com.encurtador.projeto.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/encurta")
public class encurtadorController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<String> gerarUrlCurta(@RequestBody UrlDto dto){
       String urlCurta = urlService.cadastraUrl(dto.url());
        return ResponseEntity.ok("http:/localhost:8080/encurta/" + urlCurta);
    }
    @GetMapping("{code}")
    public ResponseEntity<?> getUrl(@PathVariable String code){
       var url = urlService.redirecionar(code);

       if(url != null){
           HttpHeaders headers = new HttpHeaders();
           headers.setLocation(URI.create(url));
           return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
       }
        return ResponseEntity.notFound().build();
    }
}
