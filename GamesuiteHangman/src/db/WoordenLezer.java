package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import model.WoordenLijst;

public class WoordenLezer {
	private File file;
	
	public WoordenLezer(String bestandsnaam){
		setBestandsNaam(bestandsnaam);
	}
	
	private void setBestandsNaam(String bestandsnaam) {
		if(bestandsnaam == null || bestandsnaam.trim().isEmpty() /*|| bestandsnaam.substring(bestandsnaam.length()-5, bestandsnaam.length()-1) != ".txt"*/){
			throw new DbException("");
		}
		this.file = new File(bestandsnaam);
	}

	public WoordenLijst lees(){
		WoordenLijst content = new WoordenLijst();
		try {
			Scanner sc = new Scanner(getFile());
			while (sc.hasNextLine()){
				String line = sc.nextLine();
				content.voegToe(line);				
			}
			sc.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return content;
	}

	public File getFile() {
		return file;
	}
	

}
