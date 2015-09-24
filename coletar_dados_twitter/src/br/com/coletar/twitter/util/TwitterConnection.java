package br.com.coletar.twitter.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import br.com.coletar.twiiter.banco.Persistence;
import br.com.coletar.twitter.modelo.Tweet;

public class TwitterConnection {

	private static long TIMEOUT = 10 * 60 * 1000;

	private SimpleDateFormat dateFormat;
	private static final String TOKEN = "3734520579-Fyr9UTXtZnArVoBNnqCaXQe3VBpZRrWZBbmkGlb";
	private static final String TOKEN_SECRET = "wwOVe0cz3hJ2VzzT3TNo0kuNJ65PqCmprpR0TbnWkvwaW";
	private static final String CONSUMER_KEY = "MzliOiM9NcyVCaNTxHd3msNYH";
	private static final String CONSUMER_SECRET = "9lOqLGFRTWz14YgCAeUIckoEzMpi1op5S8eKA0djNjZ5ZbYCIE";
	private Twitter twitter;
	private Persistence persistence;
	
	public void connect() {
		twitter = TwitterFactory.getSingleton();
		final AccessToken accessToken = new AccessToken(TOKEN, TOKEN_SECRET);
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		twitter.setOAuthAccessToken(accessToken);
		persistence = new Persistence();
		persistence.connect();
		dateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm");
	}

	public void search(final String queryString, final int tweetCount) {
		final long startTime = Calendar.getInstance().getTimeInMillis();
		Query query = new Query(queryString);
		query.setCount(100);
		QueryResult result = null;
		do {
			try {
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
					final String date = dateFormat.format(status.getCreatedAt());
					final Tweet tweet = new Tweet(id, user, text, userLocation,
							tweetPlace, tweetCountry, tweetFullName, retweets,
							date);
					
					persistence.saveTweet(tweet);
					
				}

				/* nova pesquisa */
				query = result.nextQuery();
				query.setCount(100);
				query.setSinceId(query.getMaxId());

			} catch (final TwitterException e) {
				System.out.println("error " + e);
			}
			System.out.println("rate limit remaining = " + result.getRateLimitStatus().getRemaining());
		} while (Calendar.getInstance().getTimeInMillis() - startTime < TIMEOUT);
	}
}