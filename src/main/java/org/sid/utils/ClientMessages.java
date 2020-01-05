package org.sid.utils;

public enum ClientMessages {

    COUNTRY_FIND_BY_ID("Erreur lors de la récupération du pays"),
    COUNTRY_FIND_ALL("Erreur lors de la récupération de la liste des pays"),
    COUNTRY_SEARCH_BY_LABEL("Erreur lors de la recherche des pays"),
    COUNTRY_CREATE("Erreur lors de la création du pays"),
    COUNTRY_UPDATE("Erreur lors de la modification du pays"),
    COUNTRY_DELETE_BY_ID("Erreur lors de la suppression du pays"),
    COUNTRY_COUNT("Erreur lors du comptage des pays"),
    STATE_FIND_BY_ID("Erreur lors de la récupération de l'état"),
    STATE_FIND_ALL("Erreur lors de la récupération de la liste des états"),
    STATE_SEARCH_BY_LABEL("Erreur lors de la recherche des états"),
    STATE_CREATE("Erreur lors de la création de l'état"),
    STATE_UPDATE("Erreur lors de la modification de l'état"),
    STATE_DELETE_BY_ID("Erreur lors de la suppression de état"),
    STATE_COUNT("Erreur lors du comptage des états");

    private final String text;

    ClientMessages(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
