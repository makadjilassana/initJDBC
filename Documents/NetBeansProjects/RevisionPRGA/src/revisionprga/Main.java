/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga;
import java.sql.SQLException;
import java.util.List;
import revisionprga.service.EtudiantService;


 
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
       EtudiantService etudiant= new EtudiantService();
      
       try{
        //etudiant.SupprimerDB(2331);
        //etudiant.InsererDB();
        //etudiant.ModifierDB();
        //etudiant.find(5302);
        List<Etudiant> liste= etudiant.findAll();
        
        for(Etudiant etu: liste){
        System.out.println(""+etu.getNom());    
        }
        
        
    } catch(SQLException e){
          e.printStackTrace();
    }
       
  }
    
}
