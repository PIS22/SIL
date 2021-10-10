package com.sil.gpc.domains;

import java.util.List;

public class OpPrestBlock {
	private List<LigneOpCaisse> lines;
	private OpCaisse opc;

	public OpPrestBlock() {
		// TODO Auto-generated constructor stub
	}

	public OpPrestBlock(OpCaisse opc, List<LigneOpCaisse> lines) {
		super();
		this.lines = lines;
		this.opc = opc;
	}

	public List<LigneOpCaisse> getLines() {
		return lines;
	}

	public void setLines(List<LigneOpCaisse> lines) {
		this.lines = lines;
	}

	public OpCaisse getOpc() {
		return opc;
	}

	public void setOpc(OpCaisse opc) {
		this.opc = opc;
	}

	@Override
	public String toString() {
		return "OpPrestBlock [lines=" + lines + ", opc=" + opc + "]";
	}

}
