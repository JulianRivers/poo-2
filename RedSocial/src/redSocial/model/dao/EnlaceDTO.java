/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model.dao;

import java.util.Calendar;

/**
 *
 * @author Julian
 */
public class EnlaceDTO extends PublicacionDTO{
    private String url;

    public EnlaceDTO(String texto, Calendar fechaPublicacion, String usuario, String url) {
        super(texto, fechaPublicacion, usuario);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
