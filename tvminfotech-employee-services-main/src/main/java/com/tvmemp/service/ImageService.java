package com.tvmemp.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tvmemp.model.EmployeeImage;
import com.tvmemp.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	
	
	public String saveEmployeeImage(MultipartFile file,Integer employeeId) throws IOException {
		EmployeeImage employeeImage = new EmployeeImage();
		employeeImage.setEmployeeId(employeeId);
		employeeImage.setPhoto(file.getBytes());
		imageRepository.save(employeeImage);
		return "saved Successfully";
	}



	public Optional<EmployeeImage> getInfoImage(Integer id) {
		return imageRepository.findById(id);
	}



	public List<Map<String, Object>> getAllImageEmployee(Integer id) {
		return imageRepository.getEmployeeWithImageDetails(id);
	}
	
	
	
	

	
}
