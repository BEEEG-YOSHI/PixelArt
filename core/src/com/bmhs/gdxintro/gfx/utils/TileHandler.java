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

        spriteOnSheetHeight = 64;
        spriteOnSheetWidth = 64;

        Texture tempTexture = new Texture(primaryColorSheetPath);

        TextureRegion tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*2, spriteOnSheetHeight*0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blackWorldTile = new WorldTile(tempRegion, 0, "black");
        worldTileArray.add(blackWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*5, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile green1WorldTile = new WorldTile(tempRegion, 1, "green1");
        worldTileArray.add(green1WorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*6, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile green2WorldTile = new WorldTile(tempRegion, 2, "green2");
        worldTileArray.add(green2WorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*5, spriteOnSheetHeight*1, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile grayWorldTile = new WorldTile(tempRegion, 3, "gray");
        worldTileArray.add(grayWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*9, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile gray2WorldTile = new WorldTile(tempRegion, 4, "gray2");
        worldTileArray.add(gray2WorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*2, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile redWorldTile = new WorldTile(tempRegion, 5, "red");
        worldTileArray.add(redWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*3, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile orangeWorldTile = new WorldTile(tempRegion, 6, "orange");
        worldTileArray.add(orangeWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*0, spriteOnSheetHeight*4, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile yellowWorldTile = new WorldTile(tempRegion, 7, "yellow");
        worldTileArray.add(yellowWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth*8, spriteOnSheetHeight*1, spriteOnSheetWidth*4, spriteOnSheetHeight);
        WorldTile dirtWorldTile = new WorldTile(tempRegion, 8, "dirt");
        worldTileArray.add(dirtWorldTile);
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
