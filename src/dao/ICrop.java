package dao;

import java.util.List;

import model.Crop;


public interface ICrop {

	public String addCrop(Crop crop);
	
	public List<Crop> viewCrops();
	
	public String updateCrop(Crop crop);
	
	public String deleteCrop(Crop crop);
	
	public Crop getCropByName(String name);
}
