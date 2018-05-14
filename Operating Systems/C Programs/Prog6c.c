#include <unistd.h>
#include<stdio.h>

int main()
{
	int forked;
	int cpid, ppid, pid;
	
	forked = fork();
	
	if (forked<0)
	{
		printf("\nCouldn't fork()");
	}
	else if (forked == 0)
	{
		printf("\nChild executing..");
		cpid = getpid();
		ppid = getppid();
		printf("\nCPID: %d", cpid);
		printf("\nPPID: %d\n", ppid);
	}
	else
	{
		printf("\nParent process sleeping..");
		sleep(3);
		pid = getpid();
		printf("\nPID: %d\n", pid);
	}
	
	return 0;
}

