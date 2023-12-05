/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import jpa.Conducteur;
import jpa.Trajet;
import jpa.Utilisateur;

/**
 *
 * @author Windows7
 */
@Stateless
@Path("jpa.utilisateur")
public class UtilisateurFacadeREST extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "KlaxitServiceRESTPU")
    private EntityManager em;

    public UtilisateurFacadeREST() {
        super(Utilisateur.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Utilisateur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Utilisateur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Utilisateur find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utilisateur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
 @POST
@Path("meth3")
@Produces({ "application/xml", "application/json" })
public String créerTrajet(
        @QueryParam("NOM") String nom,
        @QueryParam("PRENOM") String prenom, 
        @QueryParam("DATEDENAISSANCE") String date,
        @QueryParam("EMAIL") String email, 
        @QueryParam("MOBILE") String mobile,
        @QueryParam("ESTCONDUCTEUR") boolean estconducteur) 
        throws ParseException {

    //verifier si utilisateur existe 
    for (Utilisateur utilisateurs : findAll()){
        if(utilisateurs.getNom().equals(nom)
                && utilisateurs.getPrenom().equals(prenom)
                && utilisateurs.getEmail().equals(email)){
            return "utilisateur existe deja";
        }
    }
    // Creer un utilisateur
    
    Utilisateur newUtilisateur =  new Utilisateur();
    newUtilisateur.setNom(nom);
    newUtilisateur.setPrenom(prenom);
    Date newdate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date);
    newUtilisateur.setDatenaissance(newdate);
    newUtilisateur.setEmail(email);
    newUtilisateur.setMobile(mobile);
    newUtilisateur.setEstconducteur(estconducteur);

 

    return "Utilisateur ajouté";
}
    
}
