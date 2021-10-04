package com.lt.rest;

 

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.constants.Role;
import com.lt.exception.UserNotFoundException;
/*
 * @author G4-FullStackGroup
 * Annotation for permitting cross-origin requests on specific handler
 * classesand/or handler methods. Processed if an appropriate HandlerMappingis configured.
 */
@CrossOrigin
/*
 * A convenience annotation that is itself annotated with @Controller and @ResponseBody.
 */
@RestController
/*
 * Annotation for mapping web requests onto methods in request-handling User classes with
 * flexible method signatures.
 */
@RequestMapping("/User")

 

/**
 * Class that display UserRestApi Menu
 */
public class UserRestApi {
    /*
     * This is the central class in the log4j package. Most loggingoperations,
     * except configuration, are done through this class
     */
    private static Logger logger = Logger.getLogger(UserRestApi.class);
    /*
     * Interface for userInterface Operations
     */
    UserInterface userInterface= UserImplService.getInstance();

 

    /*
     * Marks a constructor, field, setter method, or config method as to be
     * autowired bySpring's dependency injection facilities. This is an alternative
     * to the JSR-330 javax.inject.Inject annotation, adding required-vs-optional semantics.
     */
    @Autowired
    StudentInterface studentInterface;

 

    /**
     * A Method declaration for update Password
     * @param userId: email address of the user
     * @param newPassword: new password to be stored in db.
     * @return 201, if password is updated, else 500 in case of error
     */
    @RequestMapping(value = "/updatePassword/{username}/{password}", method = RequestMethod.PUT)
    /*
     * Marks a method or exception class with the status code and reason that should be returned.
     */

    /*
     * Supported for annotated handler methods.
     */
    public Response passwordUpdate(@PathVariable String username,@PathVariable String password ){
        if(userInterface.updatePassword(username, password)) { // Method to get Username
            return Response.status(201).entity("Password updated successfully! ").build();
        }
        else {
            return Response.status(500).entity("Something went wrong, please try again!").build();
        }
    }

 

    /*
     * The status code is applied to the HTTP response when the handlermethod is invoked
     * and overrides status information set by other means,like ResponseEntity or "redirect:".
     * Marks a method or exception class with the status code and reason that should be returned.
     */
    //    @ResponseStatus(HttpStatus.NOT_FOUND)
    /*
     * A method declaration for login
     * Supported for annotated handler methods.
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) throws Exception
    {
        boolean isloggedin=userInterface.login(user.getUsername(),user.getPassword());
        if (isloggedin) {
            int roleId = userInterface.getRole(user.getUsername());	
            Role userRole = Role.stringToName(roleId);
            logger.info("Login successful "+user.getUsername());
            return new ResponseEntity(userRole.toString(), HttpStatus.OK);
        } else {
            logger.info("Something Went Wrong!!!");
            throw new UserNotFoundException(user.getUsername());
        }        
    }

 

    /**
     * A method declaration for studentRegistration
     * @param student
     * @return 201, if user is created, else 500 in case of error
     */
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/studentRegistration")
    public ResponseEntity singup(@RequestBody Student student) throws Exception{
     
            if(studentInterface.signup(student.getStudentName(), student.getPassword(), student.getStudentContactNo(),
                    student.getStudentEmailId(), student.getStudentAddress(), student.getBranch())) {
            	
            return new ResponseEntity<>("Student course registration is Sucessfull.", HttpStatus.OK);
            }
            else {
            	throw new Exception();
            }   
    }

 

    /**
     * A method declaration for getRole
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/getRole/{username}", method = RequestMethod.GET)
    public int getRole(@PathVariable String username ) throws Exception{
        return userInterface.getRole(username);
    }

 

}