package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.WoordenLijst;

public class WoordenLezer {
	private File file;
	
	public WoordenLezer(File file){
		setBestandsNaam(file);
	}
	
	private void setBestandsNaam(File file) {
		this.file = file;
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
