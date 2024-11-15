package com.diniig.samples.gof.structural;

public class RemoteWithMuteImpl implements RemoteWithMute {
    private Remote remote;

    public RemoteWithMuteImpl(Remote remote) {
        this.remote = remote;
    }

    @Override
    public void volumeUp() {
        remote.volumeUp();
    }

    @Override
    public void volumeDown() {
        remote.volumeDown();
    }

    @Override
    public void on() {
        remote.on();
    }

    @Override
    public void off() {
        remote.off();
    }

    @Override
    public void mute() {
        remote.volume(0);
    }

    @Override
    public void volume(int a) {
        remote.volume(a);
    }
}
