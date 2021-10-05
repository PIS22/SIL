package com.sil.gpc.domains;

public class OpPointBlock {

	private OpCaisse opc;
	private PointVente pv;

	public OpPointBlock() {
		// TODO Auto-generated constructor stub
	}

	public OpPointBlock(OpCaisse opc, PointVente pv) {
		super();
		this.opc = opc;
		this.pv = pv;
	}

	public OpCaisse getOpc() {
		return opc;
	}

	public void setOpc(OpCaisse opc) {
		this.opc = opc;
	}

	public PointVente getPv() {
		return pv;
	}

	public void setPv(PointVente pv) {
		this.pv = pv;
	}

}