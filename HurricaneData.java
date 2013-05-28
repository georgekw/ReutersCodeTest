package codeTest;

import java.util.Scanner;

public class HurricaneData {

  private int TRange = Integer.MAX_VALUE;
	private int DyIndex = 0, MxTIndex = 0, MnTIndex = 0;
	private String Day;
	
	public boolean isInteger(String s) {
		try {
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
	public String filterString(String s) {
		if (s.contains("*"))
			s = s.replace("*", "");
		return s;
	}
	
	public void procWeatherData(String s) {
		s = s.replaceAll("\\s+", " ").trim();		//Replace all white spaces with a single whitespace
		String[] weatherData = s.split(" ");
		int tempRange;
		
		for (int i=0; i<weatherData.length; i++) {
			weatherData[i] = filterString(weatherData[i]);
			if (weatherData[i].equals("Dy"))
				DyIndex = i;
			else if (weatherData[i].equals("MxT"))
				MxTIndex = i;
			else if (weatherData[i].equals("MnT"))
				MnTIndex = i;
		}
		if (isInteger(weatherData[MxTIndex]) && isInteger(weatherData[MnTIndex])) {
			tempRange = Integer.parseInt(weatherData[MxTIndex]) - Integer.parseInt(weatherData[MnTIndex]);
			//System.out.println("Day: " + weatherData[DyIndex] + " Range: " + tempRange);
			if (tempRange < TRange) {
				TRange = tempRange;
				Day = weatherData[DyIndex];
			}
		}	
	}
	
	public void readWeatherData() throws Exception {
		java.io.File file = new java.io.File("hurdat2-nencpac-1949-2012-040513.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String line = input.nextLine();
			if (line.regionMatches(4, "2009", 0, 4)) {
				System.out.println(line);
				/*while (input.hasNext()) {
					String line = input.nextLine();
					System.out.println(line);
					if (line.regionMatches(4, "2010", 0, 4)) {
						break;
					}
				}*/
			}
		}
		input.close();
	}
	public static void main(String[] args) throws Exception {
		HurricaneData hd = new HurricaneData();
		hd.readWeatherData();
		//System.out.println("The smallest temperature spread occured on day " + hd.Day + " with a range of " + hd.TRange + ".");	
	}

}
