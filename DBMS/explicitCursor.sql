DECLARE
	CURSOR CUR IS
		SELECT * FROM Circle_86;
	
	cnt CUR%ROWTYPE;
BEGIN
	OPEN CUR;
	
	LOOP
		FETCH CUR INTO cnt;
		EXIT WHEN CUR%NOTFOUND;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('Total Rows = ' || CUR%ROWCOUNT);
END;
/