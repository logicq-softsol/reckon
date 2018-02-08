package com.logicq.reckon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.AdvConfig;
import com.logicq.reckon.model.GlobalDirectory;
import com.logicq.reckon.repository.AdvConfigRepository;
import com.logicq.reckon.repository.GlobalDirectoryRepository;

@Service
public class AdvConfigServiceImpl {

	@Autowired
	AdvConfigRepository advConfigRepository;

	@Autowired
	GlobalDirectoryRepository globalDirectoryRepo;

	@Transactional
	public List<AdvConfig> getAllAdvConfig() {
		return advConfigRepository.findAll();
	}

	@Transactional
	public List<AdvConfig> saveAdvConfig(AdvConfig advconfig) {
		GlobalDirectory globalDirec = globalDirectoryRepo.getOne("ADVERTISEMENT");
		advconfig.setFilepath(globalDirec.getFilePath() + advconfig.getFilename());
		advConfigRepository.save(advconfig);
		return advConfigRepository.findAll();
	}

	@Transactional
	public List<AdvConfig> deleteAdvConfig(AdvConfig advconfig) {
		advConfigRepository.delete(advconfig);
		return advConfigRepository.findAll();
	}

}
