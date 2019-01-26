package io.synople.csmusic.model;

import java.util.Random;

public class NoteBlock extends Block {

    //Key of C
    String[] keyC = {"C", "D", "E", "F", "G", "A", "B", "C"};

    //Key of D
    String[] keyD = {"D", "E", "F#", "G", "A", "B", "C#", "D"};

    //Key of G
    String[] keyG = {"G", "A", "B", "C", "D", "E", "F#", "G"};

    //all keys
    String[][] keys = {keyC, keyD, keyG};

    //all octaves
    String[] octStrings = {"3", "4", "5"};

    //all lengths
    String[] countStrings = {"i", "q", "h", "w"};

    private int key, nameNum, oct, counts;

    // filename format is Name + Number + Count + .wav
    private String fileName;
    private final String wav = ".wav";

    public NoteBlock() {
        Random rand = new Random();
        key = rand.nextInt(3);
        nameNum = rand.nextInt(8);
        oct = rand.nextInt(3);
        if (nameNum == 8) {
            oct++;
        }
        counts = rand.nextInt(4);
        fileName = setFileName(key, nameNum, oct, counts);
    }

    public NoteBlock(int keyIn, int nameNumIn, int octIn, int countsIn) {
        key = keyIn;
        nameNum = nameNumIn;
        oct = octIn;
        counts = countsIn;
        fileName = setFileName(key, nameNum, oct, counts);

    }

    public String getFileName() {
        return fileName;
    }

    public String setFileName(int keyIn, int nameNumIn, int octIn, int countsIn) {
        return keys[keyIn][nameNumIn] + octStrings[octIn] + countStrings[countsIn];
    }

    public String toString() {
        return "" + keys[key][nameNum] + "" + octStrings[oct] + "" + countStrings[counts];
    }
}
