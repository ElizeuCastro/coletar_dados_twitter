package br.com.coletar.twitter.modelo;

public class Tweet {

	private final long tweetId;
	private final String user;
	private final String tweetText;
	private final String userLocation;
	private final String tweetPlace;
	private final String tweetPlaceCountry;
	private final String tweetPlaceFullName;
	private final int retweets;
	private final String date;

	public Tweet(final long tweetId, final String user, final String tweetText,
			final String userLocation, final String tweetPlace, final String tweetPlaceCountry,
			final String tweetPlaceFullName, final int retweets, final String date) {
		super();
		this.tweetId = tweetId;
		this.user = user;
		this.tweetText = tweetText;
		this.userLocation = userLocation;
		this.tweetPlace = tweetPlace;
		this.tweetPlaceCountry = tweetPlaceCountry;
		this.tweetPlaceFullName = tweetPlaceFullName;
		this.retweets = retweets;
		this.date = date;
	}

	public long getTweetId() {
		return tweetId;
	}

	public String getUser() {
		return user;
	}

	public String getTweetText() {
		return tweetText;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public String getTweetPlace() {
		return tweetPlace;
	}

	public String getTweetPlaceCountry() {
		return tweetPlaceCountry;
	}

	public String getTweetPlaceFullName() {
		return tweetPlaceFullName;
	}

	public int getRetweets() {
		return retweets;
	}

	public String getDate() {
		return date;
	}

}
