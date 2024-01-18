package com.bmhs.gdxintro.gfx.assets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WorldTile extends Tile{

    private TextureRegion texture;
    private boolean isSolid;

    public WorldTile(TextureRegion texture, int id, String name) {

        super(id, name);
        this.texture = texture;

        isSolid = false;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public void setSolid(boolean solid) {
        isSolid = solid;
    }
}
