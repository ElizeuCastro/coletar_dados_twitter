package br.com.coletar.twiiter;

import br.com.coletar.twitter.util.TwitterConnection;

public class Main {

	public static void main(final String[] args) {
		final String word = "futebol";
		final TwitterConnection twitter = new TwitterConnection();
		twitter.connect();
		twitter.search(word, 100);
	}

}
