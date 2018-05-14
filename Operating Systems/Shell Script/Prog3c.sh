echo -e " 1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division \n Any other key to exit"
echo -n "Enter your choice: "
read choice

echo -n "Enter first number: "
read num1

echo -n "Enter second number: "
read num2

if [ $choice -eq 1 ]
then
	echo "Sum is $((num1+num2))"
elif [ $choice -eq 2 ]
then
	echo "Difference is $((num1-num2))"
elif [ $choice -eq 3 ]
then
	echo "Product is $((num1*num2))"
elif [ $choice -eq 4 ]
then
	echo "Quotient is $((num1/num2))"
	echo "Remainder is $((num1%num2))"
else
	exit 1
fi
