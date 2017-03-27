/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Friendship;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author xuanzhang
 */
@Stateless
@Path("entities.friendship")
public class FriendshipFacadeREST extends AbstractFacade<Friendship> {

    @PersistenceContext(unitName = "MonashFriendFinderPU")
    private EntityManager em;

    public FriendshipFacadeREST() {
        super(Friendship.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Friendship entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Friendship entity) {
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
    public Friendship find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("findByStudOneID/{studentOneId}")
    @Produces({"application/json"})
    public List<Friendship> findByStudOneID(@PathParam("studentOneId") Integer studentOneId) {
        Query query = em.createNamedQuery("Friendship.findByStudOneId");
        query.setParameter("studentOneId", studentOneId);
        return query.getResultList();
    }

    @GET
    @Path("findByStudTwoID/{studentTwoId}")
    @Produces({"application/json"})
    public List<Friendship> findByStudTwoID(@PathParam("studentTwoId") Integer studentTwoId) {
        Query query = em.createNamedQuery("Friendship.findByStudTwoID");
        query.setParameter("studentTwoId", studentTwoId);
        return query.getResultList();
    }

    @GET
    @Path("findByStartingDate/{startingDate}")
    @Produces({"application/json"})
    public List<Friendship> findByStartingDate(@PathParam("startingDate") String startingDate) {
        Query query = em.createNamedQuery("Friendship.findByStartingDate");
        query.setParameter("startingDate", startingDate);
        return query.getResultList();
    }

    @GET
    @Path("findByEndingDate/{endingDate}")
    @Produces({"application/json"})
    public List<Friendship> findByEndingDate(@PathParam("endingDate") String endingDate) {
        Query query = em.createNamedQuery("Friendship.findByEndingDate");
        query.setParameter("endingDate", endingDate);
        return query.getResultList();
    }
    
    @GET
    @Path("findByStudFullName/{firstName}/{lastName}")
    @Produces({"application/json"})
    public List<Friendship> findByStudFullName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        Query query = em.createNamedQuery("Friendship.findByStudFullName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        System.out.println(firstName + " " + lastName);
        return query.getResultList();
    }

    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
