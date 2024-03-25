package model;

public class Crop {

	private Integer cropId;
	private String name;
	private String description;
	public Crop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crop(Integer cropId, String name, String description) {
		super();
		this.cropId = cropId;
		this.name = name;
		this.description = description;
	}
	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
