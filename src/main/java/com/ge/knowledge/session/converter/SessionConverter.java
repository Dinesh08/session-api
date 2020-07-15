package com.ge.knowledge.session.converter;

import java.util.ArrayList;
import java.util.List;

import com.ge.knowledge.session.domain.Session;
import com.ge.knowledge.session.model.SessionModel;

public final class SessionConverter {
	 private SessionConverter() {
	        // private constructor
	    }
	    public static Session convertModelToDomain(
	            SessionModel model) {
	    	Session session = new Session();
	    	session.setAccount(model.getAccount());
	    	session.setAuthor(model.getAuthor());
	    	session.setTopicName(model.getTopicName());
	    	session.setStatus(model.getStatus());
	    	session.setTentativeDates(model.getTentativeDates());
	    	session.setReferenceUrl(model.getReferenceUrl());
	    	if(model.getId()!=null && model.getId()!=0){
	    	session.setId(model.getId());
	    	}

	        return session;
	    }
	    
	    public static SessionModel convertDomainToModel(
	            Session session) {
	    	SessionModel model = new SessionModel();
	    	model.setAccount(session.getAccount());
	    	model.setTopicName(session.getTopicName());
	    	model.setAuthor(session.getAuthor());
	    	model.setStatus(session.getStatus());
	    	model.setTentativeDates(session.getTentativeDates());
	    	model.setId(session.getId());
	    	model.setReferenceUrl(session.getReferenceUrl());
	        return model;
	    }
	    public static List<SessionModel> convertDomainToModelList(
	            List<Session> sessionList) {
	    	List<SessionModel> modelList = new ArrayList<>();
	    	sessionList.forEach(session->{
	    	SessionModel model = new SessionModel();
	    	model.setAccount(session.getAccount());
	    	model.setTopicName(session.getTopicName());
	    	model.setAuthor(session.getAuthor());
	    	model.setStatus(session.getStatus());
	    	model.setTentativeDates(session.getTentativeDates());
	    	model.setReferenceUrl(session.getReferenceUrl());
	    	model.setId(session.getId());
	    	modelList.add(model);
	    	});
	        return modelList;
	    }
}
