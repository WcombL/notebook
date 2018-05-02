package com.zrkj.unique.id;

import javax.sound.midi.Soundbank;
import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();

        System.out.println(uuid);
    }
}
