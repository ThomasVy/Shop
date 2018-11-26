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
    private int quantitySetAside;
    
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
    	quantitySetAside = 0;
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
    public Document(int documentID, String name, ArrayList<Author> authors) {
        this.documentId = documentID;
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.availableAmount = availableAmount;
    }
    
    @Override
    public String toString()
    {
    	StringBuilder string = new StringBuilder();
    	string.append(documentId).append("    "+name).append("    "+dateCreated).append("    " +price).append("    " + availableAmount + "    ");
    	for(Author author: authors)
    	{
    		string.append(author.getName() + ", ");
    	}
    	string.deleteCharAt(string.length()-2);
    	return string.toString();
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void takeAwayQuantity() {
    	availableAmount --;
    	quantitySetAside ++;
	}

	public int getQuantitySetAside () { return quantitySetAside; }

	public void setQuantitySetAside(int quantitySetAside) { this.quantitySetAside = quantitySetAside; }

    public int getAvailableAmount() { return availableAmount; }

    public void setAvailableAmount(int availableAmount) { this.availableAmount = availableAmount; }

    public ArrayList<Author> getAuthors(){ return authors; }
    
    public void setId(int id) {this.documentId = id;}
    
    public void setName(String name) {this.name = name;}
    
    public void setAuthors(ArrayList<Author> authors) { this.authors = authors;}
    
    public void setDate(String date) {this.dateCreated = date;}
    
    public void setPrice(int price) {this.price = price;}
    
    public void setQuantity(int quantity) {this.availableAmount = quantity;}
    
    public void setCover(Cover cover) { this.cover = cover;}

}
