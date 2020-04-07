/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public void InsererDB(Etudiant etudiant) throws SQLException{
       Connection con= ConnectionBD(); 
       PreparedStatement ps= con.prepareStatement("INSERT INTO Etudiant VALUES (?,?,?,?)");
     
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
    
    public Etudiant find(int cne) throws SQLException{
        Connection con= ConnectionBD();
        PreparedStatement ps= con.prepareStatement("SELECT * FROM ETUDIANT WHERE filiere=?");
        ps.setInt(1, cne);
        ResultSet rs= ps.executeQuery();
        Etudiant etudiant= new Etudiant(rs.getInt("cne"));
        return etudiant;
    }
    
    public List<Etudiant> findAll() throws SQLException{
        List<Etudiant> liste= new ArrayList<>();
        Connection con= ConnectionBD();
        PreparedStatement ps= con.prepareStatement("SELECT * FROM ETUDIANT");
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            Etudiant etudiant= new Etudiant(rs.getInt("cne"),rs.getString("nom"),rs.getString("prenom"),rs.getString("filiere"));
            liste.add(etudiant);
        }
        
        return liste;
    }
    
    public List<Etudiant> choisirFiliere() throws SQLException{
        List<Etudiant> liste= new ArrayList<>();
        Connection con= ConnectionBD();
        PreparedStatement ps= con.prepareStatement("SELECT DISTINCT filiere FROM ETUDIANT");
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            Etudiant etudiant= new Etudiant(rs.getString("filiere"));
            liste.add(etudiant);
        }
        return liste;
    }
    
    
}
