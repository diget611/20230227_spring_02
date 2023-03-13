package kh.spring.s02.common.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtil {
	
	private final static String UPLOAD_FOLDER = "\\resources\\uploadfiles";
	
	public List<Map<String, String>> saveFileList(MultipartHttpServletRequest multiReq, HttpServletRequest request, String addedPath) throws Exception {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		Iterator<String> iterator = multiReq.getFileNames();	// Nmae -> <input name="n1">
		while(iterator.hasNext()) {
			String name = iterator.next();	// "n1"
			MultipartFile multiFile = multiReq.getFile(name);
			Map<String, String> map = new HashMap<String, String>();
			map = saveFile(multiFile, request, addedPath);
			result.add(map);
		}
		return result;
	}
	
	/**
	 * @param uploadFile
	 * @param request
	 * @return map - "original" : original file path, "rename" : saved file path
	 */
	public Map<String, String> saveFile(MultipartFile uploadFile, HttpServletRequest request, String addedPath) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		String renameFilePath = "";
		String renameByTime = "";
		if(uploadFile != null && !uploadFile.equals("")) {
			String originalFileName = uploadFile.getOriginalFilename();
			// file을 server의 특정 위치에 저장
			String webServerRoot = request.getSession().getServletContext().getRealPath("");
			String savePath = webServerRoot + UPLOAD_FOLDER;
			if(addedPath != null) savePath += addedPath;

			// 저장할 폴더가 없을 경우 만들어줘야 함
			File folder = new File(savePath);
			if(!folder.exists()) folder.mkdirs();
			
			// 파일을 savePath 위치에 저장
			// 시간을 활용한 rename
			renameByTime = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
			// UUID
			// String renameByUUID = UUID.randomUUID().toString() + "_" + uploadFile.getOriginalFilename();
			renameFilePath = savePath + "\\" + renameByTime;
			uploadFile.transferTo(new File(renameFilePath));
			
			result.put("original", originalFileName);
			result.put("rename", renameByTime);
		}
		
		return result;
	}
}
