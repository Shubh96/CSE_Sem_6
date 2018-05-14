#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<semaphore.h>

#define SIZE 5
#define NUM_THREADS 6
#define MAX_LOOPS 2

typedef int buffer_t;
buffer_t buffer[SIZE];

int buffer_index;
pthread_mutex_t buffer_mutex;
sem_t full_sem;
sem_t empty_sem;

void add_to_buffer(buffer_t value)
{	
	if(buffer_index < SIZE)
		buffer[buffer_index++] = value;
	else
		printf("\nBuffer Overflow");
}

buffer_t remove_from_buffer()
{
	if(buffer_index > 0)
		return buffer[--buffer_index];
	else
		printf("\nBuffer Underflow");
		
	return 0;
}

void *producer(void *thread_n)
{
	int thread_numb = *(int *)thread_n;
	buffer_t value;
	int i;
	
	while(i++ < MAX_LOOPS)
	{
		sleep(1);
		value = rand()%100;
		sem_wait(&full_sem);
		pthread_mutex_lock(&buffer_mutex);
		add_to_buffer(value);
		pthread_mutex_unlock(&buffer_mutex);
		sem_post(&empty_sem);
		
		printf("\nProducer %d added %d to buffer\n", thread_numb, value);
	}
	
	pthread_exit(0);
}

void *consumer(void *thread_n)
{
	int thread_numb = *(int *)thread_n;
	buffer_t value;
	int i;
	
	while(i++ < MAX_LOOPS)
	{
		sem_wait(&empty_sem);
		pthread_mutex_lock(&buffer_mutex);
		value = remove_from_buffer();
		pthread_mutex_unlock(&buffer_mutex);
		sem_post(&full_sem);
		
		printf("\nConsumer %d removed %d from buffer\n", thread_numb, value);
	}
	
	pthread_exit(0);
}

int main(int argc, char **argv)
{
	buffer_index = 0;
	
	pthread_mutex_init(&buffer_mutex, NULL);
	sem_init(&full_sem, 0, SIZE);
	sem_init(&empty_sem, 0, 0);
	
	pthread_t thread[NUM_THREADS];
	
	int thread_num[NUM_THREADS];
	int i;

	for(i=0; i<NUM_THREADS;)
	{
		thread_num[i] = i;
		pthread_create(&thread[i], NULL, producer, &thread_num[i]);
		i++;
		thread_num[i] = i;
		pthread_create(&thread[i], NULL, consumer, &thread_num[i]);
		i++;
	}
	
	for(i=0; i<NUM_THREADS;i++)
		pthread_join(thread[i], NULL);
		
	pthread_mutex_destroy(&buffer_mutex);
	sem_destroy(&full_sem);
	sem_destroy(&empty_sem);
	
	pthread_exit(0);
	
	return 0;
}
