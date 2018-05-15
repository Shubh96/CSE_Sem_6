#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
#define NTHREADS 5

void makeCall(void *tid){
	int tn = *(int *)tid;
	printf("Method called by %d ", tn);
	pthread_exit(NULL);
}

int main(){
	int rc, i, j, detachState;
	
	pthread_t tid;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
	
	for(j=0; j<NTHREADS; j++)
		rc = pthread_create(&tid, &attr, makeCall, &tid);
	
	if(rc){
		printf("ERROR! Return code from pthread_create() is %d ", rc);
		exit(-1)
	}
	
	rc = pthread_join(tid,NULL);
	
	if(rc){
		printf("ERROR! Return code from pthread_join() is %d ", rc);
		exit(-1);
	}
	
	pthread_attr_destroy(&attr);
	pthread_exit(NULL);
}