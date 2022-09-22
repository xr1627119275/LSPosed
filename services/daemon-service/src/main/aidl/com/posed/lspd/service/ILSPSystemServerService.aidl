package com.posed.lspd.service;

import com.posed.lspd.service.ILSPApplicationService;

interface ILSPSystemServerService {
    ILSPApplicationService requestApplicationService(int uid, int pid, String processName, IBinder heartBeat);
}
