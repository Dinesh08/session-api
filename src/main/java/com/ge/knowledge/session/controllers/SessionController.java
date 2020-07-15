package com.ge.knowledge.session.controllers;


import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ge.knowledge.session.domain.Session;
import com.ge.knowledge.session.manager.impl.ISessionManager;
import com.ge.knowledge.session.model.SessionModel;

@RestController
@RequestMapping("/session")
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);
    @Autowired
    ISessionManager sessionManager;

    @ApiOperation(value = "get knowledge sahring session details by id", response = ResponseEntity.class)
    @RequestMapping(value = "session/{id}", method = RequestMethod.GET)
    public ResponseEntity<SessionModel> getSessionById(@PathVariable("id") Long id) {
    	return new ResponseEntity<>(
    			sessionManager.getSessionById(id), HttpStatus.OK);
    }
    @ApiOperation(value = "get all knowledge sahring session details ", response = ResponseEntity.class)
    @RequestMapping(value = "sessions", method = RequestMethod.GET)
    public ResponseEntity<List<SessionModel>> getAllSessions() {
    	return new ResponseEntity<>(
    			sessionManager.getAllSessions(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "save session details", response = ResponseEntity.class)
    @RequestMapping(value = "sessions", method = RequestMethod.POST)
    public ResponseEntity<Session> saveSession(@RequestBody SessionModel session) {
    	return new ResponseEntity<>(
    			sessionManager.saveSession(session), HttpStatus.CREATED);
    }
    
    @ApiOperation(value = "delete session details", response = ResponseEntity.class)
    @RequestMapping(value = "sessions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSessionById(@PathVariable("id") Long id) {
    	sessionManager.deleteSession(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "update session details by ID", response = ResponseEntity.class)
    @RequestMapping(value = "sessions/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Session> updateSession(@RequestBody SessionModel session){
    	return new ResponseEntity<>(sessionManager.updateSession(session),HttpStatus.ACCEPTED);
    }
/*    @ApiOperation(value = "upload test", response = ResponseEntity.class)
    @RequestMapping(value = "upload/{sessionId}", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<String> upload(@PathVariable("sessionId") Long sessionId,@RequestParam("file") MultipartFile file) throws IOException, SerialException, SQLException{

        if (file == null || file.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        LOGGER.info("file name: {}", file.getName());
        LOGGER.info("file original name: {}", file.getOriginalFilename());
        LOGGER.info("file size: {}", file.getSize());

        return new ResponseEntity<>(sessionManager.saveMultipartFile(sessionId,file),HttpStatus.OK);
    }
    
    @ApiOperation(value = "Session file Download", response = ResponseEntity.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> generateCostSummaryReport(@RequestParam(value = "id") Long id) throws IOException, SQLException {
    	 HttpHeaders responseHeaders = new HttpHeaders();
    	    responseHeaders.add("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .headers(responseHeaders)
                .body(new InputStreamResource(new ByteArrayInputStream(sessionManager.downloadFile(id))));
    }*/
}
