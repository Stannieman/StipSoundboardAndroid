package be.stip.soundboard.services;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ServicesModule {
    @Singleton
    @Binds
    public abstract IAssetService bindIAssetService(AssetService assetService);

    @Singleton
    @Binds
    public abstract ISoundPlayService bindISoundPlayService(SoundPlayService soundPlayService);
}
