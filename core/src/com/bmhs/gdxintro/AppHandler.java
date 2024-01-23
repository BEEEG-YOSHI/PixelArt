package com.bmhs.gdxintro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.utils.TileHandler;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;

	Texture img;

	int x,y;

	//Colors:
	//0:black, 1: light green, 2: dark green, 3:gray, 4:ivory 5:red, 6:orange, 7:yellow
	int[][] canvas = {{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,4 ,0 ,0 ,0 ,3 ,3 ,3 ,3 ,3 ,0 ,0 ,0 ,4 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,4 ,4 ,3 ,3 ,1 ,1 ,1 ,1 ,1 ,3 ,3 ,4 ,4 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,4 ,4 ,3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,3 ,4 ,4 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,4 ,3 ,1 ,1 ,2 ,1 ,1 ,1 ,1 ,1 ,2 ,1 ,1 ,3 ,4 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
		    {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,3 ,1 ,1 ,2 ,3 ,2 ,1 ,1 ,1 ,2 ,3 ,2 ,1 ,1 ,3 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,3 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,3 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,3 ,0 ,0 ,0 ,0 ,0 ,5 ,0 },
			{0 ,5 ,0 ,0 ,0 ,0 ,2 ,3 ,1 ,1 ,1 ,1 ,1 ,1 ,3 ,2 ,3 ,1 ,1 ,1 ,1 ,1 ,1 ,3 ,2 ,0 ,5 ,0 ,0 ,5 ,0 },
			{0 ,5 ,0 ,0 ,5 ,2 ,2 ,3 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,1 ,1 ,1 ,3 ,2 ,2 ,0 ,5 ,5 ,5 ,5 },
			{0 ,5 ,5 ,5 ,5 ,2 ,2 ,3 ,1 ,1 ,1 ,1 ,2 ,4 ,2 ,2 ,2 ,4 ,2 ,1 ,1 ,1 ,1 ,3 ,2 ,2 ,5 ,5 ,5 ,5 ,5 },
			{5 ,6 ,5 ,5 ,5 ,2 ,0 ,0 ,3 ,1 ,1 ,2 ,1 ,4 ,1 ,1 ,1 ,4 ,1 ,2 ,1 ,1 ,3 ,0 ,0 ,2 ,5 ,5 ,6 ,6 ,0 },
			{6 ,6 ,5 ,5 ,5 ,2 ,2 ,0 ,0 ,3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,3 ,0 ,0 ,2 ,2 ,5 ,6 ,6 ,6 ,6 },
			{6 ,6 ,6 ,5 ,5 ,2 ,2 ,0 ,0 ,0 ,3 ,3 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,3 ,3 ,0 ,0 ,0 ,2 ,2 ,6 ,6 ,5 ,6 ,6 },
			{6 ,5 ,6 ,6 ,6 ,5 ,2 ,2 ,4 ,0 ,0 ,0 ,3 ,3 ,3 ,3 ,3 ,3 ,3 ,0 ,0 ,0 ,4 ,2 ,2 ,5 ,6 ,5 ,5 ,5 ,6 },
			{5 ,5 ,5 ,5 ,6 ,5 ,4 ,2 ,0 ,0 ,0 ,0 ,2 ,2 ,0 ,0 ,0 ,2 ,2 ,0 ,0 ,0 ,0 ,2 ,4 ,5 ,5 ,5 ,6 ,5 ,5 },
			{5 ,5 ,5 ,5 ,6 ,5 ,0 ,4 ,5 ,0 ,0 ,0 ,2 ,2 ,0 ,0 ,0 ,2 ,2 ,0 ,0 ,0 ,0 ,4 ,5 ,5 ,5 ,6 ,6 ,6 ,5 },
			{6 ,6 ,5 ,6 ,5 ,0 ,5 ,5 ,5 ,0 ,0 ,2 ,2 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,0 ,0 ,0 ,0 ,5 ,5 ,6 ,6 ,6 ,6 ,5 },
			{6 ,6 ,6 ,6 ,5 ,5 ,5 ,5 ,5 ,0 ,0 ,2 ,2 ,4 ,0 ,0 ,0 ,4 ,2 ,2 ,0 ,0 ,0 ,0 ,5 ,6 ,6 ,6 ,6 ,5 ,5 },
			{6 ,6 ,6 ,6 ,6 ,7 ,6 ,6 ,5 ,0 ,2 ,2 ,2 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,2 ,0 ,0 ,0 ,5 ,6 ,6 ,7 ,5 ,6 ,6 },
			{6 ,6 ,6 ,7 ,7 ,7 ,6 ,6 ,6 ,4 ,2 ,2 ,4 ,0 ,0 ,0 ,0 ,0 ,4 ,2 ,2 ,4 ,0 ,5 ,6 ,6 ,7 ,7 ,6 ,5 ,5 },
			{6 ,7 ,7 ,7 ,7 ,7 ,6 ,5 ,6 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,5 ,5 ,6 ,6 ,7 ,7 ,7 ,6 ,5 },
			{6 ,7 ,7 ,7 ,7 ,6 ,5 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,7 ,7 ,7 ,7 ,7 ,7 ,6 },
			{7 ,7 ,7 ,7 ,6 ,5 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,7 ,7 ,7 ,5 ,5 ,6 },
			{7 ,7 ,7 ,6 ,5 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,7 ,6 ,6 ,5 ,5 }};



	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("goblin.png");


		x = 0;
		y = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		for(int r = 0; r < canvas.length; r++){
			for(int c = 0; c < canvas[r].length; c++){
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(canvas[r][c]).getTexture(),c*Tile.ON_SCREEN_DEFAULT_WIDTH, Gdx.graphics.getHeight()-Tile.ON_SCREEN_DEFAULT_HEIGHT-(r*Tile.ON_SCREEN_DEFAULT_HEIGHT));
			}
		}
		batch.draw(img, 25,635);
		batch.draw(img, 375,735);
		batch.draw(img, 740,635);
		batch.end();

		//checkInput();


	}
/*
	public void checkInput(){
		if (x < ( Gdx.input.getX() - img.getWidth()/2)) {
			x+=15;
		}
		if(x > (Gdx.input.getX() - img.getWidth() / 2)) {
			x-=15;
		}
		if(y < (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2)) {
			y+=15;
		}
		if(y > (Gdx.graphics.getHeight() - Gdx.input.getY() - (img.getHeight() / 2))) {
			y-=15;
		}

	}*/




	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
