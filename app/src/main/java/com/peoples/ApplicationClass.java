package com.peoples;

import android.support.multidex.MultiDexApplication;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.peoples.di.DaggerWebServiceComponent;
import com.peoples.di.WebServiceComponent;
import com.peoples.di.WebServiceModule;

public class ApplicationClass extends MultiDexApplication {
    private static ApplicationClass instance;
    private static WebServiceComponent webServiceComponent;

    public static synchronized ApplicationClass getInstance() {
        return instance;
    }

    public static synchronized WebServiceComponent getNetComponent() {
        return webServiceComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        resolveDependencies();
        initImageConfig();
    }

    private void initImageConfig() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .displayer(new FadeInBitmapDisplayer(500))
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .writeDebugLogs()
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(config);
    }

    private void resolveDependencies() {
        webServiceComponent = DaggerWebServiceComponent.builder()
                .webServiceModule(new WebServiceModule(BuildConfig.BASE_URL))
                .build();
    }
}
