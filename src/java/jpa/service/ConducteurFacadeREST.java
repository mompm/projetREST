/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.service;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.lang.Integer;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Path("jpa.conducteur")
public class ConducteurFacadeREST extends AbstractFacade<Conducteur> {

    @PersistenceContext(unitName = "KlaxitServiceRESTPU")
    private EntityManager em;
    @Inject
    TrajetFacadeREST trajetInject;
    @Inject
    UtilisateurFacadeREST utilisateurInject;
    

    public ConducteurFacadeREST() {
        super(Conducteur.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Conducteur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Conducteur entity) {
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
    public Conducteur find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Conducteur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Conducteur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    @GET
    @Path("meth1")
    @Produces({"application/xml", "application/json"})
    public List<Conducteur> rechercherConducteur(
            @QueryParam("ADRESSERDV") String depart,
            @QueryParam("ADRESSEFIN") String arrivee,
            @QueryParam("JOURS") String jours)
    {
               List<Conducteur> conducteurs =  new ArrayList<>();
               
               for(Trajet trajet : trajetInject.findAll()){
                   if(trajet.getAdressefin().equals(arrivee) 
                           && trajet.getAdresserdv().equals(depart)
                           && trajet.getDaterdv().getDay() == Integer.parseInt(jours)){
                       if(!conducteurs.contains(trajet.getIdconducteur())){
                           conducteurs.add(trajet.getIdconducteur());
                       }
                   }
               }
               return conducteurs;

               
    }
    
    
@POST
@Path("meth2")
@Produces({ "application/xml", "application/json" })
public String créerTrajet(
        @QueryParam("HEURERDV") String heure,
        @QueryParam("ADRESSERDV") String depart, 
        @QueryParam("ADRESSEFIN") String arrivee,
        @QueryParam("DATERDV") String date, 
        @QueryParam("NBPASSAGER") int nbpassager,
        @QueryParam("ACTIVER") boolean activer, 
        @QueryParam("IDCONDUCTEUR") int idconducteur)
        throws ParseException {

    // verifier si utilisateur est conducteur
    boolean isConductor = false;
    for (Conducteur conducteur : findAll()) {
        if (conducteur.getIdutilisateur().getEstconducteur() == true
                && conducteur.getIdconducteur() == idconducteur) {
            isConductor = true;
            break;
        }
    }

    if (!isConductor) {
        return "Utilisateur n'est pas conducteur";
    }

    // verifier si le trajet existe
    for (Trajet trajet : trajetInject.findAll()) {
        if (trajet.getAdresserdv().equals(depart) && trajet.getAdressefin().equals(arrivee)
                && trajet.getNbpassager() == nbpassager && trajet.getActiver() == activer) {
            return "Trajet existe déjà";
        }
    }

    // Creer un trajet
    Trajet newtrajet = new Trajet();
    Date newtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(heure);
    newtrajet.setHeurerdv(newtime);
    Date newdate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date);
    newtrajet.setDaterdv(newdate);
    newtrajet.setAdresserdv(depart);
    newtrajet.setAdressefin(arrivee);
    newtrajet.setNbpassager(nbpassager);
    newtrajet.setActiver(activer);
    newtrajet.setIdconducteur(find(idconducteur));

    trajetInject.create(newtrajet);
    

    return "Trajet ajouté";
}
    
    
    
    
}
    
