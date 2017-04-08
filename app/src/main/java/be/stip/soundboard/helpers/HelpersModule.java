package be.stip.soundboard.helpers;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class HelpersModule {
    @Singleton
    @Binds
    public abstract ISoundHelper bindISoundHelper(SoundHelper soundHelper);
}
