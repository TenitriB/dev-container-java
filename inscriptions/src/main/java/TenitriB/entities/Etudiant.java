/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package TenitriB.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Etudiant 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    public String nom;
    public String prenom;
    public LocalDate date_naissance;
    public String telephone;

    public void setId (int I)
    {
        this.id=I;
    }
    public int getId()
    {
        return id;
    }

    public void setNom(String N)
    {
        this.nom=N;
    }

    public String getNom()
    {
        return nom;
    }

    public void setPrenom(String P)
    {
        this.prenom=P;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setDate_naissance(LocalDate D)
    {
        this.date_naissance=D;
    }

    public LocalDate getDate_naissance()
    {
        return date_naissance;
    }

    public void setTelephone(String T)
    {
        this.telephone=T;
    }

    public String getTelephone()
    {
        return telephone;
    }

    @Override
    public String toString()
    {
        return this.id+""+this.nom+""+this.prenom+""+this.date_naissance+""+this.telephone;
    }

    private static final String persistenceUnitName="mabase-unit";
    private static EntityManagerFactory factory;

    public static void main( String[] args )
    {
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager em =factory.createEntityManager();

        

        em.getTransaction().begin();
        Etudiant etu = new Etudiant();
        etu.nom = "Ben";
        etu.prenom = "Dupont";
        etu.date_naissance = LocalDate.of(2001, 12, 24);
        etu.telephone = "0596947723";
        em.persist(etu);
        em.getTransaction().commit();

        List<Etudiant> le =em.createQuery("select e from etudiant e", Etudiant.class).getResultList();

        for (Etudiant e  : le)
        {
            System.out.println(e);

        }

        em.close();
    }
}
