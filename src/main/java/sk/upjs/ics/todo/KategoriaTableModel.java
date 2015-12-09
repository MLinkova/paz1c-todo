
package sk.upjs.ics.todo;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class KategoriaTableModel extends AbstractTableModel{
    private MySQLKategoriaDao kategoriaDao= new MySQLKategoriaDao();
     private UlohaDao ulohaDao= UlohaDaoFactory.INSTANCE.getUlohaDao();
     List<Kategoria> kategorie= kategoriaDao.dajVsetky();
     private static final int POCET_STLPCOV = 2;
     private static final int STLPEC_POCET_ULOH = 1;
     private static final int STLPEC_NAZOV = 0;
     private static final String [] NAZVY_SPLPCOV={"Vsetky","Nazov","Pocet uloh"};
     private static final int RIADOK_PRE_VSETKY_ULOHY = 1;

     
    public int getRowCount() {
       return kategorie.size()+RIADOK_PRE_VSETKY_ULOHY;
    }
   
    @Override
    public int getColumnCount() {
       return POCET_STLPCOV;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { 
        Kategoria kategoria = null;
        if(rowIndex==0){
             kategoria= new Kategoria();
             kategoria.setNazov("Vsetky");
             kategoria.setUloha(ulohaDao.dajVsetky());
        } else {
         kategoria= kategorie.get(rowIndex-RIADOK_PRE_VSETKY_ULOHY);
        }
         switch(columnIndex){
           case STLPEC_NAZOV: return kategoria.getNazov();
           case STLPEC_POCET_ULOH: return kategoria.getUloha().size();
           default: return "???";
       }
      }
   
    @Override
    public String getColumnName(int column) {
       return NAZVY_SPLPCOV[column];
    }
    
    public Kategoria getKategoria(int index){
        if(index==0){
             Kategoria kategoria= new Kategoria();
             kategoria.setNazov("Vsetky");
             kategoria.setUloha(ulohaDao.dajVsetky());
         return kategoria ;
        }else{
            return kategorie.get(index-RIADOK_PRE_VSETKY_ULOHY);
        }
   }
   
   
   
    
}
