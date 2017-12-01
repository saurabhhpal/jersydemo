package com.example.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.example.model.EmailAttachment;

public class ZipUtility {
	
	
public static byte[] zipBytes() throws IOException {
		
	String cont1="pal,pal\n dvu,dvu";
	String cont2="<home>pal</home>";
	String filename1="abc.txt";
	String filename2="def.csv";
	String filename3="ghi.xml";
		//List<String> srcFiles= Arrays.asList(filename1,filename2,filename3);
		
		byte[] input=cont1.getBytes();
		byte[] input1=cont2.getBytes();
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ZipOutputStream zos = new ZipOutputStream(baos);
	    ZipEntry entry = new ZipEntry(filename1);
	    entry.setSize(input.length);
	    zos.putNextEntry(entry);
	    zos.write(input);
	
	 //   ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
	  //  ZipOutputStream zos1 = new ZipOutputStream(baos1);
	    ZipEntry entry1 = new ZipEntry(filename2);
	    entry.setSize(input.length);
	    zos.putNextEntry(entry1);
	    zos.write(input);
	
	   // ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
	    //ZipOutputStream zos2 = new ZipOutputStream(baos2);
	    ZipEntry entry2 = new ZipEntry(filename3);
	    entry.setSize(input1.length);
	    zos.putNextEntry(entry2);
	    zos.write(input1);
	
	    
	    zos.closeEntry();
	    zos.close();
	    return baos.toByteArray();
	}


public static byte[] zipMultipleFiles(List<EmailAttachment> attachmentList) throws IOException {
	
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ZipOutputStream zos = new ZipOutputStream(baos);
    
	System.out.println("in zip multiple files");

	for(EmailAttachment attachmentList1 : attachmentList )
	{
		System.out.println(attachmentList1);
	}
	
	for (EmailAttachment attachment : attachmentList) {
        
		
        
        ZipEntry zipEntry = new ZipEntry(attachment.getFilename());
        zipEntry.setSize(attachment.getFileByteArray().length);
        zos.putNextEntry(zipEntry);
        zos.write(attachment.getFileByteArray());       
            
    }
	zos.closeEntry();
    zos.close();
    return baos.toByteArray();
}


}
