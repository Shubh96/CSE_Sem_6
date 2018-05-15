#Write a shell script to calculate addition of two numbers using function

echo -n "Enter first number: "
read num1
echo -n "Enter second number: "
read num2

add(){
	echo `expr $1 + $2`
}

sum=$(add $num1 $num2)
echo "Sum of $num1 and $num2 is $sum"
