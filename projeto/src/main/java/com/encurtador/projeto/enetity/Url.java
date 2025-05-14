package com.encurtador.projeto.enetity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "url")
public class Url {

    @Id
    @Column(name = "url_longa")
    private String urlLonga;

    @Column(name = "url_curta")
    private String urlCurta;

    public Url(String urlLonga, String urlCurta) {
    this.urlLonga = urlLonga;
    this.urlCurta = urlCurta;
    }

    public Url() {}

public String getUrlLonga() {
    return urlLonga;}

public String getUrlCurta() {
        return urlCurta;
}

}


