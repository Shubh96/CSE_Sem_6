echo -n "Enter the filename: "
read filename
fileMod(){
	if [ -f $filename ]
	then
		echo -n "$filename was modified last on "
		date -r $filename
	else
		echo "I am afraid $filename doesn't exist"
	fi
}

fileMod $fileName
