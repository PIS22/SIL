package com.sil.gpc.domains;

import java.util.List;

public class OpLocBlock {
	public OpCaisse opc;
	public List<Echeance> lines;

	public OpLocBlock() {
		// TODO Auto-generated constructor stub
	}

	public OpLocBlock(OpCaisse opc, List<Echeance> lines) {
		super();
		this.opc = opc;
		this.lines = lines;
	}

	public OpCaisse getOpc() {
		return opc;
	}

	public void setOpc(OpCaisse opc) {
		this.opc = opc;
	}

	public List<Echeance> getLines() {
		return lines;
	}

	public void setLines(List<Echeance> lines) {
		this.lines = lines;
	}
}
