package com.springboot;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 以jsp为模板引擎，上传文件
 * 
 * @author maskwang 2017年6月15日
 */
@Controller
public class FileUploadController {
	@RequestMapping("/file")
	public String file() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/fileUpload")
	public String upload(@RequestParam("file") MultipartFile file) {
		System.out.println(file.isEmpty());
		if (!file.isEmpty()) {
			try {
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File("D:/"+file.getOriginalFilename())));
				out.write(file.getBytes());
				out.flush();
				out.close();
				System.out.println("上传");
				return "上传成功";
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "上传失败," + e.getMessage();
			} catch (IOException e) {
				e.printStackTrace();
				return "上传失败," + e.getMessage();
			}

		}
		return "上传失败，因为文件是空的.";
	}
}
