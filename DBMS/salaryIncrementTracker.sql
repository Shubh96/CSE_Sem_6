DECLARE
	CURSOR CUR IS
		SELECT * FROM Empl_86
		WHERE Dept_No = 20;

	val CUR%ROWTYPE;

	raise NUMBER:= 0.05;
	raisedSalary NUMBER;
BEGIN
	OPEN CUR;
	
	LOOP
		FETCH CUR INTO val;
		EXIT WHEN CUR%NOTFOUND;

		raisedSalary := raise*val.Salary;

		INSERT INTO Emp_Raise_86
		VALUES(val.EMP_CODE, raisedSalary, SYSDATE);

		UPDATE Empl_86
		SET Salary = val.Salary + raisedSalary
		WHERE EMP_CODE = val.EMP_CODE;
	END LOOP;
END;
/