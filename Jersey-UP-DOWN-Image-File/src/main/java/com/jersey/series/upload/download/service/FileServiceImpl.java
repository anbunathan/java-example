package com.jersey.series.upload.download.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/fileservice")
public class FileServiceImpl implements IFileService {

	public static final String UPLOAD_FILE_SERVER = "D:/Demo/upload/";

	// http://localhost:8080/Jersey-UP-DOWN-Image-File/rest/fileservice/download/image
	@GET
	@Path("/download/image")
	@Produces({"image/png", "image/jpg", "image/gif"})
	public Response downloadImageFile() {

		// set file (and path) to be download
		File file = new File("D:/Demo/download/MyImageFile.png");

		ResponseBuilder responseBuilder = Response.ok((Object) file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
		return responseBuilder.build();
	}

	// http://localhost:9900/Jersey-UP-DOWN-Image-File/rest/fileservice/upload/images
	@POST
	@Path("/upload/images")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadImageFile(
			@FormDataParam("uploadFile") InputStream fileInputStream, 
			@FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {
//		@FormDataParam("filename") String filename) {

		// local variables
		String fileName = null;
		String uploadFilePath = null;

		try {
			fileName = fileFormDataContentDisposition.getFileName();
//			fileName = filename;
			System.out.println("fileName = "+fileName);
			uploadFilePath = writeToFileServer(fileInputStream, fileName);
		} 
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			// release resources, if any
		}
		return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	}

	/**
	 * write input stream to file server
	 * @param inputStream
	 * @param fileName
	 * @throws IOException 
	 */
	private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {

		OutputStream outputStream = null;
		String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
		System.out.println("qualifiedUploadFilePath = "+qualifiedUploadFilePath);
		try {
			outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally{
			//release resource, if any
			outputStream.close();
		}
		return qualifiedUploadFilePath;
	}
}