/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Makadji
 */
public class Etudiant {
    private int cne;
    private String nom;
    private String prenom;
    private String filiere;

    public Etudiant() {
    }

    public int getCne() {
        return cne;
    }

    public void setCne(int cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.cne;
        hash = 47 * hash + Objects.hashCode(this.nom);
        hash = 47 * hash + Objects.hashCode(this.prenom);
        hash = 47 * hash + Objects.hashCode(this.filiere);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etudiant other = (Etudiant) obj;
        if (this.cne != other.cne) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.filiere, other.filiere)) {
            return false;
        }
        return true;
    }
    
    public Connection ConnectionBD() throws SQLException{
        
          Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1/etudiant?serverTimezone=UTC","root","");
          System.out.println("Connection BD reussie !");
          return con;
      
    }
    
    public void InsererDB() throws SQLException{
       Connection con= ConnectionBD(); 
       PreparedStatement ps= con.prepareStatement("INSERT INTO Etudiant VALUES (?,?,?,?)");
       setCne(6476);
       setNom("Camer");
       setPrenom("Koudous");
       setFiliere("Miage");
       ps.setInt(1,getCne());
       ps.setString(2,getNom());
       ps.setString(3,getPrenom());
       ps.setString(4,getFiliere());
       ps.executeUpdate();
    }
    
    public void ModifierDB() throws SQLException{
       Connection con= ConnectionBD(); 
       PreparedStatement ps= con.prepareStatement("UPDATE Etudiant SET filiere=? WHERE filiere=?");
       setFiliere("Management");
       ps.setString(1,getFiliere());
       ps.setString(2,"Miashs");
       ps.executeUpdate();
    }
    
    public void SupprimerDB() throws SQLException{
    Connection con= ConnectionBD();
    PreparedStatement ps= con.prepareStatement("DELETE FROM ETUDIANT WHERE filiere=?");
    setFiliere("Miage");
    ps.setString(1,getFiliere());
    ps.executeUpdate();
 }
    
    
    
}
