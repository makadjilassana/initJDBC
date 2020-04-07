/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisionprga;
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
    
    public Etudiant(int cne) {
        this.cne = cne;
    }

    public Etudiant(String nom) {
        this.nom = nom;
    }
    
    

    public Etudiant(int cne, String nom, String prenom, String filiere) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
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
    
}
