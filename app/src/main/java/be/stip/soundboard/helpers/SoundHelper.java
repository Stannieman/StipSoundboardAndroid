package be.stip.soundboard.helpers;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import be.stip.soundboard.models.Sound;

public class SoundHelper implements ISoundHelper {

    @Inject
    public SoundHelper() {}

    public List<Sound> getSounds() {
        List<Sound> sounds = new LinkedList<Sound>();

        sounds.add(new Sound("Doe is normaal!", "doeIsNormaal", 'a'));
        sounds.add(new Sound("Heey daar is die lens jom!", "heeyDaarIsDieLensJom", 'b'));
        sounds.add(new Sound("Flipse papegaai", "flipsePapegaai", 'c'));
        sounds.add(new Sound("Ik zen hiejelemaal eweg", "ikZenHiejelemaalEweg", 'd'));
        sounds.add(new Sound("Flipse awel jom…", "flipseAwelJom", 'e'));
        sounds.add(new Sound("Hey matekes", "heyMatekes", 'f'));
        sounds.add(new Sound("Geflitsth", "geflitsth", 'g'));
        sounds.add(new Sound("Kop tegen schilderij", "kopTegenSchilderij", 'h'));
        sounds.add(new Sound("Ozze papa hoert da nie", "ozzePapaHoertDaNie", 'i'));
        sounds.add(new Sound("Papaa!", "papaa", 'j'));
        sounds.add(new Sound("Pussycat", "pussycat", 'k'));
        sounds.add(new Sound("Stannie is porno", "stannieIsPorno", 'l'));
        sounds.add(new Sound("De miekes", "deMiekes", 'm'));
        sounds.add(new Sound("Zwijgeeeeuh", "zwijgeeeeuh", 'n'));
        sounds.add(new Sound("Annalisa leren", "annalisaLeren", 'o'));
        sounds.add(new Sound("Vlieger", "vlieger", 'p'));
        return sounds;
    }
}
