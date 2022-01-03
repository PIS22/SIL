package com.sil.gpc.encapsuleurs;

import com.sil.gpc.domains.Placement;
import com.sil.gpc.domains.LignePlacement;

import java.util.List;

public class EncapPlacement {

    private Placement placement;
    private List<LignePlacement> lignePlacements;

    public  EncapPlacement(Placement placement, List<LignePlacement> lignePlacements){
        super();
        this.placement = placement;
        this.lignePlacements = lignePlacements;

    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public List<LignePlacement> getLignePlacements() {
        return lignePlacements;
    }

    public void setLignePlacements(List<LignePlacement> lignePlacements) {
        this.lignePlacements = lignePlacements;
    }


}
