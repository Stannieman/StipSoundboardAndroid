package be.stip.soundboard.services;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import javax.inject.Inject;

import stannieman.commonservices.models.DataServiceResult;
import stannieman.commonservices.models.GeneralResultCodes;
import stannieman.commonservices.models.IHasDataAndSuccessState;

public class AssetService implements IAssetService {
    @Inject
    Context context;

    @Inject
    public AssetService() {}

    public IHasDataAndSuccessState<AssetFileDescriptor> getFileDescriptorForAsset(String filePath){
        try {
            return new DataServiceResult<>(context.getAssets().openFd(filePath), GeneralResultCodes.OK);
        }
        catch (Exception e) {
            return new DataServiceResult<>(AssetServiceResultCodes.CannotGetAsset);
        }
    }
}
