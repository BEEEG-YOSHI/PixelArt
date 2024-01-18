package com.bmhs.gdxintro.gfx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.assets.WorldTile;

public class TileHandler {

    public static TileHandler tileHandler = null;

    private int spriteOnSheetHeight, spriteOnSheetWidth;

    private String primaryColorSheetPath = "primaryColorSheet.png";

    private Array<WorldTile> worldTileArray;

    private TileHandler() {
        worldTileArray = new Array<>();

        spriteOnSheetHeight = Tile.ON_SCREEN_DEFAULT_HEIGHT;
        spriteOnSheetWidth = Tile.ON_SCREEN_DEFAULT_WIDTH;

        Texture tempTexture = new Texture(primaryColorSheetPath);

        TextureRegion tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*2, spriteOnSheetHeight*0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blackWorldTile = new WorldTile(tempRegion, 0, "green1");
        worldTileArray.add(blackWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*3, spriteOnSheetHeight*0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile whiteWorldTile = new WorldTile(tempRegion, 1, "green2");
        worldTileArray.add(whiteWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*2, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile redWorldTile = new WorldTile(tempRegion, 2, "white");
        worldTileArray.add(redWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*5, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile greenWorldTile = new WorldTile(tempRegion, 3, "green");
        worldTileArray.add(greenWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*8, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blueWorldTile = new WorldTile(tempRegion, 4, "blue");
        worldTileArray.add(blueWorldTile);
    }


    public Array<WorldTile> getWorldTileArray(){
        return worldTileArray;
    }

    public static TileHandler getTileHandler(){
        if(tileHandler == null){
            tileHandler = new TileHandler();
        }
        return  tileHandler;
    }
}
