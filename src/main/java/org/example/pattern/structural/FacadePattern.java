package org.example.pattern.structural;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class DVDPlayer {

    public void switchOn() {
        System.out.println("Switching the DVD player on");
    }

    public void playMovie(String movieName) {
        System.out.println("Now playing: " + movieName);
    }

    public void switchOff() {
        System.out.println("Switching off the DVD player");
    }
}

@AllArgsConstructor
class Projector {

    public void switchOn() {
        System.out.println("Switching the projector on");
    }

    public void project(String inputType) {
        System.out.println("Projecting the input received from " + inputType);
    }

    public void switchOff() {
        System.out.println("Switching off the projector");
    }
}

@AllArgsConstructor
class SoundSystem {

    public void switchOn(String audioSource) {
        System.out.println("Switching the sound system on. Setting the audio source as " + audioSource);
    }

    public void setVolume(int volume) {
        System.out.println("Setting the volume to " + volume);
    }

    public void switchOff() {
        System.out.println("Switching off the sound system");
    }
}

@AllArgsConstructor
class HomeTheater {
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Projector projector;

    public void watchMovie(String movieName, String inputSource, int volume) {
        System.out.println("Get ready to watch a movie!");
        dvdPlayer.switchOn();
        soundSystem.switchOn(inputSource);
        soundSystem.setVolume(volume);
        projector.switchOn();
        projector.project(inputSource);
        dvdPlayer.playMovie(movieName);
        System.out.println("Enjoy the movie!");
    }

    public void stopMovie() {
        System.out.println("Movie ended");
        dvdPlayer.switchOff();
        projector.switchOff();
        soundSystem.switchOff();
    }
}
public class FacadePattern {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater(new DVDPlayer(), new SoundSystem(), new Projector());
        homeTheater.watchMovie("Beauty And The Beast", "DVD Player", 15);
        homeTheater.stopMovie();
    }
}
