/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
@Path("entities.profile")
public class ProfileFacadeREST extends AbstractFacade<Profile> {

    @PersistenceContext(unitName = "MonashFriendFinderPU")
    private EntityManager em;

    public ProfileFacadeREST() {
        super(Profile.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Profile entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Profile entity) {
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
    public Profile find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @Path("findByFirstName/{firstName}")
    @Produces({"application/json"})
    public List<Profile> findByFirstName(@PathParam("firstName") String firstName) {
        Query query = em.createNamedQuery("Profile.findByFirstName");
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }

    @GET
    @Path("findByLastName/{lastName}")
    @Produces({"application/json"})
    public List<Profile> findByLastName(@PathParam("lastName") String lastName) {
        Query query = em.createNamedQuery("Profile.findByLastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @GET
    @Path("findByDateOfBirth/{dateOfBirth}")
    @Produces({"application/json"})
    public List<Profile> findByDateOfBirth(@PathParam("dateOfBirth") String dateOfBirth) {
        Query query = em.createNamedQuery("Profile.findByDateOfBirth");
        query.setParameter("dateOfBirth", dateOfBirth);
        return query.getResultList();
    }

    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<Profile> findByGender(@PathParam("gender") String gender) {
        Query query = em.createNamedQuery("Profile.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }

    @GET
    @Path("findByCourse/{course}")
    @Produces({"application/json"})
    public List<Profile> findByCourse(@PathParam("course") String course) {
        Query query = em.createNamedQuery("Profile.findByCourse");
        query.setParameter("course", course);
        return query.getResultList();
    }

    @GET
    @Path("findByStudyMode/{studyMode}")
    @Produces({"application/json"})
    public List<Profile> findByStudyMode(@PathParam("studyMode") String studyMode) {
        Query query = em.createNamedQuery("Profile.findByStudyMode");
        query.setParameter("studyMode", studyMode);
        return query.getResultList();
    }

    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Profile> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Profile.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }

    @GET
    @Path("findBySuburb/{suburb}")
    @Produces({"application/json"})
    public List<Profile> findBySuburb(@PathParam("suburb") String suburb) {
        Query query = em.createNamedQuery("Profile.findBySuburb");
        query.setParameter("suburb", suburb);
        return query.getResultList();
    }

    @GET
    @Path("findByNationality/{nationality}")
    @Produces({"application/json"})
    public List<Profile> findByNationality(@PathParam("nationality") String nationality) {
        Query query = em.createNamedQuery("Profile.findByNationality");
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }

    @GET
    @Path("findByNativeLanguage/{nativeLanguage}")
    @Produces({"application/json"})
    public List<Profile> findByNativeLanguage(@PathParam("nativeLanguage") String nativeLanguage) {
        Query query = em.createNamedQuery("Profile.findByNativeLanguage");
        query.setParameter("nativeLanguage", nativeLanguage);
        return query.getResultList();
    }

    @GET
    @Path("findByFavouriteSport/{favouriteSport}")
    @Produces({"application/json"})
    public List<Profile> findByFavouriteSport(@PathParam("favouriteSport") String favouriteSport) {
        Query query = em.createNamedQuery("Profile.findByFavouriteSport");
        query.setParameter("favouriteSport", favouriteSport);
        return query.getResultList();
    }

    @GET
    @Path("findByFavouriteMovie/{favouriteMovie}")
    @Produces({"application/json"})
    public List<Profile> findByFavouriteMovie(@PathParam("favouriteMovie") String favouriteMovie) {
        Query query = em.createNamedQuery("Profile.findByFavouriteMovie");
        query.setParameter("favouriteMovie", favouriteMovie);
        return query.getResultList();
    }

    @GET
    @Path("findByFavouriteUnit/{favouriteUnit}")
    @Produces({"application/json"})
    public List<Profile> findByFavouriteUnit(@PathParam("favouriteUnit") String favouriteUnit) {
        Query query = em.createNamedQuery("Profile.findByFavouriteUnit");
        query.setParameter("favouriteUnit", favouriteUnit);
        return query.getResultList();
    }

    @GET
    @Path("findByCurrentJob/{currentJob}")
    @Produces({"application/json"})
    public List<Profile> findByCurrentJob(@PathParam("currentJob") String currentJob) {
        Query query = em.createNamedQuery("Profile.findByCurrentJob");
        query.setParameter("currentJob", currentJob);
        return query.getResultList();
    }

    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<Profile> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("Profile.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }

    @GET
    @Path("findBySubscriptionDatetime/{subscriptionDatetime}")
    @Produces({"application/json"})
    public List<Profile> findBySubscriptionDatetime(@PathParam("subscriptionDatetime") String subscriptionDatetime) {
        Query query = em.createNamedQuery("Profile.findBySubscriptionDatetime");
        query.setParameter("subscriptionDatetime", subscriptionDatetime);
        return query.getResultList();
    }

    @GET
    @Path("findByFirstNameAndLastName/{firstName}/{lastName}")
    @Produces({"application/json"})
    public List<Profile> findByFirstNameAndLastName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){
        TypedQuery<Profile> query =  em.createQuery("SELECT p FROM Profile p WHERE p.firstName = :firstName AND p.lastName = :lastName", Profile.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profile> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
