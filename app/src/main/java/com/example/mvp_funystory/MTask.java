package com.example.mvp_funystory;


import android.os.AsyncTask;

public class MTask extends AsyncTask<Object, Object, Object> {
    private String key;
    private OnMTaskCallBack callBack;

    public MTask(String key, OnMTaskCallBack callBack) {
        this.key = key;
        this.callBack = callBack;
    }



    @Override
    protected void onPreExecute() {
        callBack.initFirst(key);
    }

    @Override
    protected Object doInBackground(Object... data) {
        return callBack.execTask(key, data[0], this);
    }

    public void requestUpdate(Object data) {
        publishProgress(data);
    }

    @Override
    protected void onProgressUpdate(Object... values) {
        callBack.updateUI(key, values[0]);
    }

    @Override
    protected void onPostExecute(Object rs) {
        callBack.completeTask(key, rs);
    }

    public interface OnMTaskCallBack {
        default void initFirst(String key) {
            //do nothing
        }

        Object execTask(String key, Object data, MTask task);

        default void updateUI(String key, Object data) {
            //do nothing
        }

        default void completeTask(String key, Object data) {
            //do nothing
        }
    }

    public void start(Object object){
        execute(object);
    }
    public void startAsync(Object object){
        executeOnExecutor(THREAD_POOL_EXECUTOR, object);
    }
    public void stop(){
        cancel(true);
    }
}

