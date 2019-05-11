package com.sda.javagda27;

public class Faktura {

	private String nr_fsaktury;
	private double kwota;
	private int idKlienta;

	public Faktura() {}
	
	public Faktura(String nr_fsaktury, double kwota, int idKlienta) {
		super();
		this.nr_fsaktury = nr_fsaktury;
		this.kwota = kwota;
		this.idKlienta = idKlienta;
	}

	public String getNr_fsaktury() {
		return nr_fsaktury;
	}

	public void setNr_fsaktury(String nr_fsaktury) {
		this.nr_fsaktury = nr_fsaktury;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public int getIdKlienta() {
		return idKlienta;
	}

	public void setIdKlienta(int idKlienta) {
		this.idKlienta = idKlienta;
	}

}
