SET SERVEROUTPUT ON

ACCEPT N NUMBER PROMPT 'ENTER A VALUE: '

DECLARE
	N NUMBER:=&N;
	FLAG NUMBER:= 0;
BEGIN
	FOR I IN 2..N/2
	LOOP
		IF N MOD I = 0 THEN
			FLAG:= 1;
			EXIT;
		END IF;
	END LOOP;

	IF FLAG = 1 THEN
		DBMS_OUTPUT.PUT_LINE(N || ' is composite');
	ELSE
		DBMS_OUTPUT.PUT_LINE(N || ' is prime');
	END IF;
END;
/