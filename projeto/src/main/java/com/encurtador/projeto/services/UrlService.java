package com.encurtador.projeto.services;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.encurtador.projeto.enetity.Url;
import com.encurtador.projeto.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

     UrlRepository repositorio;

     public UrlService(UrlRepository repositorio) {
        this.repositorio = repositorio;
     }

    public String  cadastraUrl(String urlLonga) {
        if(!repositorio.existsById(urlLonga)){

            String urlCurta = gerarUrlCurta();
            repositorio.save(new Url(urlLonga, urlCurta));

            return urlCurta;
        }else{

            Url url = repositorio.findByUrlLonga(urlLonga);
            return url.getUrlCurta();
        }
    }

    public String gerarUrlCurta(){
         return NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, NanoIdUtils.DEFAULT_ALPHABET, 6);
    }

    public String redirecionar(String code) {
         Optional<Url> resultado = repositorio.findByUrlCurta(code);
        return resultado.map(Url::getUrlLonga).orElse(null);
    }
}
