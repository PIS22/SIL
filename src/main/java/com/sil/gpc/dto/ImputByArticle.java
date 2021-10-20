package com.sil.gpc.dto;

public interface ImputByArticle {

    String code_article = new String("");
    String lib_article = new String("");
    int quantite = 0;
    int montant = 0;

    String getCode_article();
    String getLib_article();
    int getQuantite();
    int getMontant();
}
