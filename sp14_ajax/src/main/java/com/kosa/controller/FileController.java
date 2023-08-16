package com.kosa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.dto.AttachFileDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
@Controller
public class FileController {

	@GetMapping("/uploadAjax")
	public String uploadAjax() {
		log.info("upload ajax");
		return "uploadAjax";
	}

	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.GET)
	public String showForm() {
		return "AddUser"; // /WEB-INF/views/AddUser.jsp
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
	
	

	@ResponseBody
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachFileDTO>> uploaAjaxPost(MultipartFile[] uploadFile) {
		log.info("update ajax post.......");

		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\Users\\KOSA\\upload";
		
		String uploadFolderPath = getFolder();
		//make folder ---------
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("upload path: " + uploadPath);
		
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		//make yyyy/MM/dd folder
		for (MultipartFile multipartFile : uploadFile) {
			log.info("------------------------------------------------------");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());
			log.info("------------------------------------------------------");
			
			AttachFileDTO attachDTO = new AttachFileDTO();

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
//			쌩 파일이름만 올수도있고 폴더경로가 포함될 수도 있어서 마지막\의 이후만 빼낸다(폴더 경로가 포함된 경우에 작용)
//	        uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name : " + uploadFileName);
			attachDTO.setFileName(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;


			try {
				File saveFile = new File(uploadFolder, uploadFileName);
				System.out.println("uploadFolder : " + uploadFolder);
				System.out.println("uploadFileName : " + uploadFileName);
				multipartFile.transferTo(saveFile);
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
				
				Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
				thumbnail.close();
				
				//add to List
				list.add(attachDTO);

			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping("/upload")
	public String saveFile(MultipartHttpServletRequest req) {
		
		String uploadFolder = "C:\\Users\\KOSA\\upload";
		
		List<MultipartFile> files = req.getFiles("uploadFile");
		System.out.println(files.size());
		try {
			for (MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);
				file.transferTo(new File(uploadFolder + "\\" + fileName));
			}
		} catch (Exception e) {
			return "upload failed";
		}
		return "upload success";
	}

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {
		log.info("fileName : " + fileName);
		File file = new File("C:\\Users\\KOSA\\upload\\" + fileName);
		log.info("file : " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
