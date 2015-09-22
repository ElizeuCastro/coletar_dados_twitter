package br.com.coletar.twitter.util;

import java.util.ArrayList;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import br.com.coletar.twitter.modelo.Tweet;

public class TwitterUtils {

	private static final String TOKEN = "3734520579-Fyr9UTXtZnArVoBNnqCaXQe3VBpZRrWZBbmkGlb";
	private static final String TOKEN_SECRET = "wwOVe0cz3hJ2VzzT3TNo0kuNJ65PqCmprpR0TbnWkvwaW";
	private static final String CONSUMER_KEY = "MzliOiM9NcyVCaNTxHd3msNYH";
	private static final String CONSUMER_SECRET = "9lOqLGFRTWz14YgCAeUIckoEzMpi1op5S8eKA0djNjZ5ZbYCIE";
	public static Twitter twitter = null;

	public static Twitter createTwitter() {
		if (twitter == null) {
			twitter = TwitterFactory.getSingleton();
			final AccessToken accessToken = new AccessToken(TOKEN, TOKEN_SECRET);
			twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
			twitter.setOAuthAccessToken(accessToken);
		}
		return twitter;
	}

	public static ArrayList<Tweet> search(final Twitter twitter, final String queryString,
			final int tweetCount) {
		final ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		try {
			final Query query = new Query(queryString);
			query.setCount(tweetCount);
			QueryResult result;
			result = twitter.search(query);
			for (final Status status : result.getTweets()) {
				final long id = status.getId();
				final String user = status.getUser().getName();
				final String text = status.getText();
				final String userLocation = status.getUser().getLocation();
				String tweetPlace = "";
				String tweetCountry = "";
				final String tweetFullName = "";
				if (status.getPlace() != null) {
					if (status.getPlace().getName() != null) {
						tweetPlace = status.getPlace().getName();
					}
					if (status.getPlace().getCountry() != null) {
						tweetCountry = status.getPlace().getCountry();
					}
					if (status.getPlace().getFullName() != null) {
						status.getPlace().getFullName();
					}
				}
				final int retweets = status.getRetweetCount();
				final String date = status.getCreatedAt().toLocaleString();
				final Tweet tweet = new Tweet(id, user, text, userLocation,
						tweetPlace, tweetCountry, tweetFullName, retweets, date);

				System.out.println("------------------ TWEET ------------------------");
				System.out.println(tweet.toString());
			}
		} catch (final TwitterException e) {
			e.printStackTrace();
		}
		return tweets;
	}
}