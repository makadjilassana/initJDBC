/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga;
import java.sql.SQLException;


 
/**
 *
 * @author Makadji
 */
public class Main { 
   
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MapListe map= new MapListe();
       map.testMapListe(map.getTables());
       Etudiant etudiant= new Etudiant();
      
       try{
        etudiant.InsererDB();
        //etudiant.ModifierDB();
        //etudiant.SupprimerDB();
    } catch(SQLException e){
          e.printStackTrace();
    }
       
  }
    
}
