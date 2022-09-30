package song_Stream;

public class songReq {
//	public song_info si = new song_info();
//	public user_info ui = new user_info();
	private String songid;
	private String songname;
	private String artiste;
	private Double duration;
	private String UserID;
	private String Username;
	private String PhoneNO;
	
	public songReq(song_info si, user_info ui) {
		this.songid = si.getSongid();
		this.songname = si.getSongname();
		this.artiste = si.getArtiste();
		this.duration = si.getDuration();
		this.UserID = ui.getUserID();
		this.Username = ui.getUsername();
		this.PhoneNO = ui.getPhoneNO();
	}

	public String getSongid() {
		return songid;
	}

	public void setSongid(String songid) {
		this.songid = songid;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPhoneNO() {
		return PhoneNO;
	}

	public void setPhoneNO(String phoneNO) {
		PhoneNO = phoneNO;
	}

	@Override
	public String toString() {
		return "songReq [songid=" + songid + ", songname=" + songname + ", artiste=" + artiste + ", duration="
				+ duration + ", UserID=" + UserID + ", Username=" + Username + ", PhoneNO=" + PhoneNO + "]";
	}
	
}
