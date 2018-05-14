echo "Enter a string: "
read string

printf "Vowel count: "
echo $string|grep -oi "[aeiou]"|wc -l
printf "Consonant count: "
echo $string|grep -oi "[b-df-hj-np-tv-z]"|wc -l
