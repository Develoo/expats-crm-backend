package com.bezkoder.springjwt.repository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FilesStorageServiceImpl implements FilesStorageService{
	// private final Path root = Paths.get("/home/prod1/uploads");
	   private final Path root = Paths.get("uploads");

	@Override
	public void init() {
		   try {
			      Files.createDirectory(root);
			    } catch (IOException e) {
			      throw new RuntimeException("Could not initialize folder for upload!");
			    }
		
	}

	@Override
	public void save(MultipartFile file) {
		  try {
		      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		
	}

	@Override
	public void update(MultipartFile file) {
		  try {
		      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		
	}

	@Override
	public Resource load(String filename) {
		 try {
		      Path file = root.resolve(filename);
		      Resource resource = new UrlResource(file.toUri());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
		
	}

	@Override
	public Stream<Path> loadAll() {
		  try {
		      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not load the files!");
		    }
	}

	@Override
	public byte[] loadFile(String filename) {
		byte[] bytes = new byte[0];
		 try {
		Path file = root.resolve(filename);
		bytes = Files.readAllBytes(file);
		return bytes;
	}catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
		 return bytes;
	
	}

	@Override
	public Boolean delete(String filename) {
		
		FileSystemUtils.deleteRecursively(root.toFile());
	      return true;
	}
	 public String storeFile(MultipartFile file) throws IOException {
	        String fileName = file.getOriginalFilename();
	        if (fileName == null || fileName.isEmpty()) {
	            throw new IOException("Le fichier est vide ou le nom de fichier est introuvable.");
	        }

	        Path targetLocation = root.resolve(fileName);
	        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

	        return targetLocation.toString(); // Retourner l'emplacement où l'image a été stockée
	    }
	 private void createStorageDirectory() throws IOException {
	        if (!Files.exists(root)) {
	            Files.createDirectories(root);
	        }
	    }
	 
}