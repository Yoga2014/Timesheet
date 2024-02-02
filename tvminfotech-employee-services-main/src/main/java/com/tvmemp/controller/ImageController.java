package com.tvmemp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tvmemp.model.EmployeeImage;
import com.tvmemp.service.ImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/tvm")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping("/sendImage")
	public String sendEmployeeImage(@RequestParam("file") MultipartFile file,
			@RequestParam("employeeId") Integer employeeId) throws IOException {
		
		return imageService.saveEmployeeImage(file,employeeId); 
	}
	
	@GetMapping("/getEmpImageId/{imageid}")
	public Optional<EmployeeImage> getMethodName(@PathVariable("imageid") Integer id) {
		
		return imageService.getInfoImage(id);
	}
	
	@GetMapping("/getByEmployeeIdwithall/{employeeid}")
	public List<Map<String, Object>> getByAllWithImage(@PathVariable("employeeid") Integer id) {
		return imageService.getAllImageEmployee(id);
	}
	
	
}
