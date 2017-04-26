/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Location;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
@Path("entities.location")
public class LocationFacadeREST extends AbstractFacade<Location> {

    @PersistenceContext(unitName = "MonashFriendFinderPU")
    private EntityManager em;

    public LocationFacadeREST() {
        super(Location.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Location entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Location entity) {
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
    public Location find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByStudentId/{studentId}")
    @Produces({"application/json"})
    public List<Location> findByStudentId(@PathParam("studentId") Integer studentId) {
        Query query = em.createNamedQuery("Location.findByStudentId");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByLocationName/{locationName}")
    @Produces({"application/json"})
    public List<Location> findByLocationName(@PathParam("locationName") String locationName) {
        Query query = em.createNamedQuery("Location.findByLocationName");
        query.setParameter("locationName", locationName);
        return query.getResultList();
    }

    @GET
    @Path("findByLatitude/{latitude}")
    @Produces({"application/json"})
    public List<Location> findByLatitude(@PathParam("latitude") String latitude) {
        Query query = em.createNamedQuery("Location.findByLatitude");
        query.setParameter("latitude", latitude);
        return query.getResultList();
    }

    @GET
    @Path("findByLongitude/{longitude}")
    @Produces({"application/json"})
    public List<Location> findByLongitude(@PathParam("longitude") String longitude) {
        Query query = em.createNamedQuery("Location.findByLongitude");
        query.setParameter("longitude", longitude);
        return query.getResultList();
    }

    @GET
    @Path("findByDateTime/{dateTime}")
    @Produces({"application/json"})
    public List<Location> findByDateTime(@PathParam("dateTime") String dateTime) {
        Query query = em.createNamedQuery("Location.findByDateTime");
        query.setParameter("dateTime", dateTime);
        return query.getResultList();
    }

    @GET
    @Path("findByLocationNameAndStudentFullName/{locationName}/{firstName}/{lastName}")
    @Produces({"application/json"})
    public List<Location> findByLocationNameAndStudentFullName(@PathParam("locationName") String locationName, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l WHERE l.studentId.firstName = :firstName AND l.studentId.lastName = :lastName AND l.locationName = :locationName", Location.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("locationName", locationName);
        return query.getResultList();
    }
    
    @GET
    @Path("findLocationsByStudIdAndDatetime/{studentId}/{startingDate}/{endingDate}")
    @Produces({"application/json"})
    public JsonArray findLocationsByStudIdAndDatetime(@PathParam("studentId") Integer studentId, @PathParam("startingDate") String startingDate, @PathParam("endingDate") String endingDate) {
        Query query = em.createQuery("SELECT l.locationName, count(l) AS frequency FROM Location l WHERE l.studentId.studentId = :studentId AND l.dateTime >= :startingDate AND l.dateTime <= :endingDate GROUP BY l.locationName");
        query.setParameter("studentId", studentId);
        query.setParameter("startingDate", startingDate);
        query.setParameter("endingDate", endingDate);
        List resultList = query.getResultList();
        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object line : resultList) {
            Object[] list = (Object[]) line;
            JsonObject value = Json.createObjectBuilder()
                    .add("locationName", list[0].toString())
                    .add("frequency", list[1].toString())
                    .build();
            arrayBuilder = arrayBuilder.add(value);
        }
        JsonArray array = arrayBuilder.build();
        return array;
    }
    
    @GET
    @Path("findNearStuents/{studentId}/{latitude}/{longitude}")
    @Produces({"application/json"})
    public JsonArray findNearStuents(@PathParam("studentId") Integer studentId, @PathParam("latitude") float latitude, @PathParam("longitude") float longitude) {
        //distance calculation sql
        String distanceFunc = "6371.004 * FUNC('acos', FUNC('cos', FUNC('radians', l1.latitude)) * FUNC('cos', FUNC('radians', :latitude)) * FUNC('cos', FUNC('radians', l1.longitude - :longitude)) + FUNC('sin', FUNC('radians', l1.latitude)) * FUNC('sin', FUNC('radians', :latitude)))";
        Query query = em.createQuery("SELECT " + distanceFunc + " AS distance, l1.latitude, l1.longitude, l1.studentId.firstName, l1.studentId.lastName FROM Location l1 WHERE l1.dateTime = (SELECT MAX(l2.dateTime) FROM Location l2 WHERE l1.studentId.studentId = l2.studentId.studentId GROUP BY l2.studentId.studentId) AND l1.studentId.studentId != :studentId ORDER BY distance");
        query.setParameter("studentId", studentId);
        query.setParameter("latitude", latitude);
        query.setParameter("longitude", longitude);
        query.setMaxResults(10); //set the max results
        List resultList = query.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object entry : resultList) {
            Object[] attributes = (Object[]) entry;
            JsonObject value = Json.createObjectBuilder()
                    .add("firstName", attributes[3].toString())
                    .add("lastName", attributes[4].toString())
                    .add("latitude", attributes[1].toString())
                    .add("longitude", attributes[2].toString())
                    .add("distanceNearUser", attributes[0].toString())
                    .build();
            arrayBuilder = arrayBuilder.add(value);
        }
        JsonArray array = arrayBuilder.build();
        
        return array;
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
