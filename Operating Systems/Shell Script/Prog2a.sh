#Write a shell script to calculate addition of two numbers
echo -n "Enter first number: "
read num1
echo -n "Enter second number: "
read num2
sum=`expr $num1 + $num2`
echo "Sum of $num1 and $num2 is $sum"
