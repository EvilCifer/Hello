package se_12_03;

import java.util.Comparator;
import java.util.List;

public class SortierungNachDauer extends Sortierung {

	@Override
	public void sort(List<Ticket> l) {
		l.sort(new Comparator<Ticket>() {

			@Override
			public int compare(Ticket o1, Ticket o2) {
				if(o1.getDauer() > o2.getDauer()) {
					return 1;
				}
				if(o1.getDauer() < o2.getDauer()) {
					return -1;
				}
				return 0;
			}
			
		});
	}
}
