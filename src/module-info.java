module spotify {
	requires com.google.gson;
	opens song_Stream to com.google.gson;
}