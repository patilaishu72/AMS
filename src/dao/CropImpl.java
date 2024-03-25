package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Crop;
import util.Db;
import util.Query;

public class CropImpl implements ICrop{
	PreparedStatement statement=null;
	String result=null;
	@Override
	public String addCrop(Crop crop) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.ADD_CROP);
			statement.setString(1, crop.getName());
			statement.setString(2, crop.getDescription());
			statement.executeUpdate();
			result="Crop added successfully!";
		} catch (SQLException e) {
			result="Crop with name "+crop.getName()+" already exists";
		}
		return result;
	}

	@Override
	public List<Crop> viewCrops() {
		List<Crop> list=null;
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.VIEW_CROPS);
			ResultSet set= statement.executeQuery();
			list=new ArrayList<Crop>();
			while (set.next()) {
				Crop crop=new Crop(0, set.getString(2), set.getString(3));
				list.add(crop);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	return list;
	}

	@Override
	public String updateCrop(Crop crop) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.UPDATE_CROP);
			statement.setString(1, crop.getName());
			statement.setString(2, crop.getDescription());
			statement.setInt(3, crop.getCropId());
			int status= statement.executeUpdate();
			if(status>0)
				result="Crop updated successfully!";
			else result="Crop with name "+crop.getName()+" does not exist!";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String deleteCrop(Crop crop) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.DELETE_CROP);
			statement.setInt(1, crop.getCropId());
			statement.executeUpdate();
			result="Crop deleted successfully!";
		} catch (SQLException e) {
			result="Crop with name "+crop.getName()+" does not exist!";
		}
		
		return result;
	}

	@Override
	public Crop getCropByName(String name) {
		Crop crop=null;
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.GET_CROP_BY_NAME);
			statement.setString(1, name);
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				crop=new Crop(set.getInt(1), set.getString(2), set.getString(3));
			}
		} catch (SQLException e) {
			System.err.println("Crop with name "+name+" does not exist!");
		}
		return crop;
	}

}
