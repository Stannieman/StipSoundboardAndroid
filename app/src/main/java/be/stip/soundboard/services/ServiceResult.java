package be.stip.soundboard.services;

public class ServiceResult<T> {

    //region response

    private T response;

    public void setResponse(T response){
        this.response = response;
    }

    public T getResponse(){
        return response;
    }

    //endregion

    //region isSuccessful

    private boolean isSuccessful;

    public boolean isSuccessful(){
        return isSuccessful;
    }

    //endregion

    //region message

    private String message;

    public String getMessage() { return message; }

    //endregion

    public ServiceResult(T response){
        isSuccessful = true;
        this.response = response;
    }

    public ServiceResult(boolean isSuccessful){
        this.isSuccessful = isSuccessful;
    }

    public ServiceResult(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }
}
