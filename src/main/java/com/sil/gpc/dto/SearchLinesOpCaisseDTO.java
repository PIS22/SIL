package com.sil.gpc.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SearchLinesOpCaisseDTO {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String codeCaisse;

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getCodeCaisse() {
        return codeCaisse;
    }

    public void setCodeCaisse(String codeCaisse) {
        this.codeCaisse = codeCaisse;
    }
}
