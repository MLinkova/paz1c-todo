/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 *
 * @author student
 */
public class KategoriaRowCallBachHandler implements  RowCallbackHandler{

    private Long predosleID;
    private List<Kategoria> kategorie= new LinkedList<>();
    
    @Override
    public void processRow(ResultSet rs) throws SQLException {
       Long kategid= rs.getLong(6);
       if(zmeniloSa(predosleID,kategid)){
           predosleID=kategid;
            Kategoria kategoria= new Kategoria();
            kategoria.setId(kategid);
            kategoria.setNazov(rs.getString(7));
             kategorie.add(kategoria);
             Long id=rs.getLong(1);
             if( id != 0){
             Uloha uloha= new Uloha();
             uloha.setId(rs.getLong(1));
             uloha.setNazov(rs.getString(2));
             uloha.setDate(rs.getDate(3));
             uloha.setSplnena(rs.getBoolean(4));
             
            
             kategoria.getUloha().add(uloha);
             }
       } else {
             Uloha uloha= new Uloha();
             uloha.setId(rs.getLong(1));
             uloha.setNazov(rs.getString(2));
             uloha.setDate(rs.getDate(3));
             uloha.setSplnena(rs.getBoolean(4));
             
             kategorie.get(kategorie.size()-1).getUloha().add(uloha);
       
       }
    }

    private boolean zmeniloSa(Long predosleID, Long kategid) {
        if(predosleID == null){
            return true;
        } else {
            return predosleID != kategid;
        
        }
    }

    public List<Kategoria> getKategorie() {
        return kategorie;
    }
    
    
}
