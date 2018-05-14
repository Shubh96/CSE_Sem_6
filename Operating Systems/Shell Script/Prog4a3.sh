#Write a shell script to find whether a give number is prime or not using function

echo -n "Enter a number: "
read num
checkPrime(){
	i=2
	while [ $i -lt `expr $num / 2` ] 
	do
		if [ `expr $num % $i` -eq 0 ]
		then
			echo "$num is not prime"
			exit 1
		fi
	done
	echo "$num is prime"
}
checkPrime $num
