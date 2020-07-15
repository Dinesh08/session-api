package com.ge.knowledge.session.manager.impl;

import java.util.List;

import com.ge.knowledge.session.domain.Session;
import com.ge.knowledge.session.model.SessionModel;

public interface ISessionManager {
 SessionModel getSessionById(Long id);
 Session saveSession(SessionModel session);
 void deleteSession(Long id);
 List<SessionModel> getAllSessions();
 Session updateSession(SessionModel session);
/* String saveMultipartFile(Long sessionId,MultipartFile file)throws IOException, SerialException, SQLException ;
 byte[] downloadFile(Long id) throws IOException, SQLException;*/
}
