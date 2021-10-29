package com.sil.gpc.domains;

import java.util.List;

public class EcritureBlock {
    public Ecriture e;
    public List<LigneEcriture> lines;

    public EcritureBlock(Ecriture e, List<LigneEcriture> lines) {
        this.e = e;
        this.lines = lines;
    }

    public Ecriture getE() {
        return e;
    }

    public void setE(Ecriture e) {
        this.e = e;
    }

    public List<LigneEcriture> getLines() {
        return lines;
    }

    public void setLines(List<LigneEcriture> lines) {
        this.lines = lines;
    }
}
