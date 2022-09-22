package com.posed.lspd.service;

import com.posed.lspd.models.Module;

interface ILSPApplicationService {
    IBinder requestModuleBinder(String name);

    List<Module> getModulesList();

    String getPrefsPath(String packageName);

    Bundle requestRemotePreference(String packageName, int userId, IBinder callback);

    ParcelFileDescriptor requestInjectedManagerBinder(out List<IBinder> binder);
}
