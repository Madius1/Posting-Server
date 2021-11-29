package jku;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Post {

    private String mood;
    private String description;
    private Timestamp time;
    private String userId;
    private ArrayList<String> hashtag;
    private ArrayList<String> userTags;

	@Override
	public String toString() {
		return "Post [mood=" + mood + ", description=" + description + ", time=" + time + ", id=" + userId + ", hashtag="
				+ hashtag + ", userTags=" + userTags + "]";
	}
	
	public DBObject toDBObject() {
	
		return new BasicDBObject().append("mood", this.mood)
				.append("description", this.description)
				.append("time", this.time)
				.append("id", this.userId)
				.append("hashtag", this.hashtag)
				.append("userTags", this.userTags);
	}

	public Post(String mood, String description, Timestamp time, String id, ArrayList<String> hashtag,
			ArrayList<String> userTags) {
		super();
		this.mood = mood;
		this.description = description;
		this.time = time;
		this.userId = id;
		this.hashtag = hashtag;
		this.userTags = userTags;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public ArrayList<String> getHashtag() {
		return hashtag;
	}

	public void setHashtag(ArrayList<String> hashtag) {
		this.hashtag = hashtag;
	}

	public ArrayList<String> getUserTags() {
		return userTags;
	}

	public void setUserTags(ArrayList<String> userTags) {
		this.userTags = userTags;
	}
    
}
