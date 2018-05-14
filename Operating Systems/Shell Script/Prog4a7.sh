echo -e " 1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division \n Any other key to exit"
echo -n "Enter your choice: "
read choice

echo -n "Enter first number: "
read num1

echo -n "Enter second number: "
read num2

calculator(){
	if [ $1 -eq 1 ]
	then
		echo "Sum is `expr $2 + $3`"
	elif [ $1 -eq 2 ]
	then
		echo "Difference is `expr $2 - $3`"
	elif [ $1 -eq 3 ]
	then
		echo "Product is `expr $2 \* $3`"
	elif [ $1 -eq 4 ]
	then
		echo "Quotient is `expr $2 / $3`"
		echo "Remainder is `expr $2 % $3`"
	else
		exit 1
	fi
}

calculator $choice $num1 $num2
