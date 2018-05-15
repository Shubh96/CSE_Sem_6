#include<stdio.h>
#include<unistd.h>

void main(){
	char *path = "/home/student/temp.out";
	char *fileName = "temp.out";
	
	execl(path, fileName, " ", 0);
	execl("/bin/ps", "ps", "ax", 0);
}