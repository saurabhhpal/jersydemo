package com.example.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.EmailAttachment;
import com.example.utility.ZipUtility;

public class ZipService {
	
	public byte[] zipMultipleFiles() throws IOException{
		
	List<EmailAttachment> attachmentList= new ArrayList<EmailAttachment>(); 
	
	String filename1="abc.txt";
	String cont1="pal,pal\n dvu,dvu";
	byte[] input1=cont1.getBytes();
	EmailAttachment attachment1= new EmailAttachment();
	attachment1.setFileByteArray(input1);
	attachment1.setFilename(filename1);
	attachmentList.add(attachment1);
	System.out.print(attachmentList);
	
	String filename2="def.xml";
	String cont2="<home>pal</home>";	
	byte[] input2=cont2.getBytes();
	EmailAttachment attachment2= new EmailAttachment();
	attachment2.setFileByteArray(input2);
	attachment2.setFilename(filename2);
	attachmentList.add(attachment2);
	
	
	
	return  ZipUtility.zipMultipleFiles(attachmentList);
	
	
	
}

	
}
