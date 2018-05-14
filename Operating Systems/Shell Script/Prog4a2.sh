#Write a shell script to find factorial of any number using function

echo -n "Enter a number: "
read num

factorial()
{
	fact=1
	var=$1
	while [ $var -ge 1 ] 
	do
		fact=`expr $fact \* $var`
		var=`expr $var - 1`
	done

	return $[ $fact ]
}
factorial $num
fact=$?
echo Factorial of $num is $fact
