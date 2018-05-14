#Write a shell script to generate Fibonacci Series
echo -n "Enter series length: "
read len
a=0
b=1
var=1
while [ $var -le $len ] 
do
	if [ $var -eq 1 ]
	then
		echo -e -n "$a"
	elif [ $var -eq 2 ]
	then
		echo -e -n "\t$b"
	else
		c=`expr $a + $b`
		a=$b
		b=$c
		echo -e -n "\t$c"
	fi
	var=`expr $var + 1`
done
