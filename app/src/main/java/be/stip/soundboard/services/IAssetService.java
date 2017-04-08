package be.stip.soundboard.services;

import android.content.res.AssetFileDescriptor;

import stannieman.commonservices.models.IHasDataAndSuccessState;

public interface IAssetService {
    IHasDataAndSuccessState<AssetFileDescriptor> getFileDescriptorForAsset(String filePath);
}
