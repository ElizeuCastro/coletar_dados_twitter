package br.com.coletar.twiiter.banco;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	private static MongoClient mongoClient = new MongoClient();
	private static MongoDatabase db;
	private static MongoCollection<Document> albums;

	public static void main(String[] args) {
		db = mongoClient.getDatabase("aula-pos-uninorte");
		albums = db.getCollection("album");
		listarAlbums();
		insertAlbum();
		listarAlbums();
		mongoClient.close();
	}

	private static void listarAlbums() {
		System.out.println("------------------- ALBUMS ----------------");
		for (Document document : albums.find()) {
			System.out.println(document.toJson());
		}
	}

	private static void insertAlbum() {
		Document album = new Document();
		album.append("cantor", "jose " + System.currentTimeMillis());
		album.append("musica", "jose canta");
		album.append("duracao", 5);
		album.append("faixa", 2);
		album.append("compositor", "jose");
		albums.insertOne(album);
	}
}
