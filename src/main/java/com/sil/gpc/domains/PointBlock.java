package com.sil.gpc.domains;

import java.util.List;

public class PointBlock {

	private PointVente pv;
	private List<LignePointVente> lpv;

	public PointBlock() {
		// TODO Auto-generated constructor stub
	}

	public PointBlock(PointVente pv, List<LignePointVente> lpv) {
		super();
		this.pv = pv;
		this.lpv = lpv;
	}

	public PointVente getPv() {
		return pv;
	}

	public void setPv(PointVente pv) {
		this.pv = pv;
	}

	public List<LignePointVente> getLpv() {
		return lpv;
	}

	public void setLpv(List<LignePointVente> lpv) {
		this.lpv = lpv;
	}

}
