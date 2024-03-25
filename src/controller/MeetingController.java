package controller;

import java.util.List;

import dao.MeetingImpl;
import model.Meeting;

public class MeetingController{
	MeetingImpl meetingImpl=new MeetingImpl();
	
	public String addMeeting(Integer id,String title,String date,String time) {
		Meeting meeting=new Meeting(id, title, date, time);
		return meetingImpl.addMeeting(meeting);
	}

	
	public List<Meeting> viewMeetings() {
		
		return meetingImpl.viewMeetings();
	}

	
	public String updateMeeting(Integer id,String title,String date,String time) {
		Meeting meeting=new Meeting(id, title, date, time);
		return meetingImpl.updateMeeting(meeting);
	}

	
	public String deleteMeeting(Integer id) {
		Meeting meeting=new Meeting();
		meeting.setMeetingId(id);
		return meetingImpl.deleteMeeting(meeting);
	}

}
