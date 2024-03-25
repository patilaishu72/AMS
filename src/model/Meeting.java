package model;

public class Meeting {
private Integer meetingId;
private String meetingTitle;
private String meetingDate;
private String meetingTime;
public Meeting() {
	
}
public Meeting(Integer meetingId, String meetingTitle, String meetingDate, String meetingTime) {
	super();
	this.meetingId = meetingId;
	this.meetingTitle = meetingTitle;
	this.meetingDate = meetingDate;
	this.meetingTime = meetingTime;
}
public Integer getMeetingId() {
	return meetingId;
}
public void setMeetingId(Integer meetingId) {
	this.meetingId = meetingId;
}
public String getMeetingTitle() {
	return meetingTitle;
}
public void setMeetingTitle(String meetingTitle) {
	this.meetingTitle = meetingTitle;
}
public String getMeetingDate() {
	return meetingDate;
}
public void setMeetingDate(String meetingDate) {
	this.meetingDate = meetingDate;
}
public String getMeetingTime() {
	return meetingTime;
}
public void setMeetingTime(String meetingTime) {
	this.meetingTime = meetingTime;
}
@Override
public String toString() {
	return String.format("%-15s%-30s%-25s%-25s\n", meetingId,meetingTitle,meetingDate,meetingTime);
}


}
