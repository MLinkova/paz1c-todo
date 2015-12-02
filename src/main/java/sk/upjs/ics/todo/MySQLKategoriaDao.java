/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class MySQLKategoriaDao implements KategoriaDao{

 private JdbcTemplate jdbcTemplete;
    public MySQLKategoriaDao() {
        MysqlDataSource dataSource= new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/todo");
        dataSource.setUser("Todo");
        dataSource.setPassword("ToDo");
        
        jdbcTemplete= new JdbcTemplate(dataSource);
       
        
        
    }
    public List<Kategoria> dajVsetky() {
     String sql="select * from uloha U right outer  join Kategoria K on U.idKat= K.id order by K.id";
     KategoriaRowCallBachHandler krcbh=new KategoriaRowCallBachHandler();
     jdbcTemplete.query(sql,krcbh);
     return krcbh.getKategorie();
    }
    
}
