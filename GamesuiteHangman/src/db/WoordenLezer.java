package db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.WoordenLijst;

public class WoordenLezer {
	
	public WoordenLezer(String bestandsnaam){
		
	}
	
	public WoordenLijst lees(){
		WoordenLijst content = null;

		try(BufferedReader br = new BufferedReader(new FileReader("hangman.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	content.voegToe(line);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	

}
