/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import revisionprga.Etudiant;

/**
 *
 * @author Makadji
 */
public class EtudiantService {
    
    public Connection ConnectionBD() throws SQLException{
        
          Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1/etudiant?serverTimezone=UTC","root","");
          System.out.println("Connection BD reussie !");
          return con;
      
    }
    
    public void InsererDB() throws SQLException{
       Connection con= ConnectionBD(); 
       PreparedStatement ps= con.prepareStatement("INSERT INTO Etudiant VALUES (?,?,?,?)");
       Etudiant etudiant= new Etudiant();
       etudiant.setCne(6476);
       etudiant.setNom("Camer");
       etudiant.setPrenom("Koudous");
       etudiant.setFiliere("Miage");
       ps.setInt(1,etudiant.getCne());
       ps.setString(2,etudiant.getNom());
       ps.setString(3,etudiant.getPrenom());
       ps.setString(4,etudiant.getFiliere());
       ps.executeUpdate();
    }
    
    public void ModifierDB() throws SQLException{
       Connection con= ConnectionBD(); 
       PreparedStatement ps= con.prepareStatement("UPDATE Etudiant SET filiere=? WHERE filiere=?");
       Etudiant etudiant= new Etudiant();
       etudiant.setFiliere("Management");
       ps.setString(1,etudiant.getFiliere());
       ps.setString(2,"Miashs");
       ps.executeUpdate();
    }
    
    public void SupprimerDB() throws SQLException{
    Connection con= ConnectionBD();
    PreparedStatement ps= con.prepareStatement("DELETE FROM ETUDIANT WHERE filiere=?");
    Etudiant etudiant= new Etudiant();
    etudiant.setFiliere("Miage");
    ps.setString(1,etudiant.getFiliere());
    ps.executeUpdate();
 }
    
    
    
}
