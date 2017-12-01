package com.example.model;

public class EmailAttachment {
	private String filename;
	private byte[] fileByteArray;

	public EmailAttachment() {
		super();
	}

	public EmailAttachment(String filename, byte[] fileByteArray) {
		super();
		this.filename = filename;
		this.fileByteArray = fileByteArray;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFileByteArray() {
		return fileByteArray;
	}

	public void setFileByteArray(byte[] fileByteArray) {
		this.fileByteArray = fileByteArray;
	}

}
