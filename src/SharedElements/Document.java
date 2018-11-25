package SharedElements;
import DomainLayer.*;
import java.util.ArrayList;

import DomainLayer.Author;
import DomainLayer.Cover;

public class Document {
    private int documentId;
    private String name;
    private ArrayList<Author> authors;
    private String dateCreated;
    private Cover cover;
    private String type;
    private String content;
    private int availableAmount;
    private String location;
    
    public Document(int id, String name, ArrayList<Author> authors, String date, String type, int availableAmount)
    {
    	documentId = id;
    	this.name = name;
    	this.authors = authors;
    	dateCreated = date;
    	this.type = type;
    	this.availableAmount = availableAmount;
    	location = null;
    }
    public boolean performUpload(){
    	Upload upload = null;
    	if(type.equalsIgnoreCase("PDF"))
    	{
    		upload = new UploadPdf();
    	}
    	else if(type.equalsIgnoreCase("Docx"))
    	{
    		upload = new UploadPng();
    	}
    	else if(type.equalsIgnoreCase("PNG"))
    	{
    		upload = new UploadDocx();
    	}
    	byte [] file = upload.openFileBrowser();
    	if(file == null)
    		return false;
    	
    	location = upload.writeFileContent(file);
    	if(location == null)
    		return false;
    	
    	return true;
    }
}
