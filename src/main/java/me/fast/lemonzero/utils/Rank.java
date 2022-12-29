package me.fast.lemonzero.utils;

public enum Rank {
    OWNER("&cOwner"),
    CO_OWNER("&cOwner"),
    ADMIN("&4Admin"),
    MODERATOR("&bModerator"),
    HELPER("&9Helper"),
    LEMONGOD("&eLemonGod"),
    LEMONSLICE("&6LemonSlice"),
    DEFAULT("&7Default");

    final String display;

    Rank(String display) {
        this.display = MessageUtils.translate(display);
    }

    public String getDisplay() {
        return display;
    }
}
