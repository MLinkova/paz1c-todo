/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.todo;

import java.util.*;


public class Kategoria {
    
     private Long id;
     private String nazov;
     private List<Uloha> uloha = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public List<Uloha> getUloha() {
        return uloha;
    }

    public void setUloha(List<Uloha> uloha) {
        this.uloha = uloha;
    }
    
}
