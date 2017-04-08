package csu.lecture_5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by R00We on 06/04/17.
 */

public class RXActivity extends MainActivity {
    Observable<Integer> observable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        observable = Observable.just(5,4,3,2,1);
//        observable = new Observable<Integer>() {
//            @Override
//            protected void subscribeActual(Observer<? super Integer> observer) {
//                int input = getInput();
//                for (int i = input; i > 0; i--) {
//                    observer.onNext(i);
//                    MainActivity.delayOneSecond();
//                    Log.d(TAG, "onNext - "+i);
//                }
//                observer.onComplete();
//            }
//        };
        observable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void go(View view) {
//        observable.subscribe();
        observable
                .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {
                setValue(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
