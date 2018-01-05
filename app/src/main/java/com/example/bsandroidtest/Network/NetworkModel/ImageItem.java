package com.example.bsandroidtest.Network.NetworkModel;

import com.google.gson.annotations.SerializedName;

public class ImageItem {

	@SerializedName("photo")
	private String photo;

	@SerializedName("text")
	private String text;

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"ImageItem{" + 
			"photo = '" + photo + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}