package mfteam.com.et2.viewmodel.splash;

import android.content.Context;

import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class SplashViewModel extends BaseViewModel{

    private SplashListener listener;

    public SplashViewModel(Context context, SplashListener listener) {
        super(context);
        this.listener = listener;
        startTimerToChangeFragment(3000);
    }

    private void startTimerToChangeFragment(long ms){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if (listener != null){
                            listener.onSplashFinished();
                        }
                    }
                },
                ms
        );
    }

    public interface SplashListener{
        void onSplashFinished();
    }
}
