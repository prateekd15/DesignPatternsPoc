package org.example.pattern.structural;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
class Radio {
    int volume;
    double frequency;

    public void playFM() {
        System.out.println("Now playing FM Radio on frequency: " + frequency + " with volume: " + volume);
    }
}

@AllArgsConstructor
class Mp3Player {
    int volume;
    String songName;

    public void playSong() {
        System.out.println("Now playing: " + songName + " with volume: " + volume);
    }
}

interface MusicPlayerAdapter {
    public void play();
}

@AllArgsConstructor
class Mp3PlayerAdapter implements MusicPlayerAdapter {

    Mp3Player mp3Player;
    public void play() {
        mp3Player.playSong();
    }
}

@AllArgsConstructor
class RadioAdapter implements MusicPlayerAdapter {
    Radio radio;

    public void play() {
        radio.playFM();
    }
}

public class AdapterPattern {

    public static void main(String[] args) {
        MusicPlayerAdapter playerAdapter = new Mp3PlayerAdapter(new Mp3Player(10, "Blank Space"));
        playerAdapter.play();
        playerAdapter = new RadioAdapter(new Radio(10, 91.3));
        playerAdapter.play();
    }
}
