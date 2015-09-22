package br.com.coletar.twiiter;

import java.util.ArrayList;

import twitter4j.Twitter;
import br.com.coletar.twitter.modelo.Tweet;
import br.com.coletar.twitter.util.TwitterUtils;

public class Main {

	public static void main(String[] args) {
		String tweetWords = "futebol";
		int nTweets = 25;
		Twitter twitter = TwitterUtils.createTwitter();
		ArrayList<Tweet> data = TwitterUtils.search(twitter, tweetWords, nTweets);
		System.out.println(data.toString());
	}
	
}
