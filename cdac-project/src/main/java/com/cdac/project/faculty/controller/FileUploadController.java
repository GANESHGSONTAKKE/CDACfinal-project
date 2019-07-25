package com.cdac.project.faculty.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)

	public ModelAndView uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {

		//Path to save upload files
		final String directory = "/home/suraj/file_upload";
		
		ModelAndView mav=new ModelAndView("faculty/applicant/dashboard/resume_upload");
		
		try {
			// Get the filename and build the local file path (be sure that the
			// application have write permissions on such directory)
			String filename = uploadfile.getOriginalFilename();
			
			String filepath = Paths.get(directory, filename).toString();

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
			
			//TODO add document path to DB
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mav.addObject("success",new Boolean(false));
			return mav;
		}
		
		mav.addObject("success", new Boolean(true));
		return mav;
	} // method uploadFile
}
