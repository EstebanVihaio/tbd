package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class SplashScreen implements Screen
{
	// Fields
	private TowerBridgeDefense game;
	
	
	// Properties
	
	
	
	// Constructor
	public SplashScreen(TowerBridgeDefense game)
	{
		this.game = game;
	}
	
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(1f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Door het indrukken van de spatiebalk ga je naar de gameScreen toestand
		if ( Gdx.input.isKeyPressed(Keys.SPACE))
		{
			this.game.setScreen(this.game.getGameScreen());			
		}
	}

	@Override
	public void resize(int width, int height) 
	{
		
	}

	@Override
	public void show() 
	{
		
	}

	@Override
	public void hide() 
	{
		
	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}
	
}
