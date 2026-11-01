// 2개의 동시 접근 허용을 가진 세마포어를 공정 모드로 생성
private Semaphore poolPermits = new Semaphore(2, true);