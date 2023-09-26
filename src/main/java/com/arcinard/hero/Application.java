package com.arcinard.hero;

import java.io.IOException;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Application {
    public static void main(String[] args) {
        try {
            Terminal terminal = new
                    DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if

            screen.clear();
            screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')
                    [0]);
            screen.refresh();

        } catch (IOException ola) {
            ola.printStackTrace();
        }
        TerminalSize terminalSize = new TerminalSize(40, 20);
    }
}
