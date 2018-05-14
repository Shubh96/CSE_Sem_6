#include <unistd.h>
#include <stdio.h>

int main(){
	
	printf("\nIn the parent process now");
	printf("\nAbout to invoke fork().");

	int forked = fork();
	int cpid, ppid;

	if(forked<0)
	{
		printf("\nfork() invoke unsuccessful");
	}
	else if(forked==0)
	{
		cpid = getpid();
		ppid = getppid();
		printf("\nforked!!! Inside child now.");
		printf("\nPID: %d\nPPID: %d\n", cpid, ppid);
		system("ps -eo pid,ppid,stat,comm");
	}
	else
	{
		ppid = getpid();		
		printf("\nforked!!! Within parent now.");
		printf("\nPPID: %d\n", ppid);
	}
	return 0;
}
