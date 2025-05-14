package com.encurtador.projeto.repository;

import com.encurtador.projeto.enetity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, String> {
    Optional<Url> findByUrlCurta(String url);

    Url findByUrlLonga(String urlLonga);
}
