package nl.xnagames.towerbridgedefense.beanman;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;


public class BeanmanIdleLeft extends AnimatedSprite
{
	// Fields
		private Beanman beanman;
		
		// Properties
			
		// Constructor
		public BeanmanIdleLeft(Beanman beanman)
		{
			super(beanman);
			this.beanman = beanman;
			this.Initialize();
		}
		
		public void Initialize()
		{
			this.frameSpeed = 1f/120f;
			for ( AtlasRegion region : this.beanman.getRegion())
			{
				if (!region.isFlipX())
				{
					region.flip(true, false);
				}
			}
		}		
			
		// Update method
		public void update(float delta)
		{
			if (Gdx.input.isKeyPressed(Keys.LEFT))
			{
				this.beanman.setState(this.beanman.getWalkLeft());
			}
			if (Gdx.input.isKeyPressed(Keys.RIGHT))
			{
				this.beanman.setState(this.beanman.getWalkRight());
			}
			else if (Gdx.input.isKeyPressed(Keys.SPACE))
			{
				this.beanman.setState(this.beanman.getIdleJumpLeft());
			}
			//super.update(delta);
		}
				
		// Draw method
		public void draw(float delta)
		{
			super.draw(delta);
		}

}
