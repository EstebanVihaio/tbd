package nl.xnagames.towerbridgedefense.bus;

import java.util.HashMap;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class Bus implements Animation
{
	// Fields
	private TowerBridgeDefense game;
	private AtlasRegion singleFrame;
	private float scaleFactor;
	private float size;
	private BusDriveLeft driveLeft;
	private BusDriveRight driveRight;
	private AnimatedSprite state;
	private float speed = 3;
	private Vector2 position;
	// HashMap koppelt een String aan een AtlasRegion
	private HashMap<String, AtlasRegion> region;
	
	// Properties
	public TowerBridgeDefense getGame()
	{
		return this.game;
	}	
	public float getScaleFactor()
	{
		return this.scaleFactor;
	}	
	public float getSize()
	{
		return this.size;
	}
	public float getSpeed()
	{
		return this.speed;
	}
	public Vector2 getPosition()
	{
		return this.position;
	}
	public void setPosition(Vector2 position)
	{
		this.position = position;
	}
	public void setState(AnimatedSprite state)
	{
		this.state = state;
	}
	public BusDriveLeft getDriveLeft()
	{
		this.driveLeft.Initialize();
		return this.driveLeft;
	}
	public BusDriveRight getDriveRight()
	{
		this.driveRight.Initialize();
		return this.driveRight;
	}
	public HashMap<String, AtlasRegion> getRegion()
	{
		return this.region;
	}
	
	
	
	// Constructor
	public Bus(TowerBridgeDefense game, Vector2 position, String name)
	{
		this.game = game;
		this.position = position;
		
		// We maken een instantie van de HashMap die we koppelen aan this.region
		this.region = new HashMap<String, AtlasRegion>();
		
		// We vullen de HashMap met de naam en region van elk frame
		for (int i = 1; i <= 7; i++)
		{
			this.region.put(game.getAtlas().findRegion("bus000" + Integer.toString(i)).name,
							game.getAtlas().findRegion("bus000" + Integer.toString(i)));
		}
		
		this.driveLeft = new BusDriveLeft(this);
		this.driveRight = new BusDriveRight(this);
		this.singleFrame = game.getAtlas().findRegion("bus000" + Integer.toString(3));
		this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
		this.size = 192f;
		this.state = this.driveRight;
	}
	
	// Update method
	public void update(float delta)
	{
		this.state.update(delta);
	}
	
	// Draw method
	public void draw(float delta)
	{
		this.state.draw(delta);
	}
}
