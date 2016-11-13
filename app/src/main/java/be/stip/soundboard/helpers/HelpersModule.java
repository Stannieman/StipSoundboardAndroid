package be.stip.soundboard.helpers;

import dagger.Module;
import dagger.Provides;

@Module
public class HelpersModule {

    @Provides
    public ISoundHelper provideISoundHelper() {
        return new SoundHelper();
    }
}
