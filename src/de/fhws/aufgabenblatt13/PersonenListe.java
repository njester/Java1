package de.fhws.aufgabenblatt13;

public class PersonenListe {
	public Person start;
	
	public void einfuegen(Person p) {
		if (start == null) {
			start = p;
		} else {
			einfuegen(p, start);
		}
	}
	
	public void einfuegen(Person n, Person m) {
        if (n.getAlter() > m.getAlter()) {
            if (m.getNext() == null) {
                m.setNext(n);
                n.setPrev(m);
            } else if (n.getAlter() < m.getNext().getAlter()) {
                n.setPrevAndNext(m, m.getNext());
                m.getNext().setPrev(n);
                m.setNext(n);
            } else {
                einfuegen(n, m.getNext());
            }
        } else {
            start = n;
            n.setNext(m);
            m.setPrev(n);
        }
    }

    public void gebeListeAus() {
        lieferePersonen(start);
    }

    public void lieferePersonen(Person n) {
        if (n != null) {
            System.out.println(n.getNachname());
            lieferePersonen(n.getNext());
            System.out.println(n.getNachname());
        }
    }

}
