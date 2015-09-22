package br.com.coletar.twitter.modelo;

public class Tweet {

	private long id;
	private String user;
	private String text;
	private String userLocation;
	private String tweetPlace;
	private String tweetCountry;
	private String tweetFullName;
	private int retweets;
	private String date;

	public Tweet(long id, String user, String text, String userLocation,
			String tweetPlace, String tweetCountry, String tweetFullName,
			int retweets, String date) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.userLocation = userLocation;
		this.tweetPlace = tweetPlace;
		this.tweetCountry = tweetCountry;
		this.tweetFullName = tweetFullName;
		this.retweets = retweets;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", user=" + user + ", text=" + text
				+ ", userLocation=" + userLocation + ", tweetPlace="
				+ tweetPlace + ", tweetCountry=" + tweetCountry
				+ ", tweetFullName=" + tweetFullName + ", retweets=" + retweets
				+ ", date=" + date + "]";
	}

}
