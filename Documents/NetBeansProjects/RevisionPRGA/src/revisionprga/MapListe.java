/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Makadji
 */
public class MapListe {
    private Map<Integer,String> tables;
    private List<String> liste;

    public MapListe() {
       tables= new HashMap<>();
       liste= new ArrayList<>();
    }

    public Map<Integer, String> getTables() {
        return tables;
    }

    public void setTables(Map<Integer, String> tables) {
        this.tables = tables;
    }

    public List<String> getListe() {
        return liste;
    }

    public void setListe(List<String> liste) {
        this.liste = liste;
    }
    
    public void testMapListe(Map<Integer,String> map){
        
         
       tables.put(1,"100");
       tables.put(2,"200");
       tables.put(3,"300");
       tables.put(4,"400");
       
       Boolean existekey= tables.containsKey(7);
       Boolean existevalue= tables.containsValue("voiture");
       System.out.println("existeKey: "+existekey);
       System.out.println("existeValue: "+existevalue);
       String v= tables.get(1);
       System.out.println(""+v);       
       
       
       for(String auto: tables.values()){
            liste.add(auto);
       }
       
       for(String element:  liste){
           System.out.println("auto: "+element);
       }
       Boolean existe=  liste.contains("100");
       System.out.println("existe: "+existe);
       
       
       Iterator<String> it=  liste.iterator();
       while(it.hasNext()){
           it.next();
       }
       
        assert it.equals(400) : "Problème il doit afficher le dernier elelment qui est 400!";
        assert  tables.size()== liste.size(): "Problème la taille de la liste est différente à celle de la table !";
        System.out.println("taille: "+ tables.size());
        
        tables.clear();
        System.out.println("taille: "+ tables.size());
        
    }
    
}
