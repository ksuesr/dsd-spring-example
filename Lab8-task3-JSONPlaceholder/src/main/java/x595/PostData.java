package x595;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostData {
	
	@SerializedName("userId")
	@Expose
	private Integer userid;
	
	@SerializedName("id")
	@Expose
	private Integer postid;
	
	@SerializedName("title")
	@Expose
	private String title;
	
	@SerializedName("body")
	@Expose
	private String body;
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String toString() {
		String json = new com.google.gson.Gson().toJson(this);
		return json;
	}

}
