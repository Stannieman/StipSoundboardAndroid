package be.stip.soundboard.helpers;

import java.util.LinkedList;
import java.util.List;

import be.stip.soundboard.models.Sound;

public class SoundHelper implements ISoundHelper {

    public List<Sound> getSounds() {
        List<Sound> sounds = new LinkedList<Sound>();

        sounds.add(new Sound("Doe is normaal!", "doeIsNormaal"));
        sounds.add(new Sound("Heey daar is die lens jom!", "heeyDaarIsDieLensJom"));
        sounds.add(new Sound("Flipse papegaai", "flipsePapegaai"));
        sounds.add(new Sound("Ik zen hiejelemaal eweg", "ikZenHiejelemaalEweg"));
        sounds.add(new Sound("Flipse awel jom…", "flipseAwelJom"));
        sounds.add(new Sound("Hey matekes", "heyMatekes"));
        sounds.add(new Sound("Geflitsth", "geflitsth"));
        sounds.add(new Sound("Kop tegen schilderij", "kopTegenSchilderij"));
        sounds.add(new Sound("Ozze papa hoert da nie", "ozzePapaHoertDaNie"));
        sounds.add(new Sound("Papaa!", "papaa"));
        sounds.add(new Sound("Pussycat", "pussycat"));
        sounds.add(new Sound("Stannie is porno", "stannieIsPorno"));
        sounds.add(new Sound("De miekes", "deMiekes"));

        return sounds;
    }
}
