package se_12_03;

import java.util.Comparator;
import java.util.List;

public class SortierungNachKunde extends Sortierung {

	@Override
	public void sort(List<Ticket> l) {
		l.sort(new Comparator<Ticket>() {

			@Override
			public int compare(Ticket o1, Ticket o2) {
				if(o1.getKunde().length() == o2.getKunde().length()) {
					for(int i = 0; i < o1.getKunde().length(); ++i) {
						if(o1.getKunde().charAt(i) < o2.getKunde().charAt(i)) {
							return -1;
						}
						if(o1.getKunde().charAt(i) > o2.getKunde().charAt(i)) {
							return 1;
						}
					}
				}
				if(o1.getKunde().length() < o2.getKunde().length()) {
					for(int i = 0; i < o1.getKunde().length(); ++i) {
						if(o1.getKunde().charAt(i) < o2.getKunde().charAt(i)) {
							return -1;
						}
						if(o1.getKunde().charAt(i) > o2.getKunde().charAt(i)) {
							return 1;
						}
					}
				}
				if(o1.getKunde().length() > o2.getKunde().length()) {
					for(int i = 0; i < o2.getKunde().length(); ++i) {
						if(o1.getKunde().charAt(i) < o2.getKunde().charAt(i)) {
							return -1;
						}
						if(o1.getKunde().charAt(i) > o2.getKunde().charAt(i)) {
							return 1;
						}
					}
				}
				return 0;
			}
		});
	}
}
