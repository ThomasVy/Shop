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
    private double price;
    private int availableAmount;
    private String location;
    
    public Document(int id, String name, ArrayList<Author> authors, String date, String type, int availableAmount, double price)
    {
    	documentId = id;
    	this.name = name;
    	this.authors = authors;
    	dateCreated = date;
    	this.type = type;
    	this.availableAmount = availableAmount;
    	this.price = price;
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
    		upload = new UploadDocx();
    	}
    	else if(type.equalsIgnoreCase("PNG"))
    	{
    		upload = new UploadPng();
    	}
    	byte [] file = upload.openFileBrowser();
    	if(file == null)
    	{
    		return false;
    	}
    	location = upload.writeFileContent(file);
    	if(location == null)
    	{
    		return false;
    	}
    	
    	return true;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public int getAvailableAmount() { return availableAmount; }

    public void setAvailableAmount(int availableAmount) { this.availableAmount = availableAmount; }

    public ArrayList<Author> getAuthors(){ return authors; }

}
