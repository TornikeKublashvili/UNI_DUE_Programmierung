import java.util.Arrays;

public class Measurement {

	private int[] data;

	public Measurement() {
		data = new int[0];
	}

	public void addValue(int value) {
		data = add(data, value);
	}
	
	public void addValues(int[] values) {
		if(values == null) {
			return;
		}
		else {
			for(int i = 0; i < values.length; i++) {
				data = add(data, values[i]);
			}
		}
	}

	public int getMinimumValue() {
		int minValue = Integer.MAX_VALUE;
		if(data == null) {
			return 0;
		}
		else {
			for(int i = 0; i < data.length; i ++) {
				if(data[i] < minValue) {
					minValue = data[i];
				}
			}
		}
		return minValue;
	}

	public int[] getValuesAboveThreshold(int threshold) {
		int[] alleWerte = new int[0];
		for(int i = 0; i < data.length; i ++) {
			if(data[i] > threshold) {
				alleWerte = add(alleWerte, data[i]);
			}
		}
		return alleWerte;
	}
	
	//Ersatzmethode; 
	public int [] add (int [] array, int value){
		if(array == null) {
			int neueArray[] = new int[1];
			neueArray[0] = value;
			return neueArray;
		}else {
			int neueArray[] = new int[array.length + 1];
			for(int i = 0; i < array.length; i ++) {
				neueArray [i] = array[i];
			}
			neueArray[neueArray.length - 1] = value;
			return neueArray;
		}
		
	}

	// --------------------------------------------------------------
	
	public void printData() {
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		Measurement m = new Measurement();
		System.out.println("Neues Measurement-Objekt m erzeugt. m:");
		// ErwarteteAusgabe:
		// []
		m.printData();

		System.out.println("------------------------------------------------------------------");
		
		m.addValue(85);
		System.out.println("Hinzufügen eines neuen Wertes. m:");
		// Erwartete Ausgabe:
		// [85]
		m.printData();
		
		System.out.println("------------------------------------------------------------------");
		
		m.addValues(new int[] { 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93 });
		System.out.println("Hinzuzfügen einer Menge von Werten. m:");
		// Erwartete Ausgabe:
		// [85, 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93]
		m.printData();
		
		System.out.println("------------------------------------------------------------------");
		
		int minimumValue = m.getMinimumValue();
		System.out.println("Minimaler Wert der Messreihe m:");
		// Erwartete Ausgabe: 58
		System.out.println(minimumValue);
		
		System.out.println("------------------------------------------------------------------");
		
		int[] valuesAbove78 = m.getValuesAboveThreshold(78);
		System.out.println("Messwerte über 78:");
		// Erwartete Ausgabe:
		// [85, 93, 81, 79, 81, 93]
		System.out.println(Arrays.toString(valuesAbove78));
		
		System.out.println("------------------------------------------------------------------");
		
		int[] valuesAbove93 = m.getValuesAboveThreshold(93);
		System.out.println("Messwerte über 93:");
		// Erwartete Ausgabe:
		// []
		System.out.println(Arrays.toString(valuesAbove93));
	}

}
