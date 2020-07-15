package com.ge.knowledge.session.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.knowledge.session.converter.SessionConverter;
import com.ge.knowledge.session.domain.Session;
import com.ge.knowledge.session.model.SessionModel;
import com.ge.knowledge.session.ras.postgres.SessionRepository;

@Service
public class SessionManager implements ISessionManager{
	@Autowired
	SessionRepository sessionRepo;
	
	@Override
	public SessionModel getSessionById(Long id) {
		return SessionConverter.convertDomainToModel(sessionRepo.findById(id));
	}

	@Override
	public Session saveSession(SessionModel model) {
		return sessionRepo.saveAndFlush(SessionConverter.convertModelToDomain(model));
	}

	@Override
	public void deleteSession(Long id) {
		try{
			sessionRepo.delete(id);
			//return "deleted Successfully";
		}catch(Exception e){
			//return "Error occured in deleting session having id "+id;
			System.out.println(e);
		}
	}

	@Override
	public List<SessionModel> getAllSessions() {
		return SessionConverter.convertDomainToModelList(sessionRepo.findAll());
	}

	@Override
	public Session updateSession(SessionModel session) {

		 SessionModel modelToUpdate= SessionConverter.convertDomainToModel(sessionRepo.getOne(session.getId()));
		 modelToUpdate.setAccount(session.getAccount());
		 modelToUpdate.setAuthor(session.getAuthor());
		 modelToUpdate.setReferenceUrl(session.getReferenceUrl());
		 modelToUpdate.setStatus(session.getStatus());
		 modelToUpdate.setTentativeDates(session.getTentativeDates());
		 modelToUpdate.setTopicName(session.getTopicName());
		 return sessionRepo.saveAndFlush(SessionConverter.convertModelToDomain(modelToUpdate));
	}

	
/*	@Override
	public String saveMultipartFile(Long sessionId,MultipartFile multiFile) throws IOException, SerialException, SQLException {
		BlobEntity blob = new BlobEntity();
		blob.setFileName(multiFile.getOriginalFilename());
		blob.setType(multiFile.getContentType());
		byte[] arrayPic = new byte[(int) multiFile.getSize()];
		multiFile.getInputStream().read(arrayPic);
		//Byte blobdata = new SerialBlob(StreamUtils.copyToByteArray(multiFile.getInputStream()));
		blob.setData(arrayPic);
		blob = blobRepo.saveAndFlush(blob);
		Session session = sessionRepo.findById(sessionId);
		if(session!=null){
			session.setBlobEntity(blob);
		}
		sessionRepo.save(session);
		return multiFile.getOriginalFilename()+" file saved successfully with id "+blob.getId();
	}

	@Override
	public byte[] downloadFile(Long id) throws IOException, SQLException {
		BlobEntity blob = blobRepo.findById(id);
		if(blob!=null){
		    File pdf = new File(FilenameUtils.getName(blob.getFileName()));
		    FileOutputStream  fos = new FileOutputStream(pdf);
		    fos.write(blob.getData());
            return FileUtils.readFileToByteArray(pdf);
		}
		return null;
	}*/
	
	 
}
