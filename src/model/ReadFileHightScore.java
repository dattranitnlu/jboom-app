package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileHightScore {
	private ArrayList<HightScore> arrHightScore;

	public ReadFileHightScore() {
		arrHightScore = new ArrayList<HightScore>();
		try {
			FileReader file = new FileReader("src/hightscore/HightScore.txt");
			BufferedReader input = new BufferedReader(file);
			String line;
			while ((line = input.readLine()) != null) {
				String str[] = line.split(":");
				String name = str[0];
				int score = Integer.parseInt(str[1]);
				HightScore hightScore = new HightScore(name, score);
				arrHightScore.add(hightScore);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HightScore> getArrHightScore() {
		return arrHightScore;
	}
}
