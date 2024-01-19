package com.bmhs.gdxintro.gfx.assets;

public abstract class Tile {

    public static final int ON_SCREEN_DEFAULT_WIDTH = 32, ON_SCREEN_DEFAULT_HEIGHT = 32;

    private int defaultWorldTileHeight, defaultWorldTileWidth, id;

    private String name;

    public Tile(int id, String name){
        this.id = id;
        this.name = name;

        defaultWorldTileHeight = ON_SCREEN_DEFAULT_HEIGHT;
        defaultWorldTileWidth = ON_SCREEN_DEFAULT_HEIGHT;
    }

    public int getDefaultWorldTitleHeight() {
        return defaultWorldTileHeight;
    }

    public int getDefaultWourldTitleWidth() {
        return defaultWorldTileWidth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
