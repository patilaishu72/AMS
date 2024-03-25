package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Meeting;
import util.Db;
import util.Query;

public class MeetingImpl implements IMeeting{
	PreparedStatement statement=null;
	String result=null;
	
	@Override
	public String addMeeting(Meeting meeting) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.ADD_MEETING);
			statement.setInt(1, meeting.getMeetingId());
			statement.setString(2, meeting.getMeetingTitle());
			statement.setString(3, meeting.getMeetingDate());
			statement.setString(4, meeting.getMeetingTime());
			statement.executeUpdate();
			result="Meeting added successfully!";
		} catch (SQLException e) {
		e.printStackTrace();
			result="Meeting with Id "+meeting.getMeetingId()+" already exists!";
		}
		return result;
	}

	@Override
	public List<Meeting> viewMeetings() {
		List<Meeting> list=null;
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.VIEW_MEETINGS);
			ResultSet set=statement.executeQuery();
			list =new ArrayList<Meeting>();
			while (set.next()) {
				Meeting meeting=new Meeting(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
				list.add(meeting);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	@Override
	public String updateMeeting(Meeting meeting) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.UPDATE_MEETING);
			statement.setString(1, meeting.getMeetingTitle());
			statement.setString(2, meeting.getMeetingDate());
			statement.setString(3, meeting.getMeetingTime());
			statement.setInt(4, meeting.getMeetingId());
			int status= statement.executeUpdate();
			if(status>0)
				result="Meeting updated successfully!";
			else result="Meeting with Id "+meeting.getMeetingId()+" does not exist!";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	@Override
	public String deleteMeeting(Meeting meeting) {
		try {
			statement=Db.getObject().getConnection().prepareStatement(Query.DELETE_MEETING);
			statement.setInt(1, meeting.getMeetingId());
			int status=statement.executeUpdate();
			if(status>0)
				result="Meeting deleted successfully!";
			else result="Meeting with Id "+meeting.getMeetingId()+" does not exist!";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

}
