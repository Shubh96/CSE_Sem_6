CREATE OR REPLACE TRIGGER TRI86 BEFORE INSERT OR UPDATE OR DELETE ON CLIENT_MASTER86
FOR EACH ROW

BEGIN
	IF UPDATING THEN 
		INSERT INTO AUDIT_CLIENT86 VALUES(:OLD.CLIENT_NO, :OLD.NAME, :OLD.BAL_DUE, 'UPDATE', USER, SYSDATE);
	ELSIF DELETING THEN
		INSERT INTO AUDIT_CLIENT86 VALUES(:OLD.CLIENT_NO, :OLD.NAME, :OLD.BAL_DUE, 'DELETE', USER, SYSDATE);
	END IF;
END;
/
		