package dao;

import java.util.List;

import model.Meeting;


public interface IMeeting {

	public String addMeeting(Meeting meeting);
	
	public List<Meeting> viewMeetings();
	
	public String updateMeeting(Meeting meeting);
	
	public String deleteMeeting(Meeting meeting);
	
	
}
