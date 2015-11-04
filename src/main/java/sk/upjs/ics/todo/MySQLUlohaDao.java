/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.todo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author student
 */
public class MySQLUlohaDao implements UlohaDao{
 private JdbcTemplate jdbcTemplete;
    public MySQLUlohaDao() {
        MysqlDataSource dataSource= new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/todo");
        dataSource.setUser("Todo");
        dataSource.setPassword("ToDo");
        
        jdbcTemplete= new JdbcTemplate(dataSource);
       
        
        
    }

    @Override
    public void pridat(Uloha uloha) {
    String sql = "ĂŹNSERT INTO uloha VALUES(?,?,?,?)";
    jdbcTemplete.update(sql, null,uloha.getNazov(),uloha.getDate(),uloha.isSplnena());
    }

    @Override
    public List<Uloha> dajVsetky() { 
        
        String sql="Select * from uloha";     
        BeanPropertyRowMapper<Uloha> mapper= BeanPropertyRowMapper.newInstance(Uloha.class);     
        return  jdbcTemplete.query(sql,mapper);
       
    }

    @Override
    public void odstranit(Uloha uloha) {
       String sgl = "Delete from uloha where id= ?";
       jdbcTemplete.update(sgl,uloha.getId());
    }
    
    
}
