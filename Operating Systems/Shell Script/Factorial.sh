#Write a shell script to find factorial of any number
echo -n "Enter a number: "
read num
fact=1
var=$num
while [ $var -ge 1 ] 
do
	fact=`expr $fact \* $var`
	var=`expr $var - 1`
done
echo "Factorial of $num is $fact"
