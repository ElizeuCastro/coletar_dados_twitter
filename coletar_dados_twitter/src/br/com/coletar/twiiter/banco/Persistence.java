package br.com.coletar.twiiter.banco;

import org.bson.Document;

import br.com.coletar.twitter.modelo.Tweet;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Persistence {

	private final MongoClient mongoClient = new MongoClient();
	private MongoDatabase db;
	private MongoCollection<Document> tweet;

	public void connect() {
		db = mongoClient.getDatabase("coletar-tweets");
		tweet = db.getCollection("tweets");
	}

	public void saveTweet(final Tweet newTweet) {
		final Document document = new Document();
		document.append("tweet_id", newTweet.getTweetId());
		document.append("tweet_text", newTweet.getTweetText());
		document.append("user", newTweet.getUser());
		document.append("user_location", newTweet.getUserLocation());
		document.append("tweet_place", newTweet.getTweetPlace());
		document.append("tweet_place_country", newTweet.getTweetPlaceCountry());
		document.append("tweet_place_full_name", newTweet.getTweetPlaceFullName());
		document.append("retweets", newTweet.getRetweets());
		document.append("date", newTweet.getDate());
		tweet.insertOne(document);
	}
}
