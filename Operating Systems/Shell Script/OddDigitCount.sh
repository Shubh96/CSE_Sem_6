count=0
num=$1
while [ $num -ne 0 ]; do
	if [ "$((($num%10)%2))" -ne 0 ]; then
		count=`expr $count + 1`
	fi
	num=`expr $num / 10`
done
echo "Odd Digits:" $count
