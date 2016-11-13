package be.stip.soundboard.services;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import javax.inject.Inject;

public class AssetService implements IAssetService {

    private Context context;

    @Inject
    public AssetService(Context context){
        this.context = context;
    }

    public ServiceResult<AssetFileDescriptor> getFileDescriptorForAsset(String filePath){
        try {
            return new ServiceResult<>(context.getAssets().openFd(filePath));
        }
        catch (Exception e) {
            return new ServiceResult<>(false);
        }
    }
}
