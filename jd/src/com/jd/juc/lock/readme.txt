1. 假唤醒：不明原因导致线程从wait()中醒来，一般通过while(flag)来防止假唤醒
2. 错过信号: 线程在调用wait前，唤醒信号notify就已经发出，一般在锁里记录信号状态
3.