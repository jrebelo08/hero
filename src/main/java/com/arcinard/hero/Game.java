package com.arcinard.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

class Game {
    private Screen screen;
    private int x = 10;
    private int y = 10;

    Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')
                [0]);
        screen.refresh();
    }

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }

    }

    private void processKey(KeyStroke key) throws IOException {

            switch (key.getKeyType()) {
                case ArrowUp -> {
                    y--;
                    break;
                }
                case ArrowDown -> {
                    y++;
                    break;
                }
                case ArrowRight -> {
                    x++;
                    break;
                }
                case ArrowLeft -> {
                    x--;
                    break;
                }
            }
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                try{
                    screen.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
    }
}