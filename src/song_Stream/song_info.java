package song_Stream;

import com.google.gson.Gson;

public class song_info 
{
	private String songid;
	private String songname;
	private String artiste;
	
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
	private Double duration;

	@Override
	public String toString() {
		return "song_info [songid=" + songid + ", songname=" + songname + ", artiste=" + artiste + ", duration="
				+ duration + "]";
	} 
	
	/*@Override
	public String toString() {
		return new Gson().toJson(this);
	}*/
}
