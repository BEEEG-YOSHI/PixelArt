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
import com.bmhs.gdxintro.gfx.utils.TileHandler;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;

	int x,y;

	//Colors:
	//
	int[][] canvas = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};


	@Override
	public void create () {
		batch = new SpriteBatch();



		x = 0;
		y = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		for(int r = 0; r < canvas.length; r++){
			for(int c = 0; c < canvas[r].length; c++){
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(canvas[r][c]).getTexture(),c*64, Gdx.graphics.getHeight()-64-(r*64));
			}
		}

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
