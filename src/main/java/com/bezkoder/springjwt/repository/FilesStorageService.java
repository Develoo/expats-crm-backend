package com.bezkoder.springjwt.repository;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
	public void init();

	  public void save(MultipartFile file);
	  
	  public void update(MultipartFile file);

	  public Resource load(String filename);

	  public void deleteAll();

	  public Stream<Path> loadAll();
	  public byte[] loadFile(String filename);
	  public Boolean delete(String filename);
	  
	
}
