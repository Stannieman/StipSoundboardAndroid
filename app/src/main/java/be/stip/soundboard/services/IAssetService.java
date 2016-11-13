package be.stip.soundboard.services;

import android.content.res.AssetFileDescriptor;

public interface IAssetService {

    ServiceResult<AssetFileDescriptor> getFileDescriptorForAsset(String filePath);
}
