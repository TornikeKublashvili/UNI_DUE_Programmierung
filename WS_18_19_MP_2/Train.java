public class Train {

	// Kann für die Ausgabe verwendet werden
	private static final String LOCOMOTIVE = "<___|o|";

	private Waggon head;

	public int getSize() {
		int size = 0;
		Waggon w = head;
		while(w != null) {
			w = w.getNext();
			size++;
		}
		return size;
	}

	public int getPassengerCount() {
		int anzahl = 0;
		Waggon w = head;
		while(w != null) {
			anzahl += w.getPassengers();
			w = w.getNext();
		}
		return anzahl;
	}

	public int getCapacity() {
		int capacity = 0;
		Waggon w = head;
		while(w != null) {
			capacity += w.getCapacity();
			w = w.getNext();
		}
		return capacity;
	}

	public void appendWaggon(Waggon waggon) {
		if(head == null) {
			head = waggon;
		}
		else {
			getWaggonAt(getSize()-1).setNext(waggon);
		}
	}

	public void boardPassengers(int numberOfPassengers) {
		Waggon w = head;
		int restPassengers = numberOfPassengers;
		while(w != null) {
			if(w.getCapacity()-w.getPassengers() >= restPassengers) {
				w.setPassengers(restPassengers + w.getPassengers());
				restPassengers = 0;
			}
			else {
				restPassengers = restPassengers -(w.getCapacity() - w.getPassengers());
				w.setPassengers(w.getCapacity());
			}
			w = w.getNext();
			
		}
		
	}

	public Train uncoupleWaggons(int index) {
		Train t = new Train();
		if(index <0 || index > getSize()-1) {
			return t;
		}
		else if(index == 0) {
			t.head = this.head;
			this.head = null;
			return t;
		}
		else {
			t.head = getWaggonAt(index);
			getWaggonAt(index-1).setNext(null);
			return t;
		}
	}

	public void insertWaggon(Waggon waggon, int index) {
		if(index < 0) {
			return;
		}
		else if(index == 0){
			waggon.setNext(head);
			head = waggon;
		}
		else if(index >= getSize()) {
			getWaggonAt(getSize()-1).setNext(waggon);
		}
		else {
			waggon.setNext(getWaggonAt(index));
			getWaggonAt(index-1).setNext(waggon);
		}
	}

	public void turnOver() {
		Train t = new Train();
		for(int i = getSize(); i > 0; i --) {
			getWaggonAt(i-1).setNext(null);
			t.appendWaggon(getWaggonAt(i-1));
		}
		this.head = t.head;
	}

	public void removeWaggon(Waggon waggon) {
		if(head != null && waggon != null) {
			if(head.equals(waggon)) {
				head = head.getNext();
			}
			else {
				Waggon w = head;
				while(w.getNext()!= null) {
					if(w.getNext().equals(waggon)) {
						w.setNext(w.getNext().getNext());
						return;
					}
					w = w.getNext();
				}
			}	
		}
	}

	public Waggon getWaggonAt(int index) {
		if(index < 0 || index >= getSize()) {
			return null;
		}
		else {
			Waggon w = head;
			for(int i = 0; i < index; i ++) {
				w = w.getNext();
			}
			return w;
		}
		
	}
	

	@Override 
	public String toString() {
		if (getSize() == 0) {
			return LOCOMOTIVE;
		}

		StringBuilder str = new StringBuilder(LOCOMOTIVE);

		Waggon pointer = head;
		while (pointer != null) {
			str.append(" <---> ");
			str.append(pointer.getName());
			pointer = pointer.getNext();
		}

		return str.toString();
	}

}
