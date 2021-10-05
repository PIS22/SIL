package com.sil.gpc.domains;

public class LignePointBlock {
	public LignePointVente lpv;
	public Magasin mg;

	public LignePointBlock() {
		// TODO Auto-generated constructor stub
	}

	public LignePointBlock(LignePointVente lpv, Magasin mg) {
		super();
		this.lpv = lpv;
		this.mg = mg;
	}

	public LignePointVente getLpv() {
		return lpv;
	}

	public void setLpv(LignePointVente lpv) {
		this.lpv = lpv;
	}

	public Magasin getMg() {
		return mg;
	}

	public void setMg(Magasin mg) {
		this.mg = mg;
	}

}
