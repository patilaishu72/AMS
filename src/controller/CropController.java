package controller;

import java.util.List;

import dao.CropImpl;
import model.Crop;



public class CropController {
	CropImpl cropImpl = new CropImpl();

	public String addCrop(String name, String description) {
		Crop crop = new Crop(0, name, description);
		return cropImpl.addCrop(crop);
	}
	
public List<Crop> viewCrops() {
		
		return cropImpl.viewCrops();
	}

public String updateCrop(String oldCropName,String newCropName,String description) {
	Crop crop= cropImpl.getCropByName(oldCropName);
	if(crop==null) return "Crop with name "+oldCropName+" does not exist!";
	crop.setName(newCropName);
	crop.setDescription(description);
	return cropImpl.updateCrop(crop);
	
}

public String deleteCrop(String name) {
	Crop crop=cropImpl.getCropByName(name);
	if(crop==null) return "Crop with name "+name+" does not exist!";
	return cropImpl.deleteCrop(crop);
}

public Crop getCropByName(String name) {
	return cropImpl.getCropByName(name);
}

}
