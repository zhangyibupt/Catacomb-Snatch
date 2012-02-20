package com.mojang.mojam.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.mojang.mojam.level.LevelInformation;
import com.mojang.mojam.level.LevelList;
import com.mojang.mojam.screen.Screen;

public class LevelSelect extends GuiMenu {

	private ArrayList<LevelInformation> levels = LevelList.getLevels();	
	private int selectedIndex = 0;	
	private final int spacing = 15;
	private final int xStringPosition = 50;
	private final int yStringPosition = 50;
	private Button startGameButton;
	
	public LevelSelect() {
		super();
		TitleMenu.level = levels.get(0).levelFile;
		startGameButton = addButton(new Button(TitleMenu.START_GAME_ID, 0, 100, 180));
		addButton(new Button(TitleMenu.CANCEL_JOIN_ID, 4, 250, 180));
	}

	@Override
	public void render(Screen screen) {
		screen.clear(0);
		//Font.draw(screen, "Enter IP of Host:", 100, 100);
		drawLevelNames(screen);
		super.render(screen);
	}
	
	private void drawLevelNames(Screen screen) {
		
		for (int i = 0; i < levels.size(); i++) {
			int xpos = xStringPosition;
			if(selectedIndex == i)
				xpos += spacing;
			
			int ypos = yStringPosition + spacing * i;
			Font.draw(screen, levels.get(i).levelName, xpos, ypos);
		}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			selectedIndex--;
            if (selectedIndex < 0) {
            	selectedIndex = levels.size() - 1;
            }
        } else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
        	selectedIndex++;
            if (selectedIndex >= levels.size()) {
            	selectedIndex = 0;
            }
        }
		TitleMenu.level = levels.get(selectedIndex).levelFile;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
