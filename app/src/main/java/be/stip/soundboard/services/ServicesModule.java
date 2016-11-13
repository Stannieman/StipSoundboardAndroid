package be.stip.soundboard.services;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public IAssetService provideIAssetService(Context context) {
        return new AssetService(context);
    }

    @Provides
    public ISoundPlayService provideISoundPlayService(IAssetService assetService) {
        return new SoundPlayService(assetService);
    }
}
