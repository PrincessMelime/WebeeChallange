package com.webee.challange.data.remote;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.MalformedJsonException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.webee.challange.R;
import com.webee.challange.WebeeChallangeApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 *
 *  A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 * */

public abstract class NetworkBoundResource<T, V> {

    private final MediatorLiveData<Resource<T>> result = new MediatorLiveData<>();


        protected NetworkBoundResource() {
            result.postValue(Resource.loading(null));

            // Always load the data from DB intially so that we have
            LiveData<T> dbSource = loadFromDb();
            // Fetch the data from network and add it to the resource
            try {
                result.addSource(dbSource, data -> {
                    result.removeSource(dbSource);
                    if (shouldFetch()) {
                        fetchFromNetwork(dbSource);
                    } else {
                        result.addSource(dbSource, newData -> {
                            if(null != newData)
                                result.postValue(Resource.success(newData)); ;
                        });
                    }
                });

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        /**
         * This method fetches the data from remoted service and save it to local db
         * @param dbSource - Database source
         */
        private void fetchFromNetwork(final LiveData<T> dbSource) {
            result.addSource(dbSource, newData -> result.postValue(Resource.loading(newData)));
            createCall().enqueue(new Callback<V>() {
                @Override
                public void onResponse(@NonNull Call<V> call, @NonNull Response<V> response) {
                    result.removeSource(dbSource);
                    saveResultAndReInit(response.body());
                }

                @Override
                public void onFailure(@NonNull Call<V> call, @NonNull Throwable t) {
                    result.removeSource(dbSource);
                    result.addSource(dbSource, newData -> result.postValue(Resource.error(getCustomErrorMessage(t), newData)));
                }
            });
        }

        private String getCustomErrorMessage(Throwable error){

            if (error instanceof SocketTimeoutException) {
                return WebeeChallangeApp.getAppContext().getString(R.string.requestTimeOutError);
            } else if (error instanceof MalformedJsonException) {
                return  WebeeChallangeApp.getAppContext().getString(R.string.responseMalformedJson);
            } else if (error instanceof IOException) {
                return  WebeeChallangeApp.getAppContext().getString(R.string.networkError);
            } else if (error instanceof HttpException) {
                return (((HttpException) error).response().message());
            } else {
                return WebeeChallangeApp.getAppContext().getString(R.string.unknownError);
            }

        }

        @SuppressLint("StaticFieldLeak")
        @MainThread
        private void saveResultAndReInit(V response) {
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... voids) {

                    saveCallResult(response);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    result.addSource(loadFromDb(), newData -> {
                        if (null != newData)
                            result.postValue(Resource.success(newData));
                    });
                }
            }.execute();
        }

        @WorkerThread
        protected abstract void saveCallResult(V item);

        @MainThread
        private boolean shouldFetch() {
            return true;
        }

        @NonNull
        @MainThread
        protected abstract LiveData<T> loadFromDb();

        @NonNull
        @MainThread
        protected abstract Call<V> createCall();

        public final LiveData<Resource<T>> getAsLiveData() {
            return result;
        }
}
