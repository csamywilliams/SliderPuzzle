package com.csaw.sliderpuzzle.tiles;

import android.graphics.Bitmap;

public class Tile {

	public int id;
	public Bitmap bitmap;
	public int position;
	public int x;
	public int y;
	
	
	public Tile(int id, Bitmap tile, int position, int x, int y)
	{
		this.bitmap = tile;
		this.id = id;
		this.position = position;
		this.x = x;
		this.y = y;
	}
	
}
