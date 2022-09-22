package com.posed.lspd.util;

import android.content.ContentResolver;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.UserHandle;
import android.util.Log;

import com.posed.lspd.service.ConfigFileManager;
import com.posed.lspd.service.PackageService;
import com.posed.lspd.service.ServiceManager;

import androidx.annotation.Nullable;
import hidden.HiddenApiBridge;

public class FakeContext extends ContextWrapper {
    static ApplicationInfo systemApplicationInfo = null;
    static Resources.Theme theme = null;
    private String packageName = "android";

    public FakeContext() {
        super(null);
    }

    public FakeContext(String packageName) {
        super(null);
        this.packageName = packageName;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public Resources getResources() {
        return ConfigFileManager.getResources();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        try {
            if (systemApplicationInfo == null)
                systemApplicationInfo = PackageService.getApplicationInfo("android", 0, 0);
        } catch (Throwable e) {
            Log.e(ServiceManager.TAG, "getApplicationInfo", e);
        }
        return systemApplicationInfo;
    }

    @Override
    public ContentResolver getContentResolver() {
        return null;
    }

    public int getUserId() {
        return 0;
    }

    public UserHandle getUser() {
        return HiddenApiBridge.UserHandle(0);
    }

    @Override
    public Resources.Theme getTheme() {
        if (theme == null) theme = getResources().newTheme();
        return theme;
    }

    @Nullable
    @Override
    public String getAttributionTag() {
        return null;
    }
}
